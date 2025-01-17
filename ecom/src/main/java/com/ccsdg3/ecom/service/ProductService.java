package com.ccsdg3.ecom.service;

import com.ccsdg3.ecom.model.Product;
import com.ccsdg3.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Set<String> getAllCategories() {
        return productRepository.findAll().stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());
    }
}
