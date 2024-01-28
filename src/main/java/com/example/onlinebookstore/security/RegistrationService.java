package com.example.onlinebookstore.security;

import com.example.onlinebookstore.dto.user.RegisterUserDto;
import com.example.onlinebookstore.dto.user.UserDto;

public interface RegistrationService {
    UserDto register(RegisterUserDto registerUserDto);
}
