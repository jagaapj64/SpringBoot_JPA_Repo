package com.example.annotation.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users_details")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	
	@GenericGenerator(name = "sequence-generators", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "user_sequence"),
			@Parameter(name = "initial_value", value = "10"), @Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "sequence-generators")
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;


}
