package com.example.onlinebookstore.security;

import com.example.onlinebookstore.dto.user.RegisterAdminDto;
import com.example.onlinebookstore.dto.user.RegisterUserDto;
import com.example.onlinebookstore.dto.user.UserDto;

public interface RegistrationService {
    UserDto register(RegisterUserDto registerUserDto);

    UserDto registerAdmin(RegisterAdminDto registerAdminDto);
}
