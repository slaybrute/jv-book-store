package com.example.onlinebookstore.validation.user.role;

import com.example.onlinebookstore.dto.role.CreateRoleDto;
import com.example.onlinebookstore.validation.user.RoleNameValidator;

public interface RoleValidator extends RoleNameValidator {
    void isRoleValid(CreateRoleDto role);
}
