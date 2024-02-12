package com.example.onlinebookstore.repository.shopping.cart;

import com.example.onlinebookstore.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
