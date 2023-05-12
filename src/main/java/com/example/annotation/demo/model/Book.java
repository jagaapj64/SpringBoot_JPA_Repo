package com.example.annotation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,	generator = "book_author")   creating sequence in database
//	@SequenceGenerator(name="book_author",allocationSize = 1)
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "book_sequence"),
			@Parameter(name = "initial_value", value = "10"), 
			@Parameter(name = "increment_size", value = "1") })
	@Column(name = "id")
	private Long id;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "title")
	private String title;
}
