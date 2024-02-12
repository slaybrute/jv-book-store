package com.example.onlinebookstore.dto.user;

import com.example.onlinebookstore.validation.user.registration.annotation.Email;
import com.example.onlinebookstore.validation.user.registration.annotation.Password;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterUserDto {
    @NotNull
    @Email
    private String email;
    @NotNull
    @Password
    private String password;
    @NotNull
    private String repeatedPassword;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String shippingAddress;
}
