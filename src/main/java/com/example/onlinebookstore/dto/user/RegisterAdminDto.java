package com.example.onlinebookstore.dto.user;

import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.validation.user.registration.annotation.Email;
import com.example.onlinebookstore.validation.user.registration.annotation.Password;
import java.util.Set;
import lombok.Data;

@Data
public class RegisterAdminDto {
    @Email
    private String email;
    @Password
    private String password;
    private String firstName;
    private String lastName;
    private String shippingAddress;
    private String repeatedPassword;
    private Set<Role> roles;
}
