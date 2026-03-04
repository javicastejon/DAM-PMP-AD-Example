package com.itacadam.myapp.presentation.dto.request;

public record UserRequest(
    String nombre,
    String contrasena,
    int edad,
    boolean administrador,
    String role
) {
}