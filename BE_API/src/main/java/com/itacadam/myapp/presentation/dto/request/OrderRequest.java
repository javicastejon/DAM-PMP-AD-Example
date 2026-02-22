package com.itacadam.myapp.presentation.dto.request;


public record OrderRequest(String descripcion, double precio, String estado, String comprador) {
}
