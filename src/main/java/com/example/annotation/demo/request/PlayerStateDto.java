package com.example.annotation.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStateDto {

//	public PlayerStateDto(String firstName, String lastName,int playerId, String boardName) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.playerId = playerId;
//		this.boardName = boardName;
////		this.teamName = teamName;
////		this.state = state;
//	}
	private String firstName;
	private String lastName;
	private String boardName;
	private int playerId;
	private String state;
	private String teamName;
}
