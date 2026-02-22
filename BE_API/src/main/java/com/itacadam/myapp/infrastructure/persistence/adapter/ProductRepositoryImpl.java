package com.itacadam.myapp.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.itacadam.myapp.common.mapper.ProductMapper;
import com.itacadam.myapp.domain.models.Product;
import com.itacadam.myapp.domain.repository.ProductRepository;
import com.itacadam.myapp.infrastructure.persistence.repository.JpaProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaRepository;
    private final ProductMapper mapper;

    public ProductRepositoryImpl(JpaProductRepository jpaRepository,
                              ProductMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    public Product save(Product product) {
        return mapper.toDomain(
            jpaRepository.save(mapper.toEntity(product))
        );
    }

    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    public List<Product> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}