package com.example.onlinebookstore.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUserResponseDto {
    private String token;
}
