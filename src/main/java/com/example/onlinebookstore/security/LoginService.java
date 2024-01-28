package com.example.onlinebookstore.security;

import com.example.onlinebookstore.dto.user.LoginUserDto;

public interface LoginService {
    boolean login(LoginUserDto loginUserDto);
}
