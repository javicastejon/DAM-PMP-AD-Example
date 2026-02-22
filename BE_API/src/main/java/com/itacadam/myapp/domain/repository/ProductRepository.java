package com.itacadam.myapp.domain.repository;

import java.util.List;
import java.util.Optional;
import com.itacadam.myapp.domain.models.Product;

public interface ProductRepository {

    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
}