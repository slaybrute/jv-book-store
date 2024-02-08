package com.example.onlinebookstore.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginUserDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
