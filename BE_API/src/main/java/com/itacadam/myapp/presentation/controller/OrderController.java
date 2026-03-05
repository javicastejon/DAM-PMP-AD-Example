package com.itacadam.myapp.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itacadam.myapp.application.usecase.order.OrderService;
import com.itacadam.myapp.presentation.dto.request.OrderRequest;
import com.itacadam.myapp.presentation.dto.response.OrderResponse;
import com.itacadam.myapp.presentation.mapper.OrderPresentationMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService _service;
    private final OrderPresentationMapper _mapper;

    public OrderController(OrderService service, OrderPresentationMapper mapper) {
        this._service = service;
        this._mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest request) {
        var order = _service.createOrder(_mapper.toDomain(request));
        var response = _mapper.toResponse(order);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public OrderResponse update(@PathVariable Long id,
                               @RequestBody OrderRequest request) {
        return _mapper.toResponse(
            _service.update(id, _mapper.toDomain(request))
        );
    }

    @GetMapping("/{id}")
    public OrderResponse getById(@PathVariable Long id) {
        return _mapper.toResponse(_service.getOrder(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        _service.removeOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getall")
    public List<OrderResponse> getAll() {
        return _service.getAllOrders().stream()
                .map(_mapper::toResponse)
                .toList();
    }


}
