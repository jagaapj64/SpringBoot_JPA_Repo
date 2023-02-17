package com.example.annotation.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.annotation.demo.model.Address;
import com.example.annotation.demo.model.Address1;
import com.example.annotation.demo.model.Student;
import com.example.annotation.demo.model.Student1;
import com.example.annotation.demo.repo.Address1Repository;
import com.example.annotation.demo.repo.AddressRepository;
import com.example.annotation.demo.repo.Student1Repository;
import com.example.annotation.demo.repo.StudentRepository;
import com.example.annotation.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	Student1Repository student1Repository;
	
	@Autowired
	Address1Repository address1Repository;
	
	@Override
	public Student saveStudent(String stdName, String city, String street) {
		 Address address = null;
		 Student student= null;
		 address=Address.builder().street(street).city(city).build();
		 student=Student.builder().studentName(stdName).address(address).build();
		 return studentRepository.save(student);
	}

	@Override
	public Student fetchByStudentId(Long stId) {
		return studentRepository.findByStudentId(stId);
	}

	@Override
	public Student fetchByStudentName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentName(name);
	}

	@Override
	public Student fetchByStudentByAddressId(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentByAddressId(id);
	}

	@Override
	public Address1 saveStudent1(String stdName, String city, String street) {	
	Student1 student1 = null;
	Address1 address1=null;
	 student1=Student1.builder().studentName(stdName).address1(address1).build();
	 address1=Address1.builder().street(street).city(city).student1(student1).build();
	 student1Repository.save(student1);
	return  address1Repository.save(address1);
			
	}

	@Override
	public List<Student> fetchAllStudent() {
		return studentRepository.findAll();
	}


}
