package com.example.onlinebookstore.validation.user.role.impl;

import com.example.onlinebookstore.dto.role.CreateRoleDto;
import com.example.onlinebookstore.exception.RoleCreationException;
import com.example.onlinebookstore.model.enums.RoleName;
import com.example.onlinebookstore.validation.common.NullFieldValidator;
import com.example.onlinebookstore.validation.user.role.RoleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleValidatorImpl implements RoleValidator {
    private final NullFieldValidator nullFieldValidator;

    @Override
    public void isRoleValid(CreateRoleDto createRoleDto) {
    }

    @Override
    public void isRoleNameValid(RoleName roleName) {
        nullFieldValidator.isFieldNotNull(roleName, new RoleCreationException("Enter role name"));
    }
}
