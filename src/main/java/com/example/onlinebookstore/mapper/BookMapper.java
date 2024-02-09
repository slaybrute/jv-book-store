package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.config.MapperConfig;
import com.example.onlinebookstore.dto.book.BookDto;
import com.example.onlinebookstore.dto.book.BookDtoWithoutCategoryIds;
import com.example.onlinebookstore.dto.book.CreateBookDto;
import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.model.Category;
import java.util.HashSet;
import java.util.Set;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    @Mapping(target = "categories", ignore = true)
    Book toModel(CreateBookDto createBookDto);

    @Mapping(target = "categoryIds", ignore = true)
    BookDto toDto(Book book);

    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);

    @AfterMapping
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        Set<Long> categoryIds = new HashSet<>();
        for (Category category : book.getCategories()) {
            categoryIds.add(category.getId());
        }
        bookDto.setCategoryIds(categoryIds);
    }

    @AfterMapping
    default void setCategoryIds(@MappingTarget Book book, CreateBookDto createBookDto) {
        Set<Category> categories = new HashSet<>();
        for (Long categoryId : createBookDto.getCategoryIds()) {
            categories.add(new Category(categoryId));
        }
        book.setCategories(categories);
    }
}
