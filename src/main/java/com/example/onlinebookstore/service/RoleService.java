package com.example.onlinebookstore.service;

import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.model.enums.RoleName;

public interface RoleService {
    Role findByRoleName(RoleName roleName);
}
