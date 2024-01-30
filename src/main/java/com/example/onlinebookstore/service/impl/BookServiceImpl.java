package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.dto.book.BookDto;
import com.example.onlinebookstore.dto.book.BookSearchParameters;
import com.example.onlinebookstore.dto.book.CreateBookDto;
import com.example.onlinebookstore.exception.DeleteEntityException;
import com.example.onlinebookstore.generator.IsbnGenerator;
import com.example.onlinebookstore.mapper.BookMapper;
import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.repository.book.BookRepository;
import com.example.onlinebookstore.repository.book.BookSpecificationBuilder;
import com.example.onlinebookstore.service.BookService;
import com.example.onlinebookstore.validation.book.BookCreationValidator;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;
    private final BookCreationValidator bookCreationValidator;

    @Override
    public BookDto save(CreateBookDto createBookDto) {
        bookCreationValidator.isBookCreationValid(createBookDto);
        Book book = bookMapper.toModel(createBookDto);
        book.setIsbn(IsbnGenerator.generateIsbn());
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : bookRepository.findAll(pageable)) {
            bookDtos.add(bookMapper.toDto(book));
        }
        if (bookDtos.isEmpty()) {
            throw new EntityNotFoundException("Cannot find any book");
        }
        return bookDtos;
    }

    @Override
    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot find book by id: " + id)));
    }

    @Override
    public void deleteById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot find book by id: " + id));
        if (book.isDeleted()) {
            throw new DeleteEntityException("This book is already deleted with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBook(Long id, CreateBookDto createBookDto) {
        bookCreationValidator.isBookCreationValid(createBookDto);
        findById(id);
        Book book = bookMapper.toModel(createBookDto);
        book.setId(id);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> search(BookSearchParameters bookSearchParameters)
            throws EntityNotFoundException {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : bookRepository.findAll(bookSpecificationBuilder
                .build(bookSearchParameters))) {
            bookDtos.add(bookMapper.toDto(book));
        }
        if (bookDtos.isEmpty()) {
            throw new EntityNotFoundException("Cannot find any book by search parameters: "
                    + bookSearchParameters);
        }
        return bookDtos;
    }
}
