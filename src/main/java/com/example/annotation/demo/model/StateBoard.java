package com.example.annotation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "state_chess_board")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StateBoard {

	@Id
	@Column(name="sid")
	private int sid;
	private String boardName;
	private String state;

}
