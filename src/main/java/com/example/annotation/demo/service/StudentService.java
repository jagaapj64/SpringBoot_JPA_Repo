package com.example.annotation.demo.service;

import java.util.List;

import com.example.annotation.demo.model.Address1;
import com.example.annotation.demo.model.Student;

public interface StudentService {

	Student saveStudent(String stdName,String city,String street);
	
	Address1 saveStudent1(String stdName,String city,String street);
	
	Student fetchByStudentId(Long stId);
	
	Student fetchByStudentName(String name);
	
	Student fetchByStudentByAddressId(Long id);
	
	List<Student> fetchAllStudent();
	

}
