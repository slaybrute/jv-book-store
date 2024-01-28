package com.example.onlinebookstore.validation.user.login.impl;

import com.example.onlinebookstore.dto.user.LoginUserDto;
import com.example.onlinebookstore.exception.LoginException;
import com.example.onlinebookstore.validation.user.login.LoginValidator;
import org.springframework.stereotype.Component;

@Component
public class LoginValidatorImpl implements LoginValidator {
    @Override
    public void isLoginValid(LoginUserDto loginUserDto) {
        isEmailValid(loginUserDto.getEmail());
        isPasswordValid(loginUserDto.getPassword());
    }

    @Override
    public void isEmailValid(String email) {
        if (email == null) {
            throw new LoginException("Enter email");
        }
    }

    @Override
    public void isPasswordValid(String password) {
        if (password == null) {
            throw new LoginException("Enter password");
        }
    }
}
