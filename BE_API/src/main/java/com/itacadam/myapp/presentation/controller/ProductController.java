package com.itacadam.myapp.presentation.controller;

import org.springframework.web.bind.annotation.*;

import com.itacadam.myapp.application.service.ProductService;
import com.itacadam.myapp.infrastructure.persistence.entity.ProductEntity;
import com.itacadam.myapp.presentation.dto.request.ProductCreationRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductCreationRequest productCreationRequest) {
        return productService.createProduct(productCreationRequest);
    }

    @GetMapping("/{id}")
    public ProductEntity getProduct(@PathVariable long id) {
        return productService.getProduct(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.removeProduct(id);
    }


    @GetMapping("/getall")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }


}
