package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.config.MapperConfig;
import com.example.onlinebookstore.dto.cart.item.CartItemResponseDto;
import com.example.onlinebookstore.dto.cart.item.CreateCartItemDto;
import com.example.onlinebookstore.model.CartItem;
import java.util.HashSet;
import java.util.Set;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class, uses = BookMapper.class)
public interface CartItemMapper {
    @Mapping(target = "book", source = "bookId", qualifiedByName = "bookById")
    CartItem toModel(CreateCartItemDto createCartItemDto);

    @Mapping(target = "bookId", ignore = true)
    @Mapping(target = "bookTitle", ignore = true)
    CartItemResponseDto toDto(CartItem cartItem);

    @AfterMapping
    default void setBookIdTitle(@MappingTarget CartItemResponseDto cartItemResponseDto,
                                CartItem cartItem) {
        cartItemResponseDto.setBookId(cartItem.getBook().getId());
        cartItemResponseDto.setBookTitle(cartItem.getBook().getTitle());
    }

    @Named("cartItemDtoByModel")
    default Set<CartItemResponseDto> cartItemDtoByModel(Set<CartItem> cartItem) {
        Set<CartItemResponseDto> cartItemResponseDtos = new HashSet<>();
        for (CartItem item : cartItem) {
            cartItemResponseDtos.add(toDto(item));
        }
        return cartItemResponseDtos;
    }
}
