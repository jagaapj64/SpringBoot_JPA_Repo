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
@Table(name="work_station")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WorkStation {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="station_id")
	private long stationId;
	private String floor;
	private String branch;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="emp_Id")
	private Employee employee;
	
	/*
	 * The direction of a relationship can be either bidirectional or
	 * unidirectional. A bidirectional relationship has both an owning side and an
	 * inverse side. A unidirectional relationship has only an owning side.
	 */
}
