package com.example.annotation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="card_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="card_id")
	private long cardId;
	private String ownerName;
}
