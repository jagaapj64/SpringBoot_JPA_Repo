package com.example.annotation.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "manytomany_course_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CourseDetails {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_id")
	private long courseId;
	@Column(name = "course_name")
	private String courseName;
	@ManyToMany
	(mappedBy = "courseDetails")
//    @JsonBackReference
	private Set<StudentDetails> studentDetails;

}
