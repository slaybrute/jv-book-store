package com.example.onlinebookstore.servce.impl;

import com.example.onlinebookstore.exception.EntityNotFoundException;
import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.repository.BookRepository;
import com.example.onlinebookstore.servce.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() throws EntityNotFoundException {
        List<Book> books = bookRepository.getAll();
        if (books.isEmpty()) {
            throw new EntityNotFoundException("Cannot find any book");
        }
        return books;
    }
}
