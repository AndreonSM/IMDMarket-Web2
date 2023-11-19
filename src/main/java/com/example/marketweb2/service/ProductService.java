package com.example.marketweb2.service;

import com.example.marketweb2.model.ProductEntity;
import com.example.marketweb2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Example of using the repository to perform CRUD operations
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    // Add more methods as needed
}