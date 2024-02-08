package com.example.onlinebookstore.exception;

public class EntityAlreadyPresentException extends RuntimeException {
    public EntityAlreadyPresentException(String message) {
        super(message);
    }
}
