package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.dto.user.LoginUserDto;
import com.example.onlinebookstore.dto.user.LoginUserResponseDto;
import com.example.onlinebookstore.dto.user.RegisterAdminDto;
import com.example.onlinebookstore.dto.user.RegisterUserDto;
import com.example.onlinebookstore.dto.user.UserDto;
import com.example.onlinebookstore.security.LoginService;
import com.example.onlinebookstore.security.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final RegistrationService registrationService;
    private final LoginService loginService;

    @PostMapping("/login")
    @Operation(summary = "Login user", description = "Login user")
    public LoginUserResponseDto register(@RequestBody @Valid LoginUserDto loginUserDto) {
        return loginService.login(loginUserDto);
    }

    @PostMapping("/register")
    @Operation(summary = "Register new user", description = "Register new user and save it to db")
    public UserDto register(@RequestBody @Valid RegisterUserDto registerUserDto) {
        return registrationService.register(registerUserDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register/admin")
    @Operation(summary = "Register new user by admin",
            description = "Register new user by admin role")
    public UserDto registerAdmin(@RequestBody @Valid RegisterAdminDto registerAdminDto) {
        return registrationService.registerAdmin(registerAdminDto);
    }
}
