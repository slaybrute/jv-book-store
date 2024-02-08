package com.example.onlinebookstore.service;

import com.example.onlinebookstore.dto.user.UserDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

public interface UserService {
    List<UserDto> findAll(Pageable pageable);

    UserDto findByEmail(String email);

    void deleteById(Long id);

    void deleteByEmail(Authentication authentication);
}
