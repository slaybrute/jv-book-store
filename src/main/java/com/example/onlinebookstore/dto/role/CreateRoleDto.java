package com.example.onlinebookstore.dto.role;

import com.example.onlinebookstore.model.enums.RoleName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateRoleDto {
    @NotNull
    private RoleName roleName;
}
