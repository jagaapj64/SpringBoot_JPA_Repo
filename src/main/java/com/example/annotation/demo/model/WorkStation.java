package com.example.annotation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="work_station_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WorkStation {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="station_id")
	private long stationId;
	private String floor;
	@OneToOne(mappedBy = "workStation")
	@JsonIgnore
	private Employee employee;
}
