package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.dto.order.CreateOrderDto;
import com.example.onlinebookstore.dto.order.OrderResponseDto;
import com.example.onlinebookstore.dto.order.UpdateOrderStatusDto;
import com.example.onlinebookstore.dto.orderitem.OrderItemResponseDto;
import com.example.onlinebookstore.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    @Operation(summary = "Update order status",
            description = "Update order status by order id")
    public OrderResponseDto updateOrder(
            @RequestBody UpdateOrderStatusDto updateOrderStatusDto, @PathVariable Long id) {
        return orderService.updateOrder(updateOrderStatusDto, id);
    }

    @PostMapping
    @Operation(summary = "Create new order",
            description = "Create new order clean user shopping cart and save it to db")
    public OrderResponseDto createOrder(Authentication authentication,
                                        @RequestBody @Valid CreateOrderDto createOrderDto) {
        return orderService.createOrder(authentication, createOrderDto);
    }

    @GetMapping
    @Operation(summary = "Get all orders",
            description = "Get all orders which belongs to user + pagination")
    public List<OrderResponseDto> getAllOrders(Authentication authentication, Pageable pageable) {
        return orderService.getAllOrders(authentication, pageable);
    }

    @GetMapping("/{id}/items/")
    @Operation(summary = "Get all order items by order id",
            description = "Get all order items by order id")
    public List<OrderItemResponseDto> getAllOrderItemsById(
            Authentication authentication, @PathVariable Long id) {
        return orderService.getAllOrderItemsById(authentication, id);
    }

    @GetMapping("/{orderId}/items/{itemId}")
    @Operation(summary = "Get order item by id",
            description = "Get order item by id")
    public OrderItemResponseDto getOrderItemById(
            Authentication authentication, @PathVariable Long orderId,
            @PathVariable Long itemId) {
        return orderService.getOrderItemById(authentication, orderId, itemId);
    }
}
