package com.example.onlinebookstore.repository.cart.item;

import com.example.onlinebookstore.model.CartItem;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    default Long getUserId(Long id) {
        CartItem cartItem = findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cart item not found by id: " + id));
        return cartItem.getShoppingCart().getUser().getId();
    }
}
