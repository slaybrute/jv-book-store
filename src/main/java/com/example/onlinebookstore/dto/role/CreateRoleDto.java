package com.example.onlinebookstore.dto.role;

import com.example.onlinebookstore.model.enums.RoleName;
import lombok.Data;

@Data
public class CreateRoleDto {
    private RoleName roleName;
}
