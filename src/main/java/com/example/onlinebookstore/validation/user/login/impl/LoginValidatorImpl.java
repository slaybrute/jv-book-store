package com.example.onlinebookstore.validation.user.login.impl;

import com.example.onlinebookstore.dto.user.LoginUserDto;
import com.example.onlinebookstore.exception.LoginException;
import com.example.onlinebookstore.validation.common.NullFieldValidator;
import com.example.onlinebookstore.validation.user.login.LoginValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginValidatorImpl implements LoginValidator {
    private final NullFieldValidator nullFieldValidator;

    @Override
    public void isLoginValid(LoginUserDto loginUserDto) {
        isEmailValid(loginUserDto.getEmail());
        isPasswordValid(loginUserDto.getPassword());
    }

    @Override
    public void isEmailValid(String email) {
        nullFieldValidator.isFieldNotNull(email, new LoginException("Enter email"));
    }

    @Override
    public void isPasswordValid(String password) {
        nullFieldValidator.isFieldNotNull(password, new LoginException("Enter password"));
    }
}
