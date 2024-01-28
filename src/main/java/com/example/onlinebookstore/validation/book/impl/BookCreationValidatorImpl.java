package com.example.onlinebookstore.validation.book.impl;

import com.example.onlinebookstore.dto.book.CreateBookDto;
import com.example.onlinebookstore.exception.BookCreationException;
import com.example.onlinebookstore.validation.book.BookCreationValidator;
import com.example.onlinebookstore.validation.common.NullFieldValidator;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookCreationValidatorImpl implements BookCreationValidator {
    private static final int FIRST_CHARACTER_POSITION = 0;
    private final NullFieldValidator nullFieldValidator;

    @Override
    public void isBookCreationValid(CreateBookDto createBookDto) {
        isAuthorValid(createBookDto.getAuthor());
        isTitleValid(createBookDto.getTitle());
        isPriceValid(createBookDto.getPrice());
    }

    @Override
    public void isAuthorValid(String author) {
        nullFieldValidator.isFieldNotNull(author, new BookCreationException("Enter author"));
        if (Character.isLowerCase(author.charAt(FIRST_CHARACTER_POSITION))) {
            throw new BookCreationException("Author should start with capital letter");
        }
    }

    @Override
    public void isPriceValid(BigDecimal price) {
        nullFieldValidator.isFieldNotNull(price, new BookCreationException("Enter price"));
        if (price.compareTo(new BigDecimal(0)) <= 0) {
            throw new BookCreationException("Enter price more than 0");
        }
    }

    @Override
    public void isTitleValid(String title) {
        nullFieldValidator.isFieldNotNull(title, new BookCreationException("Enter title"));
        if (Character.isLowerCase(title.charAt(FIRST_CHARACTER_POSITION))) {
            throw new BookCreationException("Title should start with capital letter");
        }
    }
}
