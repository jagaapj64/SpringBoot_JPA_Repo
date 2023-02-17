package com.example.annotation.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annotation.demo.request.MessageResponse;
import com.example.annotation.demo.service.CardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

@RestController
@RequestMapping("/api")
public class CardController {

	@Autowired
	CardService cardService;

	@PostMapping("/save/card/details/{ownerName}")
	public ResponseEntity<?> saveStudent(@PathVariable(value = "ownerName") String ownerName) {
		return ResponseEntity.ok(cardService.saveCard(ownerName));

	}

	@GetMapping("/get/all/card/details/")
	public ResponseEntity<?> getAllCards() {
		return ResponseEntity.ok(cardService.fetchAllCardDetails());
	}
	
	@GetMapping("/get/all/items/details/")
	public ResponseEntity<?> getAllItems() {
		return ResponseEntity.ok(cardService.fetchAllItemsDetails());
	}

	
	@PostMapping("/save/items1/details/{ownerName}")
	public ResponseEntity<?> saveItems(@PathVariable(value = "ownerName") String ownerName) {
		return ResponseEntity.ok(cardService.saveItems1(ownerName));

	}
	
	@GetMapping("/get/all/itmes1/details/")
	public ResponseEntity<?> fetchAllItems1() {
		return ResponseEntity.ok(cardService.fetchAllItems1());
	}
	
	@GetMapping("/get/all/card1/details/")
	public ResponseEntity<?> fetchAllCard1() {
		return ResponseEntity.ok(cardService.fetchAllCard1Details());
	}

	@GetMapping(value="get/json", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getJsonFormat() throws JSONException, JsonMappingException, JsonProcessingException{
		
		String intput="{\n" + " \"meta\": {\n" + " \"fund_house\": \"DSP Mutual Fund\",\n"
				+ " \"scheme_type\": \"Open Ended Schemes\",\n"
				+ " \"scheme_category\": \"Debt Scheme - Medium Duration Fund\",\n"
				+ " \"scheme_code\": 100077,\n" + " \"scheme_name\": \"DSP Bond Fund - IDCW\"\n" + " },\n"
				+ " \"data\": [\n" + " {\n" + " \"date\": \"13-02-2023\",\n" + " \"nav\": \"11.53230\"\n"
				+ " },\n" + " {\n" + " \"date\": \"10-02-2023\",\n" + " \"nav\": \"11.52760\"\n"
				+ " },\n" + " {\n" + " \"date\": \"09-02-2023\",\n" + " \"nav\": \"11.52990\"\n"
				+ " },\n" + " {\n" + " \"date\": \"08-02-2023\",\n" + " \"nav\": \"11.53720\"\n"
				+ " },\n" + " {\n" + " \"date\": \"07-02-2023\",\n" + " \"nav\": \"11.54720\"\n"
				+ " }\n" + " ],\n" + " \"status\": \"SUCCESS\"\n" + "}";
		JSONPObject json=new JSONPObject("result", intput);
		json.getValue();
//		System.out.println(json.getValue());
		
		
		JSONObject jsons = new JSONObject(intput);
		JSONObject result=jsons.getJSONObject("meta");
		JSONArray result2=jsons.getJSONArray("data");
		
		List<String> list1=new ArrayList<String>();
		List<String> list2=new ArrayList<String>();
		
         for (int i = 0; i < result2.length(); i++) {
        	 JSONObject jsonArrays= result2.getJSONObject(i);


        	 list1.add(jsonArrays.get("date").toString());
        	 list2.add(jsonArrays.get("nav").toString());
        	
		}		
//       https://stackoverflow.com/questions/189559/how-do-i-join-two-lists-in-java
		List<List<String>> list3 = Arrays.asList(list1,list2);
       
		
         JSONObject j=new JSONObject();
         j.put("fundHouse", result.get("fund_house"));
         j.put("schemeCode", result.get("scheme_code"));
         j.put("schemeName", result.get("scheme_name"));
         j.put("schemeCategory", result.get("scheme_category"));
         j.put("data", list3);

         ObjectMapper mapper=new ObjectMapper();
         Object obj = mapper.readValue(j.toString(), Object.class);
		 return ResponseEntity.ok(MessageResponse.builder().response(obj).build());
		
	}
}
