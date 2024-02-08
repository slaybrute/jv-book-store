package com.example.onlinebookstore.validation.category.impl;

import com.example.onlinebookstore.dto.category.CategoryDto;
import com.example.onlinebookstore.exception.InvalidCategoryException;
import com.example.onlinebookstore.repository.category.CategoryRepository;
import com.example.onlinebookstore.validation.category.CategoryValidator;
import com.example.onlinebookstore.validation.common.NullFieldValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryValidatorImpl implements CategoryValidator {
    private final NullFieldValidator nullFieldValidator;
    private final CategoryRepository categoryRepository;

    @Override
    public void isCategoryValid(CategoryDto categoryDto) {
        nullFieldValidator.isFieldNotNull(categoryDto,
                new InvalidCategoryException("Enter Category"));
        isNameValid(categoryDto.getName());
    }

    @Override
    public void isCreateCategoryValid(CategoryDto categoryDto) {
        isCategoryValid(categoryDto);
        if (categoryRepository.findByName(categoryDto.getName()).isPresent()) {
            throw new InvalidCategoryException("Category with such name is already exists");
        }
    }

    @Override
    public void isNameValid(String name) {
        nullFieldValidator.isFieldNotNull(name,
                new InvalidCategoryException("Enter name"));
    }
}
