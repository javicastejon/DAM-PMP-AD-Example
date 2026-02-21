package com.itacadam.myapp.presentation.controller;

import org.springframework.web.bind.annotation.*;

import com.itacadam.myapp.application.service.OrderService;
import com.itacadam.myapp.infrastructure.persistence.entity.OrderEntity;
import com.itacadam.myapp.infrastructure.persistence.entity.ProductEntity;
import com.itacadam.myapp.presentation.dto.request.OrderCreationRequest;
import com.itacadam.myapp.presentation.dto.request.ProductCreationRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderCreationRequest orderCreationRequest) {
        return orderService.createOrder(orderCreationRequest);
    }

    @GetMapping("/{id}")
    public OrderEntity getOrder(@PathVariable Long id) {
        return orderService.getOrder(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.removeOrder(id);
    }


    @GetMapping("/getall")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }


}
