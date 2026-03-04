package com.itacadam.myapp.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.mapstruct.BeanMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itacadam.myapp.domain.models.Order;
import com.itacadam.myapp.domain.repository.OrderRepository;
import com.itacadam.myapp.infrastructure.persistence.mapper.OrderPersistenceMapper;
import com.itacadam.myapp.infrastructure.persistence.repository.JpaOrderRepository;


@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final JpaOrderRepository jpaRepository;
    @Autowired
    private final OrderPersistenceMapper mapper;

    public OrderRepositoryImpl(JpaOrderRepository jpaRepository,
                              OrderPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    public Order save(Order product) {
        return mapper.toDomain(
            jpaRepository.save(mapper.toEntity(product))
        );
    }

    public Optional<Order> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    public List<Order> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
