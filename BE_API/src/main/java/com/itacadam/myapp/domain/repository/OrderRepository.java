package com.itacadam.myapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itacadam.myapp.infrastructure.persistence.entity.OrderEntity;


public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}