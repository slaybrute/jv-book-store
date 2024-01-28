package com.example.onlinebookstore.validation.user.registration;

import com.example.onlinebookstore.dto.user.RegisterUserDto;
import com.example.onlinebookstore.validation.user.EmailValidator;
import com.example.onlinebookstore.validation.user.FirstNameValidator;
import com.example.onlinebookstore.validation.user.LastNameValidator;

public interface RegistrationValidator extends EmailValidator, FirstNameValidator,
        LastNameValidator {
    void isPasswordsValid(String password, String repeatedPassword);

    void isRegistrationValid(RegisterUserDto registerUserDto);
}
