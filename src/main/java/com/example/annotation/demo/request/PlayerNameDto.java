package com.example.annotation.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerNameDto {

	private String firstName;
	private String lastName;
	private int Id;
	
}
