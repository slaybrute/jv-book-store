package com.example.onlinebookstore.security.impl;

import com.example.onlinebookstore.dto.user.LoginUserDto;
import com.example.onlinebookstore.exception.LoginException;
import com.example.onlinebookstore.model.User;
import com.example.onlinebookstore.repository.user.UserRepository;
import com.example.onlinebookstore.security.LoginService;
import com.example.onlinebookstore.validation.user.login.LoginValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final LoginValidator loginValidator;

    @Override
    public boolean login(LoginUserDto loginUserDto) {
        loginValidator.isLoginValid(loginUserDto);
        User user = userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow(() ->
                new LoginException("User with such email does not exist: "
                        + loginUserDto.getEmail()));
        if (!user.getPassword().equals(loginUserDto.getPassword())) {
            throw new LoginException("Incorrect password: " + loginUserDto.getPassword());
        }
        return true;
    }
}
