package com.example.onlinebookstore.dto.book;

import java.math.BigDecimal;
import java.util.Set;
import lombok.Data;

@Data
public class BookDto {
    private String title;
    private String author;
    private BigDecimal price;
    private String description;
    private String isbn;
    private String coverImage;
    private Set<Long> categoryIds;
}
