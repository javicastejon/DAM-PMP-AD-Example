package com.itacadam.myapp.presentation.dto.response;

public record OrderResponse(Long id, String descripcion, double precio, String estado, String comprador) {

}
