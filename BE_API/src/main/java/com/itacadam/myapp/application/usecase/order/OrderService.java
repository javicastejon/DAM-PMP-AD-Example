package com.itacadam.myapp.application.usecase.order;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itacadam.myapp.domain.exception.NotFoundException;
import com.itacadam.myapp.domain.models.Order;
import com.itacadam.myapp.domain.repository.OrderRepository;

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

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public void removeOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order getOrder(final long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order", id));
    }

    public Order update(Long id, Order order) {
        getOrder(id);
        return orderRepository.save(new Order(id, order.getDescripcion(), order.getPrecio(), order.getEstado(), order.getComprador()));
    }

    public List<Order> getAllOrders() {
        logger.info("Listado de pedidos");
        return orderRepository.findAll();
    }

}