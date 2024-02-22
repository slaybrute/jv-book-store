package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.model.enums.RoleName;
import com.example.onlinebookstore.repository.role.RoleRepository;
import com.example.onlinebookstore.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName).orElseThrow(() ->
                new EntityNotFoundException("Cannot find role by role name: " + roleName));
    }
}
