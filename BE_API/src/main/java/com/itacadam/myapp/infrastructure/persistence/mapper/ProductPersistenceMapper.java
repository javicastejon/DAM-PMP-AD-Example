package com.itacadam.myapp.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;

import com.itacadam.myapp.domain.models.Product;
import com.itacadam.myapp.infrastructure.persistence.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {

    // Domain → Entity
    ProductEntity toEntity(Product product);

    // Entity → Domain
    Product toDomain(ProductEntity entity);
}
