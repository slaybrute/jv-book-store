package com.example.onlinebookstore.servce;

import com.example.onlinebookstore.dto.user.CreateUserDto;
import com.example.onlinebookstore.dto.user.UserDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import java.util.List;

public interface UserService {
    UserDto register(CreateUserDto createUserDto);

    List<UserDto> findAll() throws EntityNotFoundException;
}
