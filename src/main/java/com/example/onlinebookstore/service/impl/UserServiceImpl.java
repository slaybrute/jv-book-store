package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.dto.user.UserDto;
import com.example.onlinebookstore.exception.DeleteEntityException;
import com.example.onlinebookstore.mapper.UserMapper;
import com.example.onlinebookstore.model.User;
import com.example.onlinebookstore.repository.user.UserRepository;
import com.example.onlinebookstore.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> findAll(Pageable pageable) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : userRepository.findAll(pageable)) {
            userDtos.add(userMapper.toDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto findByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Cannot find user with email: " + email)));
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot find user by id: " + id));
        if (user.isDeleted()) {
            throw new DeleteEntityException("This user is already deleted with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByEmail(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        userRepository.deleteByEmail(user.getEmail());
    }
}
