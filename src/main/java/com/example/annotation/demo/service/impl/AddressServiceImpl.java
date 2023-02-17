package com.example.annotation.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.annotation.demo.model.Address;
import com.example.annotation.demo.model.Address1;
import com.example.annotation.demo.repo.Address1Repository;
import com.example.annotation.demo.repo.AddressRepository;
import com.example.annotation.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	Address1Repository address1Repository;
	@Override
	public Address fetchByAddressId(Long id) {
		// TODO Auto-generated method stub
		return addressRepository.findById(id).get();
	}

	@Override
	public Address fetchByAddressByCity(String city) {
		// TODO Auto-generated method stub
		return addressRepository.findByCity(city);
	}

	@Override
	public Address fetchByAddressByStreet(String street) {
		// TODO Auto-generated method stub
		return addressRepository.findByStreet(street);
	}

	@Override
	public List<Address1> fetchAllAddress1() {
		return address1Repository.findAll();
	}

	
//	@Override
//	public Address fetchByAddressAndStudentId(Long id) {
//		// TODO Auto-generated method stub
//		return addressRepository.findByStudent(id);
//	}

}
