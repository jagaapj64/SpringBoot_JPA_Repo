package com.example.annotation.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.annotation.demo.model.CourseDetails;
import com.example.annotation.demo.model.StudentDetails;
import com.example.annotation.demo.repo.CourseDetailsRepository;
import com.example.annotation.demo.repo.StudentDetailsRepository;
import com.example.annotation.demo.request.StudentCourseDto;
import com.example.annotation.demo.service.StudentDetailsService;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {

	@Autowired
	CourseDetailsRepository courseDetailsRepository;
	
	@Autowired
	StudentDetailsRepository studentDetailsRepository;
	
	@Override
	public ResponseEntity<?> saveStudentDetails(StudentDetails studentDetails) {
		  Set<CourseDetails> setCourse=new HashSet<CourseDetails>();
		 
		  studentDetails.getCourseDetails().forEach(role->
		  setCourse.add(CourseDetails.builder().courseId(role.getCourseId()).courseName(role.getCourseName()).build()));
//		    CourseDetails courseDetails2=CourseDetails.builder().courseName(studentCourse.getCourse2()).build();
//		    Set<CourseDetails> setCourse=new HashSet<CourseDetails>();
//		    setCourse.add(courseDetails1);
//		    setCourse.add(courseDetails2);
//		    
		    StudentDetails studentDetails1=StudentDetails.builder().studentName(studentDetails.getStudentName()).courseDetails(setCourse).build();
//            StudentDetails studentDetails2=StudentDetails.builder().studentName(studentCourse.getStudent2()).build();
//		    Set<StudentDetails> setStudent=new HashSet<StudentDetails>();
//		    setStudent.add(studentDetails1);
//		    setStudent.add(studentDetails2);
//            
//		   
//		    studentDetails1.setCourseDetails(setCourse);
//		    studentDetails2.setCourseDetails(setCourse);
//		    
//		    courseDetails1.setStudentDetails(setStudent);
//		    courseDetails2.setStudentDetails(setStudent);
//		    
		    
            studentDetailsRepository.save(studentDetails1);     
            return ResponseEntity.ok(studentDetailsRepository.findAll());
	}

	@Override
	public ResponseEntity<?> fetchAllStudentDetails() {
		List<StudentDetails> studentList = studentDetailsRepository.findAll();
        return ResponseEntity.ok(studentList);
	}

	@Override
	public ResponseEntity<?> fetchAllCourseDetails() {
		 return ResponseEntity.ok(courseDetailsRepository.findAll());	
		}
	
	@Override
	public ResponseEntity<?> fetchAllStudentDetailsV1() {
		List<CourseDetails> courselist= courseDetailsRepository.findAll();
		List<StudentCourseDto> studentCourseDto = courselist.stream().map(e -> {
			return StudentCourseDto.builder().courseId(e.getCourseId()).courseName(e.getCourseName())
					.studentDetails(e.getStudentDetails()).build();
		}).collect(Collectors.toList());
		return ResponseEntity.ok(studentCourseDto);
	}


}
