package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.config.MapperConfig;
import com.example.onlinebookstore.dto.orderitem.OrderItemResponseDto;
import com.example.onlinebookstore.model.CartItem;
import com.example.onlinebookstore.model.OrderItem;
import java.util.HashSet;
import java.util.Set;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public interface OrderItemMapper {
    @Mapping(target = "bookId", ignore = true)
    OrderItemResponseDto toDto(OrderItem orderItem);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "price", ignore = true)
    OrderItem toModel(CartItem cartItem);

    @AfterMapping
    default void setBookId(@MappingTarget OrderItemResponseDto orderItemResponseDto,
                           OrderItem orderItem) {
        orderItemResponseDto.setBookId(orderItem.getBook().getId());
    }

    @AfterMapping
    default void setOrderPrice(@MappingTarget OrderItem orderItem) {
        orderItem.setPrice(orderItem.getBook().getPrice());
    }

    @Named("orderItemDtoByModel")
    default Set<OrderItemResponseDto> orderItemDtoByModel(Set<OrderItem> orderItems) {
        Set<OrderItemResponseDto> orderItemResponseDtos = new HashSet<>();
        for (OrderItem orderItem : orderItems) {
            orderItemResponseDtos.add(toDto(orderItem));
        }
        return orderItemResponseDtos;
    }
}
