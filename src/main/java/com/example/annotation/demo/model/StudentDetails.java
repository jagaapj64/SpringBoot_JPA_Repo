package com.example.annotation.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "manytomany_student_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentDetails {
//	https://www.javaguides.net/2022/03/spring-data-jpa-many-to-many-bidirectional-mapping.html
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private long studentId;
	@Column(name = "student_name")
	private String studentName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course_details", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
	                                     inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"))
//	@JsonManagedReference
	private Set<CourseDetails> courseDetails;
}
