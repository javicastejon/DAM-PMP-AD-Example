package com.itacadam.myapp.presentation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itacadam.myapp.application.service.OrderService;
import com.itacadam.myapp.common.mapper.OrderMapper;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final OrderService _service;
    private final OrderMapper _mapper;

    public AuthController(OrderService service, OrderMapper mapper) {
        this._service = service;
        this._mapper = mapper;
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        // Implement registration logic here
        // For example, create a new user and return a response
        final TokenResponse token = _service.registerUser(request.getUsername(), request.getPassword());
        return new RegisterResponse("User registered successfully", token);
    }

    @PostMapping("/login")
}
