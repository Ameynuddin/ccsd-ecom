package com.ccsdg3.ecom.controller;

import com.ccsdg3.ecom.exception.ResourceNotFoundException;
import com.ccsdg3.ecom.model.Product;
import com.ccsdg3.ecom.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<Product> getProductBySlug(@PathVariable String slug) {
        Product product = productService.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ResponseEntity.ok(product);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> products = productService.findByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }
}