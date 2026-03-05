package com.itacadam.myapp.presentation.controller;

import org.hibernate.sql.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.itacadam.myapp.application.usecase.user.*;
import com.itacadam.myapp.presentation.dto.request.UserRequest;
import com.itacadam.myapp.presentation.dto.response.UserResponse;
import com.itacadam.myapp.presentation.mapper.UserPresentationMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final UserPresentationMapper mapper;

    public UserController(CreateUserUseCase createUserUseCase, UpdateUserUseCase updateUserUseCase, 
        DeleteUserUseCase deleteUserUseCase, GetUserUseCase getUserUseCase, 
        ListUsersUseCase listUsersUseCase, UserPresentationMapper mapper) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.listUsersUseCase = listUsersUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest request) {
        return mapper.toResponse(
            createUserUseCase.execute(mapper.toDomain(request))
        );
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id,
                               @RequestBody UserRequest request) {
        return mapper.toResponse(
            updateUserUseCase.execute(id, mapper.toDomain(request))
        );
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return mapper.toResponse(getUserUseCase.execute(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteUserUseCase.execute(id);
    }

    @GetMapping("/getall")
    public List<UserResponse> getAll() {
        return listUsersUseCase.execute().stream()
                .map(mapper::toResponse)
                .toList();
    }

}

