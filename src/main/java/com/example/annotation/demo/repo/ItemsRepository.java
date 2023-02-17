package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.Items;

public interface ItemsRepository extends JpaRepository<Items, Long> {

}
