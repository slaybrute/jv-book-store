package com.example.onlinebookstore.security.impl;

import com.example.onlinebookstore.dto.user.RegisterUserDto;
import com.example.onlinebookstore.dto.user.UserDto;
import com.example.onlinebookstore.mapper.UserMapper;
import com.example.onlinebookstore.repository.user.UserRepository;
import com.example.onlinebookstore.security.RegistrationService;
import com.example.onlinebookstore.validation.user.registration.RegistrationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final RegistrationValidator registrationValidator;

    @Override
    public UserDto register(RegisterUserDto registerUserDto) {
        registrationValidator.isRegistrationValid(registerUserDto);
        return userMapper.toDto(userRepository.save(userMapper.toModel(
                registerUserDto)));
    }
}
