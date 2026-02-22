package com.itacadam.myapp.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itacadam.myapp.infrastructure.persistence.entity.ProductEntity;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
    
}
