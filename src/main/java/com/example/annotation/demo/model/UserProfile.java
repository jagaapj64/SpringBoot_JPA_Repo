package com.example.annotation.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_profile")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

	@Id
	@Column(name="user_Id")
	private Long userId;
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	private User user;
}
