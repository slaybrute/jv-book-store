package com.example.onlinebookstore.security;

import com.example.onlinebookstore.dto.user.LoginUserDto;
import com.example.onlinebookstore.dto.user.LoginUserResponseDto;

public interface LoginService {
    LoginUserResponseDto login(LoginUserDto loginUserDto);
}
