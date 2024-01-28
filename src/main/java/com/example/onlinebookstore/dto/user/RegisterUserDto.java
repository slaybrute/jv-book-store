package com.example.onlinebookstore.dto.user;

import com.example.onlinebookstore.validation.user.registration.annotation.Email;
import com.example.onlinebookstore.validation.user.registration.annotation.Password;
import lombok.Data;

@Data
public class RegisterUserDto {
    @Email
    private String email;
    @Password
    private String password;
    private String firstName;
    private String lastName;
    private String shippingAddress;
    private String repeatedPassword;
}
