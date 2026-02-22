package com.itacadam.myapp.application.service;
import org.springframework.stereotype.Service;

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

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUser(final long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User", id));
    }

    public User update(Long id, User user) {
        getUser(id);
        return userRepository.save(new User(id, user.getNombre(), user.getContrasena(), user.getEdad(), user.isAdministrador()));
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