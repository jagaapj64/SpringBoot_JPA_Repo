package com.example.annotation.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.annotation.demo.request.StudentCourse;

public interface StudentDetailsService {

	ResponseEntity<?>  saveStudentDetails(StudentCourse studentCourse);
	
	ResponseEntity<?> fetchAllStudentDetails();
	
	ResponseEntity<?> fetchAllCourseDetails();
	
    ResponseEntity<?> fetchAllStudentDetailsV1();
}
