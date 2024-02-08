package com.example.onlinebookstore.dto.book;

import com.example.onlinebookstore.model.Category;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreateBookDto {
    @NonNull
    private String title;
    @NonNull
    private String author;
    @Min(0)
    private BigDecimal price;
    private String description;
    private String coverImage;
    private Set<Category> categoryIds;
}
