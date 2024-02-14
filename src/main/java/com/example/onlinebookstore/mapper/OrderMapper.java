package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.config.MapperConfig;
import com.example.onlinebookstore.dto.order.OrderResponseDto;
import com.example.onlinebookstore.model.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, uses = OrderItemMapper.class)
public interface OrderMapper {
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "orderItems", source = "orderItems", qualifiedByName = "orderItemDtoByModel")
    OrderResponseDto toDto(Order order);

    @AfterMapping
    default void setUserId(@MappingTarget OrderResponseDto orderResponseDto,
                           Order order) {
        orderResponseDto.setUserId(order.getUser().getId());
    }
}
