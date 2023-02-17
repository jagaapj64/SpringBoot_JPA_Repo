package com.example.annotation.demo.request;

import java.util.Set;

import com.example.annotation.demo.model.StudentDetails;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentCourseDto {

	private long courseId;
	private String courseName;
	private Set<StudentDetails> studentDetails;
}
