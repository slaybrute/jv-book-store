package com.example.onlinebookstore.validation.category;

import com.example.onlinebookstore.dto.category.CategoryDto;

public interface CategoryValidator extends NameValidator {
    void isCategoryValid(CategoryDto categoryDto);

    void isCreateCategoryValid(CategoryDto categoryDto);
}
