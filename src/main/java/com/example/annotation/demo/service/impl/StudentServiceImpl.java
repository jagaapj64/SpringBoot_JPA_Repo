package com.example.annotation.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.annotation.demo.model.Student;
import com.example.annotation.demo.repo.StudentRepository;
import com.example.annotation.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> saveStudent(List<Student> dto) {

		return studentRepository.saveAll(dto);
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
	public List<Student> fetchAllStudent() {
		return studentRepository.findAll();
	}

}
