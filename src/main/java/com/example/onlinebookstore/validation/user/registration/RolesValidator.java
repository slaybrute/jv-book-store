package com.example.onlinebookstore.validation.user.registration;

import com.example.onlinebookstore.model.Role;
import java.util.Set;

public interface RolesValidator {
    void areRolesValid(Set<Role> roles);
}
