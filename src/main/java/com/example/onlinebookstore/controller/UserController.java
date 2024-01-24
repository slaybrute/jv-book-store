package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.dto.user.CreateUserDto;
import com.example.onlinebookstore.dto.user.UserDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import com.example.onlinebookstore.servce.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    @Operation(summary = "Get all users", description = "Get all available users")
    public List<UserDto> findAll() throws EntityNotFoundException {
        return userService.findAll();
    }

    @GetMapping("/by-email")
    @Operation(summary = "Get user by email", description = "Get user by email")
    public UserDto getByEmail(@RequestParam String email)
            throws EntityNotFoundException {
        return userService.findByEmail(email);
    }

    @PostMapping
    @Operation(summary = "Register new user", description = "Register new user and save it to db")
    public UserDto register(@RequestBody @Valid CreateUserDto createUserDto) {
        return userService.register(createUserDto);
    }
}
