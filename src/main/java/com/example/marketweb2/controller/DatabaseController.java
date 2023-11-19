package com.example.marketweb2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class DatabaseController {
// create database imdmarket
	
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/test-database")
    public String testDatabaseConnection() {
        try {
            entityManager.createQuery("SELECT 1 FROM products").getSingleResult();
            return "Database connection test successful!";
        } catch (Exception ex) {
            return "Error testing database connection: " + ex.getMessage();
        }
    }
}
