package com.example.onlinebookstore.mapper;

import com.example.onlinebookstore.config.MapperConfig;
import com.example.onlinebookstore.dto.role.CreateRoleDto;
import com.example.onlinebookstore.model.Role;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface RoleMapper {
    Role toModel(CreateRoleDto createRoleDto);
}
