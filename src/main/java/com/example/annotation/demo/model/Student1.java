package com.example.annotation.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student1_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student1 {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="student_id")
	private long studentId;
	private String studentName;
	@OneToOne(mappedBy = "student1",cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JsonIgnore
	private Address1 address1;
	}
