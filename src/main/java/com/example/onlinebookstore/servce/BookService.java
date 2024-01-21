package com.example.onlinebookstore.servce;

import com.example.onlinebookstore.dto.BookDto;
import com.example.onlinebookstore.dto.CreateBookDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookDto createBookDto);

    List<BookDto> findAll() throws EntityNotFoundException;

    BookDto findById(Long id) throws EntityNotFoundException;

    void deleteById(Long id);

    BookDto updateBook(Long id, CreateBookDto createBookDto);
}
