package com.example.onlinebookstore.validation.user.login;

import com.example.onlinebookstore.dto.user.LoginUserDto;
import com.example.onlinebookstore.validation.user.EmailValidator;
import com.example.onlinebookstore.validation.user.PasswordValidator;

public interface LoginValidator extends EmailValidator, PasswordValidator {
    void isLoginValid(LoginUserDto loginUserDto);
}
