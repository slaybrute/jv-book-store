package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.config.MapperConfig;
import com.example.onlinebookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.example.onlinebookstore.model.ShoppingCart;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, uses = CartItemMapper.class)
public interface ShoppingCartMapper {
    @Mapping(target = "cartItems", source = "cartItems", qualifiedByName = "cartItemDtoByModel")
    ShoppingCartResponseDto toDto(ShoppingCart shoppingCart);

    @AfterMapping
    default void setUserId(@MappingTarget ShoppingCartResponseDto shoppingCartResponseDto,
                           ShoppingCart shoppingCart) {
        shoppingCartResponseDto.setUserId(shoppingCart.getUser().getId());
    }
}
