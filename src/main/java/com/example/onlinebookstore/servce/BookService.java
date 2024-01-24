package com.example.onlinebookstore.servce;

import com.example.onlinebookstore.dto.book.BookDto;
import com.example.onlinebookstore.dto.book.BookSearchParameters;
import com.example.onlinebookstore.dto.book.CreateBookDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookDto createBookDto);

    List<BookDto> findAll(Pageable pageable) throws EntityNotFoundException;

    BookDto findById(Long id) throws EntityNotFoundException;

    void deleteById(Long id) throws EntityNotFoundException;

    BookDto updateBook(Long id, CreateBookDto createBookDto) throws EntityNotFoundException;

    List<BookDto> search(BookSearchParameters bookSearchParameters) throws EntityNotFoundException;
}
