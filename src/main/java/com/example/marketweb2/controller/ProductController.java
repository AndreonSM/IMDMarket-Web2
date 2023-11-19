package com.example.marketweb2.controller;

import com.example.marketweb2.model.ProductEntity;
import com.example.marketweb2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        return optionalProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Insert a new product
    @PostMapping
    public ResponseEntity<ProductEntity> postProduct(@RequestBody ProductEntity product) {
        ProductEntity savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }

    // Modify product based on JSON request
    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> putProduct(@PathVariable Long id, @RequestBody ProductEntity updatedProduct) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity existingProduct = optionalProduct.get();
            // Update properties based on the JSON request
            // You may want to add more sophisticated logic here
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductDescription(updatedProduct.getProductDescription());
            existingProduct.setProductPrice(updatedProduct.getProductPrice());
            existingProduct.setExpirationDate(updatedProduct.getExpirationDate());
            existingProduct.setStock(updatedProduct.getStock());
            existingProduct.setSupplier(updatedProduct.getSupplier());
            existingProduct.setActive(updatedProduct.isActive());
            
            productRepository.save(existingProduct);
            return ResponseEntity.ok(existingProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Physically delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Soft delete: Set active attribute to false
    @DeleteMapping("/logical/{id}")
    public ResponseEntity<Void> deleteLogic(@PathVariable Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity existingProduct = optionalProduct.get();
            existingProduct.setActive(false);
            productRepository.save(existingProduct);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
