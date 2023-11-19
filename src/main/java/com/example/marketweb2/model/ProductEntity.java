package com.example.marketweb2.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    @Length(max = 50, message = "Product name must be less than or equal to 50 characters")
    @Column(name = "product_name", nullable = false, length = 50)
    private String productName;

    @NotBlank(message = "Product description is required")
    @Length(max = 100, message = "Product description must be less than or equal to 100 characters")
    @Column(name = "product_description", nullable = false, length = 100)
    private String productDescription;

    @Column(name = "product_price")
    private Double productPrice;

    @Length(max = 15, message = "Expiration date must be less than or equal to 15 characters")
    @Column(name = "expiration_date", length = 15)
    private String expirationDate;

    @NotNull(message = "Stock is required")
    @Range(min = 0, message = "Stock must be a non-negative value")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @NotBlank(message = "Supplier is required")
    @Length(max = 50, message = "Supplier name must be less than or equal to 50 characters")
    @Column(name = "supplier", nullable = false, length = 50)
    private String supplier;

    @NotNull(message = "Active status is required")
    @Column(name = "active", nullable = false)
    private boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

    // Getters and setters

    // Constructors

    // Other methods if needed
}
