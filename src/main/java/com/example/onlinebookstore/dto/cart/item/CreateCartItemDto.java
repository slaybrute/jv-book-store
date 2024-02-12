package com.example.onlinebookstore.dto.cart.item;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CreateCartItemDto {
    @Min(1)
    private Long bookId;

    @Min(1)
    private Integer amount;
}
