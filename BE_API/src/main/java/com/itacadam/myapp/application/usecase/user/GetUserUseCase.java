package com.itacadam.myapp.application.usecase.user;

import org.springframework.stereotype.Component;

import com.itacadam.myapp.domain.exception.NotFoundException;
import com.itacadam.myapp.domain.models.User;
import com.itacadam.myapp.domain.repository.UserRepository;

@Component
public class GetUserUseCase {

    private final UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User", id));
    }
}