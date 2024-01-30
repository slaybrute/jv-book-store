package com.example.onlinebookstore.repository.role;

import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.model.enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
