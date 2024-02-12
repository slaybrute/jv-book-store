package com.example.onlinebookstore.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "shopping_carts")
@SQLDelete(sql = "UPDATE shopping_carts SET is_deleted = true WHERE id=?")
public class ShoppingCart {
    @Id
    private Long id;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;
    @Column(name = "is_deleted", nullable = false)
    @Where(clause = "is_deleted = FALSE")
    private boolean isDeleted;

    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }
}
