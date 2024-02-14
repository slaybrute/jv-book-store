package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.mapper.RoleMapper;
import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.model.enums.RoleName;
import com.example.onlinebookstore.repository.role.RoleRepository;
import com.example.onlinebookstore.service.RoleService;
import com.example.onlinebookstore.validation.user.role.RoleValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleMapper roleMapper;
    private final RoleRepository roleRepository;
    private final RoleValidator roleValidator;

    @Override
    public Role findByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName).orElseThrow(() ->
                new EntityNotFoundException("Cannot find role by role name: " + roleName));
    }
}
