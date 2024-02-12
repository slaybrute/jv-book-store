package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.dto.cart.item.CartItemResponseDto;
import com.example.onlinebookstore.dto.cart.item.CreateCartItemDto;
import com.example.onlinebookstore.dto.cart.item.UpdateCartItemDto;
import com.example.onlinebookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.example.onlinebookstore.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping
    @Operation(summary = "Get all items from shopping cart",
            description = "Get all items from user's shopping cart")
    public ShoppingCartResponseDto getShoppingCart(Authentication authentication) {
        return cartService.getShoppingCart(authentication);
    }

    @PostMapping
    @Operation(summary = "Save cart item to shopping cart",
            description = "Save new cart item to shopping cart")
    public CartItemResponseDto saveCartItem(
            Authentication authentication,
            @RequestBody @Valid CreateCartItemDto createCartItemDto) {
        return cartService.saveCartItem(authentication, createCartItemDto);
    }

    @PutMapping("cart/cart-items/{id}")
    @Operation(summary = "Update cart item by id", description = "Update cart item amount by id")
    public CartItemResponseDto updateCartItem(
            Authentication authentication,
            @RequestBody @Valid UpdateCartItemDto updateCartItemDto,
            @PathVariable Long id) {
        return cartService.updateCartItem(authentication, updateCartItemDto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("cart/cart-items/{id}")
    @Operation(summary = "Delete cart item by id", description = "Delete cart item by id")
    public void deleteCartItem(Authentication authentication, @PathVariable Long id) {
        cartService.deleteCartItem(authentication, id);
    }
}
