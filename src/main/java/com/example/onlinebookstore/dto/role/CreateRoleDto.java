package com.example.onlinebookstore.dto.role;

import com.example.onlinebookstore.model.enums.RoleName;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreateRoleDto {
    @NonNull
    private RoleName roleName;
}
