package com.example.onlinebookstore.security.impl;

import com.example.onlinebookstore.dto.user.RegisterAdminDto;
import com.example.onlinebookstore.dto.user.RegisterUserDto;
import com.example.onlinebookstore.dto.user.UserDto;
import com.example.onlinebookstore.mapper.UserMapper;
import com.example.onlinebookstore.model.User;
import com.example.onlinebookstore.model.enums.RoleName;
import com.example.onlinebookstore.repository.user.UserRepository;
import com.example.onlinebookstore.security.RegistrationService;
import com.example.onlinebookstore.service.RoleService;
import com.example.onlinebookstore.validation.user.registration.RegistrationValidator;
import jakarta.annotation.PostConstruct;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegistrationValidator registrationValidator;
    private final RoleService roleService;

    @Override
    public UserDto register(RegisterUserDto registerUserDto) {
        registrationValidator.isRegistrationValid(registerUserDto);
        User user = userMapper.toModel(registerUserDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(roleService.findByRoleName(RoleName.USER)));
        return userMapper.toDto(userRepository.save(user));
    }

    @PostConstruct
    public void registerAdmin() {
        if (userRepository.findByEmail("admin@gmail.com").isPresent()) {
            return;
        }
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setFirstName("Artem");
        user.setLastName("Peiev");
        user.setPassword(passwordEncoder.encode("qwerty12345"));
        user.setDeleted(false);
        user.setRoles(Set.of(roleService.findByRoleName(RoleName.ADMIN)));
        userRepository.save(user);
    }

    @Override
    public UserDto registerAdmin(RegisterAdminDto registerAdminDto) {
        registrationValidator.isRegistrationValid(registerAdminDto);
        User user = userMapper.toModel(registerAdminDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }
}
