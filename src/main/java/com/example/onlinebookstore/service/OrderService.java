package com.example.onlinebookstore.service;

import com.example.onlinebookstore.dto.order.CreateOrderDto;
import com.example.onlinebookstore.dto.order.OrderResponseDto;
import com.example.onlinebookstore.dto.order.UpdateOrderStatusDto;
import com.example.onlinebookstore.dto.orderitem.OrderItemResponseDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

public interface OrderService {
    OrderResponseDto createOrder(Authentication authentication, CreateOrderDto createOrderDto);

    List<OrderResponseDto> getAllOrders(Authentication authentication, Pageable pageable);

    OrderResponseDto updateOrder(UpdateOrderStatusDto updateOrderStatusDto, Long id);

    List<OrderItemResponseDto> getAllOrderItemsById(Authentication authentication, Long id);

    OrderItemResponseDto getOrderItemById(Authentication authentication, Long orderId, Long itemId);
}
