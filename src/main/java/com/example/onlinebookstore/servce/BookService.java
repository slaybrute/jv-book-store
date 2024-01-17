package com.example.onlinebookstore.servce;

import com.example.onlinebookstore.exception.EntityNotFoundException;
import com.example.onlinebookstore.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll() throws EntityNotFoundException;
}
