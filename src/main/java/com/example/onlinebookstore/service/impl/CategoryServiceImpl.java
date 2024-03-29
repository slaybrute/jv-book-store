package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.dto.category.CategoryDto;
import com.example.onlinebookstore.exception.EntityAlreadyPresentException;
import com.example.onlinebookstore.mapper.CategoryMapper;
import com.example.onlinebookstore.model.Category;
import com.example.onlinebookstore.repository.category.CategoryRepository;
import com.example.onlinebookstore.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAll(Pageable pageable) {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categoryRepository.findAll(pageable)) {
            categoryDtos.add(categoryMapper.toDto(category));
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto getById(Long id) {
        return categoryMapper.toDto(categoryRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Category not found by id: " + id)));
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        isCreateCategoryValid(categoryDto);
        Category category = categoryRepository.save(categoryMapper.toModel(categoryDto));
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto update(Long id, CategoryDto categoryDto) {
        getById(id);
        Category category = categoryMapper.toModel(categoryDto);
        category.setId(id);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    private void isCreateCategoryValid(CategoryDto categoryDto) {
        if (categoryRepository.findByName(categoryDto.getName()).isPresent()) {
            throw new EntityAlreadyPresentException("Category with such name is already exists: "
                    + categoryDto.getName());
        }
    }
}
