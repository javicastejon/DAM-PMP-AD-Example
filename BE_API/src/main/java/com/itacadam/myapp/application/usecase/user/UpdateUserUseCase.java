package com.itacadam.myapp.application.usecase.user;

import org.springframework.stereotype.Component;

import com.itacadam.myapp.domain.exception.NotFoundException;
import com.itacadam.myapp.domain.models.User;
import com.itacadam.myapp.domain.repository.UserRepository;
import com.itacadam.myapp.infrastructure.security.PasswordHasher;

@Component
public class UpdateUserUseCase {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    public UpdateUserUseCase(UserRepository userRepository,
                             PasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    public User execute(Long id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User", id));

        String hashedPassword = passwordHasher.hash(user.getContrasena());

        User updated = new User(
                id,
                user.getNombre(),
                hashedPassword,
                user.getEdad(),
                user.isAdministrador()
        );

        return userRepository.save(updated);
    }
}