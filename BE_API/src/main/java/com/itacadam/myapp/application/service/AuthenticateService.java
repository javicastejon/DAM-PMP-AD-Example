package com.itacadam.myapp.application.service;

import com.itacadam.myapp.domain.repository.UserRepository;

import org.springframework.stereotype.Service;

import com.itacadam.myapp.common.util.PasswordHasher;
import com.itacadam.myapp.common.util.TokenGenerator;
import com.itacadam.myapp.domain.models.User;

@Service
public class AuthenticateService {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;
    private final TokenGenerator tokenGenerator;

    public AuthenticateService(UserRepository userRepository,
                                   PasswordHasher passwordHasher,
                                   TokenGenerator tokenGenerator) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
        this.tokenGenerator = tokenGenerator;
    }

    public String execute(String username, String password) {

        User user = (User) userRepository.findByNombre(username);
                

        if (!passwordHasher.matches(password, user.getContrasena())) {
            throw new RuntimeException("Invalid credentials");
        }

        return tokenGenerator.generate(user);
    }
}