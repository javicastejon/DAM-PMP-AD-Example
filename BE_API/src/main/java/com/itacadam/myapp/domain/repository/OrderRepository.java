package com.itacadam.myapp.domain.repository;

import java.util.List;
import java.util.Optional;
import com.itacadam.myapp.domain.models.Order;

public interface OrderRepository {

    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    void deleteById(Long id);
}