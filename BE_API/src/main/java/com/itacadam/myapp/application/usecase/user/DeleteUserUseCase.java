package com.itacadam.myapp.application.usecase.user;

import org.springframework.stereotype.Component;

import com.itacadam.myapp.domain.repository.UserRepository;

@Component
public class DeleteUserUseCase {

    private final UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Long id) {
        userRepository.deleteById(id);
    }
}