package com.itacadam.myapp.presentation.dto.response;

public record ProductResponse(Long id, String nombre, String descripcion, String imagenPath, int stock, double precio) {

}
