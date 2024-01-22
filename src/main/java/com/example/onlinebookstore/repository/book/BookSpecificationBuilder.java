package com.example.onlinebookstore.repository.book;

import com.example.onlinebookstore.dto.BookSearchParameters;
import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.repository.SpecificationBuilder;
import com.example.onlinebookstore.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters bookSearchParameters) {
        Specification<Book> specification = Specification.where(null);
        if (bookSearchParameters.getAuthors() != null
                && bookSearchParameters.getAuthors().length > 0) {
            specification = specification.and(bookSpecificationProviderManager
                    .getSpecificationProvider("author")
                    .getSpecification(bookSearchParameters.getAuthors()));
        }
        if (bookSearchParameters.getTitles() != null
                && bookSearchParameters.getTitles().length > 0) {
            specification = specification.and(bookSpecificationProviderManager
                    .getSpecificationProvider("title")
                    .getSpecification(bookSearchParameters.getTitles()));
        }
        return specification;
    }
}
