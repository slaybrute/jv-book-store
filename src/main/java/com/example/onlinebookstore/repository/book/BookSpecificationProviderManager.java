package com.example.onlinebookstore.repository.book;

import com.example.onlinebookstore.exception.SpecificationProviderNotFoundException;
import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.repository.SpecificationProvider;
import com.example.onlinebookstore.repository.SpecificationProviderManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {

    private final List<SpecificationProvider<Book>> bookSpecificationProvidersString;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        for (SpecificationProvider<Book> specificationProvider : bookSpecificationProvidersString) {
            if (specificationProvider.getKey().equals(key)) {
                return specificationProvider;
            }
        }
        throw new SpecificationProviderNotFoundException(
                "Cannot find specification by key: " + key);
    }
}
