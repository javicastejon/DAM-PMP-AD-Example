package com.itacadam.myapp.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.itacadam.myapp.application.service.UserService;
import com.itacadam.myapp.presentation.dto.request.UserRequest;
import com.itacadam.myapp.presentation.dto.response.UserResponse;
import com.itacadam.myapp.presentation.mapper.UserPresentationMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;
    private final UserPresentationMapper mapper;

    public UserController(UserService service, UserPresentationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest request) {
        return mapper.toResponse(
            service.createUser(mapper.toDomain(request))
        );
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id,
                               @RequestBody UserRequest request) {
        return mapper.toResponse(
            service.update(id, mapper.toDomain(request))
        );
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return mapper.toResponse(service.getUser(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.removeUser(id);
    }

    @GetMapping("/getall")
    public List<UserResponse> getAll() {
        return service.getAllUsers().stream()
                .map(mapper::toResponse)
                .toList();
    }

}
