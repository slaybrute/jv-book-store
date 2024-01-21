package com.example.onlinebookstore.servce.impl;

import com.example.onlinebookstore.dto.BookDto;
import com.example.onlinebookstore.dto.CreateBookDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import com.example.onlinebookstore.generator.IsbnGenerator;
import com.example.onlinebookstore.mapper.BookMapper;
import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.repository.BookRepository;
import com.example.onlinebookstore.servce.BookService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookDto createBookDto) {
        Book book = bookMapper.toModel(createBookDto);
        book.setIsbn(IsbnGenerator.generateIsbn());
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() throws EntityNotFoundException {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new EntityNotFoundException("Cannot find any book");
        }
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            bookDtos.add(bookMapper.toDto(book));
        }
        return bookDtos;
    }

    @Override
    public BookDto findById(Long id) throws EntityNotFoundException {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot find book by id: " + id)));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBook(Long id, CreateBookDto createBookDto) {
        Book book = bookMapper.toModel(createBookDto);
        book.setId(id);
        return bookMapper.toDto(bookRepository.save(book));
    }
}
