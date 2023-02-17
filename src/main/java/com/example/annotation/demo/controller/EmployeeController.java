package com.example.annotation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annotation.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save/employee/{empName}/{floorName}")
	public ResponseEntity<?> saveStudent(@PathVariable(value = "empName") String empName,
			@PathVariable(value = "floorName") String floorName) {
		return ResponseEntity.ok(employeeService.saveEmployee(empName,floorName));

	}
	
	@GetMapping("/get/all/employee/")
	public ResponseEntity<?> getAllStudent() {
		return ResponseEntity.ok(employeeService.fetchAllEmployee());
	}
}
