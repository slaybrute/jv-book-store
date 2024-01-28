package com.example.onlinebookstore.servce;

import com.example.onlinebookstore.dto.user.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findByEmail(String email);

    void deleteById(Long id);
}
