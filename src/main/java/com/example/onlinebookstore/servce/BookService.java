package com.example.onlinebookstore.servce;

import com.example.onlinebookstore.dto.book.BookDto;
import com.example.onlinebookstore.dto.book.BookSearchParameters;
import com.example.onlinebookstore.dto.book.CreateBookDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookDto createBookDto);

    List<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    void deleteById(Long id);

    BookDto updateBook(Long id, CreateBookDto createBookDto);

    List<BookDto> search(BookSearchParameters bookSearchParameters);
}
