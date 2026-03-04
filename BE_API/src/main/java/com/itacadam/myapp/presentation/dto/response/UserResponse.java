package com.itacadam.myapp.presentation.dto.response;

public record UserResponse(
    Long id,
    String nombre,
    String contrasena,
    int edad,
    boolean administrador,
    String role
) {
}
