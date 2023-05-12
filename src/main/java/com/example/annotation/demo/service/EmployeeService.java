package com.example.annotation.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.annotation.demo.model.Employee;
import com.example.annotation.demo.model.WorkStation;

public interface EmployeeService {

	 ResponseEntity<?> saveWorkStation(WorkStation workStation);

	 ResponseEntity<?> saveEmployee(List<Employee> emp);
	 
	
	
}
