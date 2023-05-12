package com.example.annotation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annotation.demo.model.StudentDetails;
import com.example.annotation.demo.service.StudentDetailsService;

@RestController
@RequestMapping("/api")
public class StudentDetailsController {

	@Autowired
	StudentDetailsService studentDetailsService;
	
	@PostMapping("/save/student/course/details/")
	public ResponseEntity<?> saveStudent(@RequestBody StudentDetails studentDetails ) {
		return ResponseEntity.ok(studentDetailsService.saveStudentDetails(studentDetails));

	}

}
