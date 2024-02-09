package com.example.onlinebookstore.validation.user.role.impl;

import com.example.onlinebookstore.dto.role.CreateRoleDto;
import com.example.onlinebookstore.exception.EntityAlreadyPresentException;
import com.example.onlinebookstore.exception.InvalidRoleException;
import com.example.onlinebookstore.model.enums.RoleName;
import com.example.onlinebookstore.repository.role.RoleRepository;
import com.example.onlinebookstore.validation.common.NullFieldValidator;
import com.example.onlinebookstore.validation.user.role.RoleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleValidatorImpl implements RoleValidator {
    private final NullFieldValidator nullFieldValidator;
    private final RoleRepository roleRepository;

    @Override
    public void isRoleValid(CreateRoleDto createRoleDto) {
        nullFieldValidator.isFieldNotNull(createRoleDto,
                new InvalidRoleException("Enter role"));
        isRoleNameValid(createRoleDto.getRoleName());
    }

    @Override
    public void isRoleNameValid(RoleName roleName) {
        nullFieldValidator.isFieldNotNull(roleName,
                new InvalidRoleException("Enter role name"));
        if (roleRepository.findByRoleName(roleName).isPresent()) {
            throw new EntityAlreadyPresentException("Role with such name is already exists: "
                    + roleName.name());
        }
    }
}
