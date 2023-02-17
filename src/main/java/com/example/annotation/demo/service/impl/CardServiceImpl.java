package com.example.annotation.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.annotation.demo.model.Card;
import com.example.annotation.demo.model.Card1;
import com.example.annotation.demo.model.Items;
import com.example.annotation.demo.model.Items1;
import com.example.annotation.demo.repo.Card1Repository;
import com.example.annotation.demo.repo.CardRepository;
import com.example.annotation.demo.repo.Items1Repository;
import com.example.annotation.demo.repo.ItemsRepository;
import com.example.annotation.demo.request.CardRequest;
import com.example.annotation.demo.service.CardService;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	Card1Repository card1Repository;
	
	@Autowired
	ItemsRepository itemsRepository;
	
	@Autowired
	Items1Repository items1Repository;
	@Override
	public ResponseEntity<?> saveCard(String ownerName) {
//		Card card=null;
//		Items itmes1=null;
//		Items itmes2=null;
//		Items itmes3=null;
//         itmes1=Items.builder().itemName("Mobile").build();
//         itmes2=Items.builder().itemName("Charger").build();
//         itmes3=Items.builder().itemName("earParts").build();
//        
//        Set<Items> itemSet=new HashSet<Items>();
//        itemSet.add(itmes1);
//        itemSet.add(itmes2);
//        itemSet.add(itmes3);
//         card=Card.builder().ownerName(ownerName).items(itemSet).build();
//		return ResponseEntity.ok(cardRepository.save(card));
		
		Card card=null;
		Items itmes1=null;
		Items itmes2=null;
		Items itmes3=null;
		card=Card.builder().ownerName(ownerName).build();
         itmes1=Items.builder().itemName("Mobile").card(card).build();
         itmes2=Items.builder().itemName("Charger").card(card).build();
         itmes3=Items.builder().itemName("earParts").card(card).build();
        
        Set<Items> itemSet=new HashSet<Items>();
        itemSet.add(itmes1);
        itemSet.add(itmes2);
        itemSet.add(itmes3);
        return ResponseEntity.ok(itemsRepository.saveAll(itemSet));
	}

	@Override
	public List<Card> fetchAllCardDetails() {
		return cardRepository.findAll();
	}

	@Override
	public List<Items1> saveItems1(String ownerName) {
		Card1 card1=Card1.builder().ownerName(ownerName).build();		
		Items1 itmes1=null;
		Items1 itmes2=null;
		Items1 itmes3=null;
         itmes1=Items1.builder().itemName("Pen").card1(card1).build();
         itmes2=Items1.builder().itemName("TV").card1(card1).build();
         itmes3=Items1.builder().itemName("LED").card1(card1).build();
        
        Set<Items1> itemSet=new HashSet<Items1>();
        itemSet.add(itmes1);
        itemSet.add(itmes2);
        itemSet.add(itmes3);
		return items1Repository.saveAll(itemSet);
	}

	@Override
	public List<Items1> fetchAllItems1() {
		return items1Repository.findAll();
	}

	@Override
	public ResponseEntity<?> fetchAllCard1Details() {
		List<Card1> list=card1Repository.findAllCards();
		List<CardRequest> dtoList=list.stream().map(status -> {
//			Items1 cards=items1Repository.findByCard1Id(status.getCardId());
			CardRequest cardRequest =CardRequest.builder().ownerName(status.getOwnerName()).cardId(status.getCardId())
             .itemsName(status.getItems1()).build();
			return cardRequest;
		}).collect(Collectors.toList());
		return ResponseEntity.ok(list);
		
	}

	@Override
	public List<Items> fetchAllItemsDetails() {
		return itemsRepository.findAll();
	}

}
