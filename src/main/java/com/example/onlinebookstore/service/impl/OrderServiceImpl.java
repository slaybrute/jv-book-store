package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.dto.order.CreateOrderDto;
import com.example.onlinebookstore.dto.order.OrderResponseDto;
import com.example.onlinebookstore.dto.order.UpdateOrderStatusDto;
import com.example.onlinebookstore.dto.orderitem.OrderItemResponseDto;
import com.example.onlinebookstore.mapper.OrderItemMapper;
import com.example.onlinebookstore.mapper.OrderMapper;
import com.example.onlinebookstore.model.CartItem;
import com.example.onlinebookstore.model.Order;
import com.example.onlinebookstore.model.OrderItem;
import com.example.onlinebookstore.model.Status;
import com.example.onlinebookstore.model.User;
import com.example.onlinebookstore.repository.order.OrderRepository;
import com.example.onlinebookstore.repository.orderitem.OrderItemRepository;
import com.example.onlinebookstore.repository.status.StatusRepository;
import com.example.onlinebookstore.repository.user.UserRepository;
import com.example.onlinebookstore.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final StatusRepository statusRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public OrderResponseDto createOrder(Authentication authentication,
                                        CreateOrderDto createOrderDto) {
        User user = (User) authentication.getPrincipal();
        Set<OrderItem> orderItems = new HashSet<>();
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem cartItem : user.getShoppingCart().getCartItems()) {
            OrderItem orderItem = orderItemMapper.toModel(cartItem);
            orderItems.add(orderItem);
            totalPrice = totalPrice.add(orderItem.getPrice());
        }
        Order order = new Order();
        order.setUser(user);
        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems);
        user.addOrder(order);
        user.cleanShoppingCart();
        userRepository.save(user);
        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderResponseDto> getAllOrders(Authentication authentication, Pageable pageable) {
        User user = (User) authentication.getPrincipal();
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        for (Order order : orderRepository.findByUser(pageable, user)) {
            orderResponseDtos.add(orderMapper.toDto(order));
        }
        return orderResponseDtos;
    }

    @Override
    public OrderResponseDto updateOrder(UpdateOrderStatusDto updateOrderStatusDto, Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Order not found by id: " + id));
        Status status = statusRepository.findByStatusName(updateOrderStatusDto.getStatus())
                .orElseThrow(() -> new EntityNotFoundException("Cannot find status by name: "
                        + updateOrderStatusDto.getStatus().name()));
        order.setStatus(status);
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public List<OrderItemResponseDto> getAllOrderItemsById(Authentication authentication, Long id) {
        User user = (User) authentication.getPrincipal();
        Order order = getUserOrderById(user, id);
        List<OrderItemResponseDto> orderItemResponseDtos = new ArrayList<>();
        for (OrderItem orderItem : orderItemRepository.findByOrder(order)) {
            orderItemResponseDtos.add(orderItemMapper.toDto(orderItem));
        }
        return orderItemResponseDtos;
    }

    @Override
    public OrderItemResponseDto getOrderItemById(Authentication authentication,
                                                 Long orderId, Long itemId) {
        User user = (User) authentication.getPrincipal();
        Order order = getUserOrderById(user, orderId);
        return orderItemMapper.toDto(getOrderItemByOrderAndId(order, itemId));
    }

    private Order getUserOrderById(User user, Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot find order by id: " + id));
        if (!user.getOrders().contains(order)) {
            throw new EntityNotFoundException("Order doesn't not belong to user. Order id: " + id);
        }
        return order;
    }

    private OrderItem getOrderItemByOrderAndId(Order order, Long id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot find order item by id: " + id));
        if (!orderItem.getOrder().equals(order)) {
            throw new EntityNotFoundException("Order item doesn't belong to order: "
                    + order + ". Id: " + id);
        }
        return orderItem;
    }
}
