package com.example.onlinebookstore.validation.common.impl;

import com.example.onlinebookstore.validation.common.NullFieldValidator;
import org.springframework.stereotype.Component;

@Component
public class NullFieldValidatorImpl implements NullFieldValidator {
    @Override
    public void isFieldNotNull(Object object, RuntimeException e) {
        if (object == null) {
            throw e;
        }
    }
}
