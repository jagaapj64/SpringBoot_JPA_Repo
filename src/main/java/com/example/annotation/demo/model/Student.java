package com.example.annotation.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="student_id")
	private long studentId;
	private String studentName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_Id")
	private Address address;
	/*
	 * The direction of a relationship can be either bidirectional or
	 * unidirectional. A bidirectional relationship has both an owning side and an
	 * inverse side. A unidirectional relationship has only an owning side.
	 */

	}
