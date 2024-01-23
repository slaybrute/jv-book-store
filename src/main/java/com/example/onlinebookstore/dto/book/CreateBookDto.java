package com.example.onlinebookstore.dto.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreateBookDto {
    @NonNull
    private String title;
    @NotNull
    private String author;
    @Min(0)
    private BigDecimal price;
    private String description;
    private String coverImage;
}
