package com.example.annotation.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="address_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {
	
	@Id
	@Column(name="Id")
	private long Id;
	private String street;
	private String city;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@OneToOne(mappedBy = "address")   bidirectional mapping
//	private Student student;
	
	/*
	 * The address side of the relationship is called the non-owning side.
	 */
	
	
	

	
}
