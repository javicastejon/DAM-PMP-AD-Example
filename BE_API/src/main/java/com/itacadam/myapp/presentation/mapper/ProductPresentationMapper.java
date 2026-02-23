package com.itacadam.myapp.presentation.mapper;

import org.mapstruct.Mapper;

import com.itacadam.myapp.domain.models.Product;
import com.itacadam.myapp.presentation.dto.request.ProductRequest;
import com.itacadam.myapp.presentation.dto.response.ProductResponse;

@Mapper(componentModel = "spring")
public interface ProductPresentationMapper {

    // Request → Domain
    Product toDomain(ProductRequest request);

    // Domain → Response
    ProductResponse toResponse(Product product);
}
