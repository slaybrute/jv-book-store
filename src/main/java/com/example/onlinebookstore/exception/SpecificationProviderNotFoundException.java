package com.example.onlinebookstore.exception;

public class SpecificationProviderNotFoundException extends RuntimeException {
    public SpecificationProviderNotFoundException(String message) {
        super(message);
    }

    public SpecificationProviderNotFoundException(String message, Throwable e) {
        super(message, e);
    }
}
