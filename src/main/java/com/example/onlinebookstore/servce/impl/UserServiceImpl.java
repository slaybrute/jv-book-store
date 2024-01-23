package com.example.onlinebookstore.servce.impl;

import com.example.onlinebookstore.dto.user.CreateUserDto;
import com.example.onlinebookstore.dto.user.UserDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import com.example.onlinebookstore.mapper.UserMapper;
import com.example.onlinebookstore.model.User;
import com.example.onlinebookstore.repository.user.UserRepository;
import com.example.onlinebookstore.servce.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto register(CreateUserDto createUserDto) {
        if (!createUserDto.getPassword().equals(createUserDto.getRepeatedPassword())) {
            throw new RuntimeException("password mismatch");
        }
        return userMapper.toDto(
                userRepository.save(userMapper.toModel(createUserDto)));
    }

    @Override
    public List<UserDto> findAll() throws EntityNotFoundException {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new EntityNotFoundException("Cannot find any user");
        }
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(userMapper.toDto(user));
        }
        return userDtos;
    }
}
