package com.itacadam.myapp.common.mapper;

import org.springframework.stereotype.Component;

import com.itacadam.myapp.domain.models.Order;
import com.itacadam.myapp.infrastructure.persistence.entity.OrderEntity;
import com.itacadam.myapp.presentation.dto.request.OrderRequest;
import com.itacadam.myapp.presentation.dto.response.OrderResponse;

@Component
public class OrderMapper {

    // DTO a Dominio
    public Order toDomain(OrderRequest request) {
        return new Order(
            null,
            request.descripcion(),
            request.precio(),
            request.estado(),
            request.comprador()
        );
    }

    // Dominio a Entidad
    public OrderEntity toEntity(Order order) {
        return new OrderEntity(
            null,
            order.getDescripcion(),
            order.getPrecio(),
            order.getEstado(),
            order.getComprador()
        );
    }


    // Entidad a Dominio
    public Order toDomain(OrderEntity entity) {
        return new Order(
            entity.getNumeroPedido(),
            entity.getDescripcion(),
            entity.getPrecio(),
            entity.getEstado(),
            entity.getComprador()
        );
    }

    // Dominio a DTO
    public OrderResponse toResponse(Order order) {
        return new OrderResponse(
            order.getId(),
            order.getDescripcion(),
            order.getPrecio(),
            order.getEstado(),
            order.getComprador()
        );
    }
}

