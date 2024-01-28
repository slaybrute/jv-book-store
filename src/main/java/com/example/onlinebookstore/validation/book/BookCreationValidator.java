package com.example.onlinebookstore.validation.book;

import com.example.onlinebookstore.dto.book.CreateBookDto;

public interface BookCreationValidator extends AuthorValidator, TitleValidator, PriceValidator {
    void isBookCreationValid(CreateBookDto createBookDto);
}
