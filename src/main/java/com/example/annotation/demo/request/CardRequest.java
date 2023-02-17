package com.example.annotation.demo.request;

import java.util.Set;

import com.example.annotation.demo.model.Items1;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardRequest {

	private long cardId;

	private String ownerName;

	private Set<Items1> itemsName;
	
	private long itemId;

}
