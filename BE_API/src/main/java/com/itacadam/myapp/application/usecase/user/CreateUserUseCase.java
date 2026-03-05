package com.itacadam.myapp.application.usecase.user;

import org.springframework.stereotype.Component;

import com.itacadam.myapp.domain.models.User;
import com.itacadam.myapp.domain.repository.UserRepository;
import com.itacadam.myapp.infrastructure.security.PasswordHasher;

@Component
public class CreateUserUseCase {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    public CreateUserUseCase(UserRepository userRepository,
                             PasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    public User execute(User user) {
        String hashedPassword = passwordHasher.hash(user.getContrasena());

        User newUser = new User(
                user.getId(),
                user.getNombre(),
                hashedPassword,
                user.getEdad(),
                user.isAdministrador()
        );

        return userRepository.save(newUser);
    }
}