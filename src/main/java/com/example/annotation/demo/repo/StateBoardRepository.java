package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.StateBoard;


public interface StateBoardRepository extends JpaRepository<StateBoard, Long> {

}
