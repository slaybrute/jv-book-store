package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.dto.role.CreateRoleDto;
import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.model.enums.RoleName;
import com.example.onlinebookstore.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    @Operation(summary = "Get role by role name", description = "Get role by role name")
    Role findByRoleName(RoleName roleName) {
        return roleService.findByRoleName(roleName);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @Operation(summary = "Create new role", description = "Create new role")
    Role createRole(@RequestBody CreateRoleDto createRoleDto) {
        return roleService.createRole(createRoleDto);
    }
}
