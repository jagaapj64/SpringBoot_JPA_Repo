package com.example.annotation.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_details")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GenericGenerator(name = "assigned-sequence", strategy = "com.example.annotation.demo.config.StringSequenceIdentifier", 
	                                            parameters = @Parameter(name = "prefix", value = "PRO"))
	@GeneratedValue(generator = "assigned-sequence")
	private String id;
	private String productName;
	private Double price;
}
