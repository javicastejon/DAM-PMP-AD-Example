package com.itacadam.myapp.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.itacadam.myapp.application.service.OrderService;
import com.itacadam.myapp.common.mapper.OrderMapper;
import com.itacadam.myapp.presentation.dto.request.OrderRequest;
import com.itacadam.myapp.presentation.dto.response.OrderResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService _service;
    private final OrderMapper _mapper;

    public OrderController(OrderService service, OrderMapper mapper) {
        this._service = service;
        this._mapper = mapper;
    }

    @PostMapping
    public OrderResponse create(@RequestBody OrderRequest request) {
        return _mapper.toResponse(
            _service.createOrder(_mapper.toDomain(request))
        );
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        _service.removeOrder(id);
    }

    @GetMapping("/getall")
    public List<OrderResponse> getAll() {
        return _service.getAllOrders().stream()
                .map(_mapper::toResponse)
                .toList();
    }


}
