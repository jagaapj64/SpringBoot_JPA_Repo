package com.example.annotation.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="card1_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Card1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="card1_id")
	private long cardId;
	@Column(name="owner_name")
	private String ownerName;
	@OneToMany(mappedBy = "card1")
	@JsonBackReference
	private Set<Items1> items1;
}
