package com.example.annotation.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.annotation.demo.model.StudentDetails;

public interface StudentDetailsService {

	ResponseEntity<?>  saveStudentDetails(StudentDetails studentDetails);
	
	ResponseEntity<?> fetchAllStudentDetails();
	
	ResponseEntity<?> fetchAllCourseDetails();
	
    ResponseEntity<?> fetchAllStudentDetailsV1();
}
