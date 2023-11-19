-- V1__create_products_table.sql

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    product_description VARCHAR(100) NOT NULL,
    product_price REAL,
    expiration_date VARCHAR(15),
    stock INT,
    supplier VARCHAR(50),
    active INT
);