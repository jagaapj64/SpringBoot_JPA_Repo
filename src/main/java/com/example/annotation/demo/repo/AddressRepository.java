package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Address findByCity(String city);

	Address findByStreet(String street);


}
