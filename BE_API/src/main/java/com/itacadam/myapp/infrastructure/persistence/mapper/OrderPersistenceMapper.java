package com.itacadam.myapp.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;

import com.itacadam.myapp.domain.models.Order;
import com.itacadam.myapp.infrastructure.persistence.entity.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

    // Domain → Entity
    OrderEntity toEntity(Order order);

    // Entity → Domain
    Order toDomain(OrderEntity entity);
}