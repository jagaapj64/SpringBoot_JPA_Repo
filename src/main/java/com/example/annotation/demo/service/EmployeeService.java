package com.example.annotation.demo.service;

import java.util.List;

import com.example.annotation.demo.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(String empName,String floorName);
	
	List<Employee> fetchAllEmployee();
}
