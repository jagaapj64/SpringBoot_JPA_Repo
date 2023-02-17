package com.example.annotation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items1_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Items1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item1_id")
	private long itemId;
	@Column(name = "item_name")
	private String itemName;
	@ManyToOne
	@JoinColumn(name = "card1_id")  
	@JsonManagedReference
	private Card1 card1;
}
