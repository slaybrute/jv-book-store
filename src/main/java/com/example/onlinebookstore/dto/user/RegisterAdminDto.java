package com.example.onlinebookstore.dto.user;

import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.validation.user.registration.annotation.Email;
import com.example.onlinebookstore.validation.user.registration.annotation.Password;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterAdminDto {
    @Email
    @NonNull
    private String email;
    @Password
    @NotNull
    private String password;
    @NonNull
    private String repeatedPassword;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String shippingAddress;
    private Set<Role> roles;
}
