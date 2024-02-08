package com.example.onlinebookstore.dto.user;

import com.example.onlinebookstore.validation.user.registration.annotation.Email;
import com.example.onlinebookstore.validation.user.registration.annotation.Password;
import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterUserDto {
    @NonNull
    @Email
    private String email;
    @NonNull
    @Password
    private String password;
    @NonNull
    private String repeatedPassword;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String shippingAddress;
}
