package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.StudentDetails;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long> {

}
