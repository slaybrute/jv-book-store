package com.example.onlinebookstore.dto.book;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookDto {
    private String title;
    private String author;
    private BigDecimal price;
    private String description;
    private String coverImage;
}
