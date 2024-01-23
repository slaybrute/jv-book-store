package com.example.onlinebookstore.servce;

import com.example.onlinebookstore.dto.book.BookDto;
import com.example.onlinebookstore.dto.book.BookSearchParameters;
import com.example.onlinebookstore.dto.book.CreateBookDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookDto createBookDto);

    List<BookDto> findAll() throws EntityNotFoundException;

    BookDto findById(Long id) throws EntityNotFoundException;

    void deleteById(Long id);

    BookDto updateBook(Long id, CreateBookDto createBookDto);

    List<BookDto> search(BookSearchParameters bookSearchParameters);
}
