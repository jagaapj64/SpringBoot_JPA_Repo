package com.example.annotation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annotation.demo.request.StudentCourse;
import com.example.annotation.demo.service.StudentDetailsService;

@RestController
@RequestMapping("/api")
public class StudentDetailsController {

	@Autowired
	StudentDetailsService studentDetailsService;
	
	@PostMapping("/save/student/course/details/")
	public ResponseEntity<?> saveStudent(@RequestBody StudentCourse studentCourse) {
		return ResponseEntity.ok(studentDetailsService.saveStudentDetails(studentCourse));

	}
	
	@GetMapping("/get/all/student/details/")
	public ResponseEntity<?> getAllStudentDetails() {
		// fetch all student details from StudentDetails table
		return ResponseEntity.ok(studentDetailsService.fetchAllStudentDetails());
	}
	
	@GetMapping("/get/all/course/details/")
	public ResponseEntity<?> getAllCourseDetails() {
		// fetch all course details from StudentDetails table
		return ResponseEntity.ok(studentDetailsService.fetchAllCourseDetails());
	}

	@GetMapping("/get/all/student/details/v1/")
	public ResponseEntity<?> getAllCourseDetailsV1() {
		// fetch all students details from CourseDetails table
		return ResponseEntity.ok(studentDetailsService.fetchAllStudentDetailsV1());
	}
}
