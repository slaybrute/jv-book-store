package com.example.onlinebookstore.servce;

import com.example.onlinebookstore.dto.user.CreateUserDto;
import com.example.onlinebookstore.dto.user.UserDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import com.example.onlinebookstore.exception.RegistrationException;
import java.util.List;

public interface UserService {
    UserDto register(CreateUserDto createUserDto) throws RegistrationException;

    List<UserDto> findAll() throws EntityNotFoundException;

    UserDto findByEmail(String email) throws EntityNotFoundException;
}
