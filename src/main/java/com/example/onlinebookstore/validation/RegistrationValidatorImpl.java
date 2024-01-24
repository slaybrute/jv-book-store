package com.example.onlinebookstore.validation;

import com.example.onlinebookstore.exception.RegistrationException;
import com.example.onlinebookstore.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrationValidatorImpl implements RegistrationValidator {
    private final UserRepository userRepository;

    @Override
    public void isEmailValid(String email) {
        if (userRepository.findByEmail(email).isEmpty()) {
            throw new RegistrationException("User with such email existed: " + email);
        }
    }

    @Override
    public void isPasswordValid(String password, String repeatedPassword) {
        if (!password.equals(repeatedPassword)) {
            throw new RegistrationException("Password mismatch");
        }
    }
}
