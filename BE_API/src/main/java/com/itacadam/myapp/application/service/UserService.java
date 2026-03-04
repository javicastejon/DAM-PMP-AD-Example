package com.itacadam.myapp.application.service;
import org.springframework.stereotype.Service;

import com.itacadam.myapp.common.util.PasswordHasher;
import com.itacadam.myapp.domain.exception.NotFoundException;
import com.itacadam.myapp.domain.models.User;
import com.itacadam.myapp.domain.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    public UserService(UserRepository userRepository,
                       PasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    public User createUser(User user) {

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

    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUser(final long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User", id));
    }

    public User update(Long id, User user) {

        User existing = getUser(id);

        String hashedPassword = passwordHasher.hash(user.getContrasena());

        return userRepository.save(
                new User(
                        id,
                        user.getNombre(),
                        hashedPassword,
                        user.getEdad(),
                        user.isAdministrador()
                )
        );
    }

    public List<User> getAllUsers() {
        logger.info("Listado de usuarios");

        try {
            return userRepository.findAll();
        } catch (Exception e) {
            logger.error("Error en listado de usuarios {}", e);
            return new ArrayList<>();
        }
    }
}