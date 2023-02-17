package com.example.annotation.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private long empId;
	private String empName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_workstation", joinColumns = {
			@JoinColumn(name = "employee_id", referencedColumnName = "emp_id") }, inverseJoinColumns = {
					@JoinColumn(name = "workstation_id", referencedColumnName = "station_id") })
	private WorkStation workStation;
}
