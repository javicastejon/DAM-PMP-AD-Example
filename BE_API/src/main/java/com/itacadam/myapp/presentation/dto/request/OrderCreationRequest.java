package com.itacadam.myapp.presentation.dto.request;


public record OrderCreationRequest(String descripcion, double precio, String estado, String comprador) {
}
