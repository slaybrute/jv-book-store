package com.example.onlinebookstore.validation.user.registration.impl;

import com.example.onlinebookstore.validation.user.registration.annotation.Password;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PasswordValidator implements ConstraintValidator<Password, String> {
    private static final String PATTERN_OF_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password == null || Pattern.compile(PATTERN_OF_PASSWORD).matcher(password).matches();
    }
}
