package com.example.onlinebookstore.validation.user.registration.impl;

import com.example.onlinebookstore.dto.user.RegisterAdminDto;
import com.example.onlinebookstore.dto.user.RegisterUserDto;
import com.example.onlinebookstore.exception.EntityAlreadyPresentException;
import com.example.onlinebookstore.exception.RegistrationException;
import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.repository.user.UserRepository;
import com.example.onlinebookstore.validation.common.NullFieldValidator;
import com.example.onlinebookstore.validation.user.registration.RegistrationValidator;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RegistrationValidatorImpl implements RegistrationValidator {
    private static final int FIRST_CHARACTER_POSITION = 0;
    private final NullFieldValidator nullFieldValidator;
    private final UserRepository userRepository;

    @Override
    public void isRegistrationValid(RegisterUserDto registerUserDto) {
        isFirstNameValid(registerUserDto.getFirstName());
        isLastNameValid(registerUserDto.getLastName());
        isEmailValid(registerUserDto.getEmail());
        isPasswordsValid(registerUserDto.getPassword(), registerUserDto.getRepeatedPassword());

    }

    @Override
    public void isRegistrationValid(RegisterAdminDto registerAdminDto) {
        isFirstNameValid(registerAdminDto.getFirstName());
        isLastNameValid(registerAdminDto.getLastName());
        isEmailValid(registerAdminDto.getEmail());
        isPasswordsValid(registerAdminDto.getPassword(), registerAdminDto.getRepeatedPassword());
        areRolesValid(registerAdminDto.getRoles());

    }

    @Override
    public void isEmailValid(String email) {
        nullFieldValidator.isFieldNotNull(email, new RegistrationException("Enter email"));
        if (userRepository.findByEmail(email).isPresent()) {
            throw new EntityAlreadyPresentException("User with such email existed: " + email);
        }
    }

    @Override
    public void isPasswordsValid(String password, String repeatedPassword) {
        nullFieldValidator.isFieldNotNull(password,
                new RegistrationException("Enter password"));
        nullFieldValidator.isFieldNotNull(repeatedPassword,
                new RegistrationException("Enter repeated password"));
        if (!password.equals(repeatedPassword)) {
            throw new RegistrationException("Password mismatch");
        }
    }

    @Override
    public void isFirstNameValid(String firstName) {
        nullFieldValidator.isFieldNotNull(firstName, new RegistrationException("Enter firstName"));
        if (Character.isLowerCase(firstName.charAt(FIRST_CHARACTER_POSITION))) {
            throw new RegistrationException("First name should start with capital letter");
        }
    }

    @Override
    public void isLastNameValid(String lastName) {
        nullFieldValidator.isFieldNotNull(lastName, new RegistrationException("Enter lastname"));
        if (Character.isLowerCase(lastName.charAt(FIRST_CHARACTER_POSITION))) {
            throw new RegistrationException("Last name should start with capital letter");
        }
    }

    @Override
    public void areRolesValid(Set<Role> roles) {
        nullFieldValidator.isFieldNotNull(roles, new RegistrationException("Enter roles"));
        if (roles.isEmpty()) {
            throw new RegistrationException("Enter roles");
        }
    }
}
