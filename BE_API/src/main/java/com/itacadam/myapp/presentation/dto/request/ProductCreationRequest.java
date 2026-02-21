package com.itacadam.myapp.presentation.dto.request;


public record ProductCreationRequest(String nombre, String descripcion, String imagenPath, int stock, double precio) {
}
