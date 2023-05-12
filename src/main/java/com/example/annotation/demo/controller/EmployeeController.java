package com.example.annotation.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annotation.demo.model.Employee;
import com.example.annotation.demo.model.WorkStation;
import com.example.annotation.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save/employee/")
	public ResponseEntity<?> saveStudent(@RequestBody List<Employee> emp ) {
		return ResponseEntity.ok(employeeService.saveEmployee(emp));

	}
	
	@PostMapping("/save/employee/bidirectional/")
	public ResponseEntity<?> saveWorkStation(@RequestBody WorkStation workStation ) {
		return ResponseEntity.ok(employeeService.saveWorkStation(workStation));
	}
	
	
}
