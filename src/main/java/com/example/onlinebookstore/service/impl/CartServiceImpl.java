package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.dto.cart.item.CartItemResponseDto;
import com.example.onlinebookstore.dto.cart.item.CreateCartItemDto;
import com.example.onlinebookstore.dto.cart.item.UpdateCartItemDto;
import com.example.onlinebookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.example.onlinebookstore.mapper.CartItemMapper;
import com.example.onlinebookstore.mapper.ShoppingCartMapper;
import com.example.onlinebookstore.model.CartItem;
import com.example.onlinebookstore.model.User;
import com.example.onlinebookstore.repository.cart.item.CartItemRepository;
import com.example.onlinebookstore.service.CartService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final CartItemMapper cartItemMapper;
    private final ShoppingCartMapper shoppingCartMapper;
    private final CartItemRepository cartItemRepository;

    @Override
    public ShoppingCartResponseDto getShoppingCart(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return shoppingCartMapper.toDto(user.getShoppingCart());
    }

    @Override
    public CartItemResponseDto saveCartItem(Authentication authentication,
                                            CreateCartItemDto createCartItemDto) {
        User user = (User) authentication.getPrincipal();
        CartItem cartItem = cartItemMapper.toModel(createCartItemDto);
        cartItem.setShoppingCart(user.getShoppingCart());
        return cartItemMapper.toDto(cartItemRepository.save(cartItem));
    }

    @Override
    public CartItemResponseDto updateCartItem(Authentication authentication,
                                              UpdateCartItemDto updateCartItemDto, Long id) {
        User user = (User) authentication.getPrincipal();
        if (!Objects.equals(cartItemRepository.getUserId(id), user.getId())) {
            throw new EntityNotFoundException("Cart item not found by id: " + id);
        }
        CartItem cartItem = cartItemRepository.findById(id).get();
        cartItem.setAmount(updateCartItemDto.getAmount());
        return cartItemMapper.toDto(cartItemRepository.save(cartItem));
    }

    @Override
    public void deleteCartItem(Authentication authentication, Long id) {
        User user = (User) authentication.getPrincipal();
        if (!Objects.equals(cartItemRepository.getUserId(id), user.getId())) {
            throw new EntityNotFoundException("Cart item not found by id: " + id);
        }
        cartItemRepository.deleteById(id);
    }
}
