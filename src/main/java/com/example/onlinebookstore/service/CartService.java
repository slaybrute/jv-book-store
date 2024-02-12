package com.example.onlinebookstore.service;

import com.example.onlinebookstore.dto.cart.item.CartItemResponseDto;
import com.example.onlinebookstore.dto.cart.item.CreateCartItemDto;
import com.example.onlinebookstore.dto.cart.item.UpdateCartItemDto;
import com.example.onlinebookstore.dto.shopping.cart.ShoppingCartResponseDto;
import org.springframework.security.core.Authentication;

public interface CartService {
    ShoppingCartResponseDto getShoppingCart(Authentication authentication);

    CartItemResponseDto saveCartItem(Authentication authentication,
                                     CreateCartItemDto createCartItemDto);

    CartItemResponseDto updateCartItem(Authentication authentication,
                                       UpdateCartItemDto updateCartItemDto, Long id);

    void deleteCartItem(Authentication authentication, Long id);
}
