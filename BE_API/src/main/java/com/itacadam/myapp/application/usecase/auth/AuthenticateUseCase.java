package com.itacadam.myapp.application.usecase.auth;

import org.springframework.stereotype.Component;
import com.itacadam.myapp.domain.repository.UserRepository;
import com.itacadam.myapp.infrastructure.security.PasswordHasher;
import com.itacadam.myapp.infrastructure.security.TokenGenerator;
import com.itacadam.myapp.domain.models.User;

@Component
public class AuthenticateUseCase {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;
    private final TokenGenerator tokenGenerator;

    public AuthenticateUseCase(UserRepository userRepository,
                               PasswordHasher passwordHasher,
                               TokenGenerator tokenGenerator) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
        this.tokenGenerator = tokenGenerator;
    }

    public String execute(String username, String password) {

        User user = (User) userRepository.findByNombre(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!passwordHasher.matches(password, user.getContrasena())) {
            throw new RuntimeException("Invalid credentials");
        }

        return tokenGenerator.generate(user);
    }
}