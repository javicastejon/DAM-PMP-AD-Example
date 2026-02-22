package com.itacadam.myapp.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.itacadam.myapp.application.service.ProductService;
import com.itacadam.myapp.common.mapper.ProductMapper;
import com.itacadam.myapp.presentation.dto.request.ProductRequest;
import com.itacadam.myapp.presentation.dto.response.ProductResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper _mapper;

    public ProductController(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this._mapper = mapper;
    }

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        return _mapper.toResponse(
            productService.createProduct(_mapper.toDomain(request))
        );
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id,
                               @RequestBody ProductRequest request) {
        return _mapper.toResponse(
            productService.update(id, _mapper.toDomain(request))
        );
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return _mapper.toResponse(productService.getProduct(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.removeProduct(id);
    }

    @GetMapping("/getall")
    public List<ProductResponse> getAll() {
        return productService.getAllProducts().stream()
                .map(_mapper::toResponse)
                .toList();
    }

}
