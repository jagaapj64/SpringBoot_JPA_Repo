package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.WorkStation;

public interface WorkStationRepository extends JpaRepository<WorkStation, Integer> {

}
