package com.itacadam.myapp.common.mapper;


import org.springframework.stereotype.Component;

import com.itacadam.myapp.domain.models.Product;
import com.itacadam.myapp.infrastructure.persistence.entity.ProductEntity;
import com.itacadam.myapp.presentation.dto.request.ProductRequest;
import com.itacadam.myapp.presentation.dto.response.ProductResponse;


@Component
public class ProductMapper {

    // DTO a Dominio
    public Product toDomain(ProductRequest request) {
        return new Product(
            null,
            request.nombre(),
            request.descripcion(),
            request.imagenPath(),
            request.stock(),
            request.precio()
        );
    }

    // Dominio a Entidad
    public ProductEntity toEntity(Product product) {
        return new ProductEntity(
            null,
            product.getNombre(),
            product.getDescripcion(),
            product.getImagenPath(),
            product.getStock(),
            product.getPrecio()
        );
    }


    // Entidad a Dominio
    public Product toDomain(ProductEntity entity) {
        return new Product(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getImagenPath(),
            entity.getStock(),
            entity.getPrecio()
        );
    }

    // Dominio a DTO
    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getNombre(),
            product.getDescripcion(),
            product.getImagenPath(),
            product.getStock(),
            product.getPrecio()
        );
    }
}

