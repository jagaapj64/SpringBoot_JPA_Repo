package com.example.annotation.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
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
//	@JoinColumn(name="fk_empId",referencedColumnName = "emp_id")  // unidirectional mapping 
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")   // bidirectional mapping 
    @JsonBackReference
	private List<WorkStation> workStation;
    
    
    
    
    /*
	 * The direction of a relationship can be either bidirectional or
	 * unidirectional. A bidirectional relationship has both an owning side and an
	 * inverse side. A unidirectional relationship has only an owning side.
	 */
   
}
