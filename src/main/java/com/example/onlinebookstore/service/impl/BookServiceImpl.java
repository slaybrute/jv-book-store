package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.dto.book.BookDto;
import com.example.onlinebookstore.dto.book.BookDtoWithoutCategoryIds;
import com.example.onlinebookstore.dto.book.BookSearchParameters;
import com.example.onlinebookstore.dto.book.CreateBookDto;
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
        return bookDtos;
    }

    @Override
    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot find book by id: " + id)));
    }

    @Override
    public void deleteById(Long id) {
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
        return bookDtos;
    }

    @Override
    public List<BookDtoWithoutCategoryIds> findByCategoryId(Long id) {
        List<BookDtoWithoutCategoryIds> bookDtos = new ArrayList<>();
        for (Book book : bookRepository.findByCategoryId(id)) {
            bookDtos.add(bookMapper.toDtoWithoutCategories(book));
        }
        if (bookDtos.isEmpty()) {
            throw new EntityNotFoundException("Cannot find any book by category id: " + id);
        }
        return bookDtos;
    }
}
