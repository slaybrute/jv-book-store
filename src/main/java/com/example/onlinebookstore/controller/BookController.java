package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.dto.book.BookDto;
import com.example.onlinebookstore.dto.book.BookSearchParameters;
import com.example.onlinebookstore.dto.book.CreateBookDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import com.example.onlinebookstore.servce.BookService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    @Operation(summary = "Create new book", description = "Create new book and save it to db")
    public BookDto save(@RequestBody @Valid CreateBookDto createBookDto) {
        return bookService.save(createBookDto);
    }

    @GetMapping
    @Operation(summary = "Get all books", description = "Get all available books by pagination")
    public List<BookDto> findAll(Pageable pageable) throws EntityNotFoundException {
        return bookService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by id", description = "Get book by id")
    public BookDto findById(@PathVariable Long id) throws EntityNotFoundException {
        return bookService.findById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book by id", description = "Safe delete book by id")
    public void deleteById(@PathVariable Long id) throws EntityNotFoundException {
        bookService.deleteById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update book by id", description = "Update book by id")
    public BookDto updateBook(@PathVariable Long id,
                              @RequestBody @Valid CreateBookDto createBookDto)
            throws EntityNotFoundException {
        return bookService.updateBook(id, createBookDto);
    }

    @GetMapping("/searh")
    @Operation(summary = "Search books by parameters",
            description = "Search books by titles and authors")
    public List<BookDto> search(BookSearchParameters bookSearchParameters)
            throws EntityNotFoundException {
        return bookService.search(bookSearchParameters);
    }
}
