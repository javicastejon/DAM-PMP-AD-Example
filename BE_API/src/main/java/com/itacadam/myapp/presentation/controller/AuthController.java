package com.itacadam.myapp.presentation.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itacadam.myapp.application.service.AuthenticateService;
import com.itacadam.myapp.common.util.PasswordHasher;
import com.itacadam.myapp.common.util.TokenGenerator;
import com.itacadam.myapp.domain.repository.UserRepository;
import com.itacadam.myapp.presentation.dto.request.LoginRequest;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthenticateService useCase;

    public AuthController(UserRepository userRepository,
                          PasswordHasher passwordHasher,
                          TokenGenerator tokenGenerator) {
        this.useCase = new AuthenticateService(
                userRepository,
                passwordHasher,
                tokenGenerator
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        String token = useCase.execute(
                request.username(),
                request.password()
        );

        return ResponseEntity.ok(Map.of("token", token));
    }
}
