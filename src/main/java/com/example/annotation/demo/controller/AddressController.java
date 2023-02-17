package com.example.annotation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annotation.demo.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@GetMapping("/get/address/Id/{Id}")
	public ResponseEntity<?> getByAddressId(@PathVariable("Id") Long Id) {
		return ResponseEntity.ok(addressService.fetchByAddressId(Id));
	}
	
	@GetMapping("/get/address/city/{city}")
	public ResponseEntity<?> getByAddressCity(@PathVariable("city") String city) {
		return ResponseEntity.ok(addressService.fetchByAddressByCity(city));
	}
	
	@GetMapping("/get/address/street/{street}")
	public ResponseEntity<?> getByAddressStreet(@PathVariable("street") String street) {
		return ResponseEntity.ok(addressService.fetchByAddressByStreet(street));
	}
	
	@GetMapping("/get/all/address1/")
	public ResponseEntity<?> getAllAddress1() {
		return ResponseEntity.ok(addressService.fetchAllAddress1());
	}
//	@GetMapping("/get/address/student/{studnetId}")
//	public ResponseEntity<?> getByAddressAndStudentId(@PathVariable("studnetId") Long studnetId) {
//		return ResponseEntity.ok(addressService.fetchByAddressAndStudentId(studnetId));
//	}
}
