package com.itacadam.myapp.presentation.mapper;

import org.mapstruct.Mapper;

import com.itacadam.myapp.domain.models.Order;
import com.itacadam.myapp.presentation.dto.request.OrderRequest;
import com.itacadam.myapp.presentation.dto.response.OrderResponse;

@Mapper(componentModel = "spring")
public interface OrderPresentationMapper {

    // Request → Domain
    Order toDomain(OrderRequest request);

    // Domain → Response
    OrderResponse toResponse(Order order);
}
