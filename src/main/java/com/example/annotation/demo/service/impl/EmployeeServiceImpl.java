package com.example.annotation.demo.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.annotation.demo.model.Employee;
import com.example.annotation.demo.model.WorkStation;
import com.example.annotation.demo.repo.EmployeeRepository;
import com.example.annotation.demo.repo.WorkStationRepository;
import com.example.annotation.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	WorkStationRepository workStationRepository;
	
	

	@Override
	public  ResponseEntity<?> saveEmployee(List<Employee> emp) {
		
		return  ResponseEntity.ok(employeeRepository.saveAll(emp));
	}

	@Override
	public ResponseEntity<?> saveWorkStation(WorkStation workStation) {
		Employee emp1 = null;
		emp1 = employeeRepository.findByEmpName(workStation.getEmployee().getEmpName());
		if (Objects.nonNull(emp1)) {
			emp1.setEmpName(workStation.getEmployee().getEmpName());
		}else {
			emp1 = Employee.builder().empName(workStation.getEmployee().getEmpName()).build();
		}
		
	
		WorkStation work1 = WorkStation.builder().floor(workStation.getFloor()).branch(workStation.getBranch())
				.employee(emp1).build();

		workStationRepository.save(work1);

		return ResponseEntity.ok(workStationRepository.findAll());

	}

	
	

}
