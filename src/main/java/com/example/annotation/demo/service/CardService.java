package com.example.annotation.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.annotation.demo.model.Card;
import com.example.annotation.demo.model.Items;
import com.example.annotation.demo.model.Items1;

public interface CardService {

	ResponseEntity<?> saveCard(String ownerName);
	
	List<Items1> saveItems1(String ownerName);
	
	List<Card> fetchAllCardDetails();
	
	List<Items> fetchAllItemsDetails();
	
	List<Items1> fetchAllItems1();
	
	ResponseEntity<?> fetchAllCard1Details();
}
