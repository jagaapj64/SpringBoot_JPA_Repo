package com.example.annotation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address1_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address1 {

	@Id
	@Column(name="student_id")
	private long Id;
	private String street;
	private String city;
	@OneToOne
	@MapsId
	@JoinColumn(name="student_id")
	private Student1 student1;
}
