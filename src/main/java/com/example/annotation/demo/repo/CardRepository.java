package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}
