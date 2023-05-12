package com.example.annotation.demo.service;

import java.util.List;

import com.example.annotation.demo.model.Student;

public interface StudentService {

	List<Student> saveStudent(List<Student> dto);
	
	Student fetchByStudentId(Long stId);
	
	Student fetchByStudentName(String name);
	
	Student fetchByStudentByAddressId(Long id);
	
	List<Student> fetchAllStudent();
	

}
