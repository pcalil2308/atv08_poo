CREATE DATABASE ecommerce;
USE ecommerce;
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50),
    descricao TEXT,
    peso DOUBLE,
    quantidade INT,
    unidade VARCHAR(20)
);
