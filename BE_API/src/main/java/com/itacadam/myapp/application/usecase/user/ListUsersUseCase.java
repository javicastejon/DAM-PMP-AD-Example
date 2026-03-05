package com.itacadam.myapp.application.usecase.user;

import org.springframework.stereotype.Component;

import com.itacadam.myapp.domain.models.User;
import com.itacadam.myapp.domain.repository.UserRepository;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ListUsersUseCase {

    private static final Logger logger = LoggerFactory.getLogger(ListUsersUseCase.class);

    private final UserRepository userRepository;

    public ListUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        logger.info("Listado de usuarios");
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            logger.error("Error en listado de usuarios {}", e);
            return new ArrayList<>();
        }
    }
}