package com.itacadam.myapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itacadam.myapp.infrastructure.persistence.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}