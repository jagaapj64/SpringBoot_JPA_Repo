package com.example.annotation.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annotation.demo.model.Student;
import com.example.annotation.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService studentService;

	/*
	 * In the uri using @RequestParam on the API
	 * 
	 * http://localhost:8080/apiPath?firstName=bob&lastName=smith&middleName=joe
	 * 
	 * or
	 * 
	 * using @PathVariable on the API
	 * 
	 * http://localhost:8080/apiPath/firstName/bob/lastName/smith/middleName/joe
	 */		
	@PostMapping("/save/student/")
	public ResponseEntity<?> saveStudent(@RequestBody List<Student> dto) {
		return ResponseEntity.ok(studentService.saveStudent(dto));

	}

	

	
	@GetMapping("/get/student/{Id}")
	public ResponseEntity<?> getByStudentId(@PathVariable("Id") Long Id) {
		return ResponseEntity.ok(studentService.fetchByStudentId(Id));
	}
	
	@GetMapping("/get/student/address/{Id}")
	public ResponseEntity<?> getByStudentIdByAddressId(@PathVariable("Id") Long Id) {
		return ResponseEntity.ok(studentService.fetchByStudentByAddressId(Id));
	}
	
	@GetMapping("/get/all/student/")
	public ResponseEntity<?> getAllStudent() {
		return ResponseEntity.ok(studentService.fetchAllStudent());
	}
	
	
}
