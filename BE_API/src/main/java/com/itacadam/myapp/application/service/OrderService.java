package com.itacadam.myapp.application.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itacadam.myapp.domain.repository.OrderRepository;
import com.itacadam.myapp.infrastructure.persistence.entity.OrderEntity;
import com.itacadam.myapp.presentation.dto.request.OrderCreationRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity createOrder(OrderCreationRequest orderCreationRequest) {
        return orderRepository.save(mapToOrder(orderCreationRequest));
    }

    public void removeOrder(Long id) {
        orderRepository.deleteById(id);
    }

    private OrderEntity mapToOrder(OrderCreationRequest createRequest) {
        OrderEntity order = new OrderEntity();
        order.setDescripcion(createRequest.descripcion());
        order.setPrecio(createRequest.precio());
        order.setEstado(createRequest.estado());
        order.setComprador(createRequest.comprador());
        return order;
    }

    public Optional<OrderEntity> getOrder(final Long id) {
        return orderRepository.findById(id);
    }

    public List<OrderEntity> getAllOrders() {
        try {
            return orderRepository.findAll();
        } catch (Exception e) {
            logger.error("Error al recuperar pedidos: " + e.getMessage());
            return new ArrayList<>(); // Devuelve una lista vacía en caso de error
        }
    }

}