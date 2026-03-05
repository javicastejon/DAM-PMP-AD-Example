package com.itacadam.myapp.application.usecase.product;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itacadam.myapp.domain.exception.NotFoundException;
import com.itacadam.myapp.domain.models.Product;
import com.itacadam.myapp.domain.repository.ProductRepository;

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

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProduct(final long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product", id));
    }

    public Product update(Long id, Product product) {
        getProduct(id);
        return productRepository.save(new Product(id, product.getNombre(), product.getDescripcion(), product.getImagenPath(), product.getStock(), product.getPrecio()));
    }

    public List<Product> getAllProducts() {
        logger.info("Listado de productos");

        try {
            return productRepository.findAll();
        } catch (Exception e) {
            logger.error("Error en listado de productos {}", e);
            return new ArrayList<>();
        }       
    }
}