package com.example.annotation.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="items_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Items {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	private long itemId;
	private String itemName;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="card_details")    // here we does'nt declare column @JoinColumn it is automatically created with some based on table name concat
	private Card card;
	
}
