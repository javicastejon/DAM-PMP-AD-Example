package com.itacadam.myapp.application.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itacadam.myapp.domain.repository.ProductRepository;
import com.itacadam.myapp.infrastructure.persistence.entity.ProductEntity;
import com.itacadam.myapp.presentation.dto.request.ProductCreationRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity createProduct(ProductCreationRequest productCreationRequest) {
        return productRepository.save(mapToProduct(productCreationRequest));
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductEntity mapToProduct(ProductCreationRequest createRequest) {
        ProductEntity product = new ProductEntity();
        product.setNombre(createRequest.nombre());
        product.setDescripcion(createRequest.descripcion());
        product.setImagenPath(createRequest.imagenPath());
        product.setStock(createRequest.stock());
        product.setPrecio(createRequest.precio());
        return product;
    }

    public Optional<ProductEntity> getProduct(final long id) {
        return productRepository.findById(id);
    }

    public List<ProductEntity> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            logger.error("Error en listado de productos {}", e.getMessage());
            return new ArrayList<>(); // Devuelve una lista vacía en caso de error
        }
    }

}