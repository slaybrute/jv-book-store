package com.example.onlinebookstore.dto.user;

import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.validation.user.registration.annotation.Email;
import com.example.onlinebookstore.validation.user.registration.annotation.Password;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Data;

@Data
public class RegisterAdminDto {
    @Email
    @NotNull
    private String email;
    @Password
    @NotNull
    private String password;
    @NotNull
    private String repeatedPassword;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String shippingAddress;
    private Set<Role> roles;
}
