package com.itacadam.myapp.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itacadam.myapp.infrastructure.persistence.entity.OrderEntity;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {
    
}
