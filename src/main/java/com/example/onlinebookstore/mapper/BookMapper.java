package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.config.MapperConfig;
import com.example.onlinebookstore.dto.BookDto;
import com.example.onlinebookstore.dto.CreateBookDto;
import com.example.onlinebookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    BookDto toDto(CreateBookDto createBookDto);

    Book toModel(CreateBookDto createBookDto);

}
