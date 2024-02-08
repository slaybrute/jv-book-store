package com.example.onlinebookstore.dto.category;

import lombok.Data;
import lombok.NonNull;

@Data
public class CategoryDto {
    @NonNull
    private String name;
    private String description;
}
