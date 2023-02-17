package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
