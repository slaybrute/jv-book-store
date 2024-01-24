package com.example.onlinebookstore.validation;

public interface RegistrationValidator {
    void isEmailValid(String email);

    void isPasswordValid(String password, String repeatedPassword);
}
