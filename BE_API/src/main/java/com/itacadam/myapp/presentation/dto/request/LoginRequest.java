package com.itacadam.myapp.presentation.dto.request;

public record LoginRequest(
        String username,
        String password
) {}