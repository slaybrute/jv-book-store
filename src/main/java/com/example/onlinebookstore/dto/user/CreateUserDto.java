package com.example.onlinebookstore.dto.user;

import com.example.onlinebookstore.validation.Email;
import com.example.onlinebookstore.validation.Password;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreateUserDto {
    @Email
    @NonNull
    private String email;
    @Password
    @NonNull
    private String password;
    @NonNull
    private String repeatedPassword;
}
