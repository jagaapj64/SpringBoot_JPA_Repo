package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
