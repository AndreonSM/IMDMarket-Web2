package com.example.marketweb2.repository;

import com.example.marketweb2.model.ProductEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	// ProductRepository.java

	// Find products by name
	List<ProductEntity> findByProductName(String productName);

	// Find products by supplier
	List<ProductEntity> findBySupplier(String supplier);

	// Add more custom queries as needed
}
