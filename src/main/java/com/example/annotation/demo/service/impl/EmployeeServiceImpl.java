package com.example.annotation.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.annotation.demo.model.Employee;
import com.example.annotation.demo.model.WorkStation;
import com.example.annotation.demo.repo.EmployeeRepository;
import com.example.annotation.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(String empName, String floorName) {
		WorkStation workStation = null;
		Employee employee = null;
		workStation = WorkStation.builder().floor(floorName).build();
		employee = Employee.builder().empName(empName).workStation(workStation).build();
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		return employeeRepository.findAll();
	}

}
