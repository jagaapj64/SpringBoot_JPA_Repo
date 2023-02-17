package com.example.annotation.demo.service;

import java.util.List;

import com.example.annotation.demo.model.Address;
import com.example.annotation.demo.model.Address1;

public interface AddressService {

	Address fetchByAddressId(Long id);
	
	Address fetchByAddressByCity(String city);
	
	Address fetchByAddressByStreet(String street);
	
//	Address fetchByAddressAndStudentId(Long id);
	
	List<Address1> fetchAllAddress1();
	
	
}
