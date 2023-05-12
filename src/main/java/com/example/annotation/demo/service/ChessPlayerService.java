package com.example.annotation.demo.service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.example.annotation.demo.model.Book;
import com.example.annotation.demo.model.Product;
import com.example.annotation.demo.model.User;
import com.example.annotation.demo.request.ChessPlayreDto;

public interface ChessPlayerService {

	ResponseEntity<?> saveChessPlayer(ChessPlayreDto dto );
	
	ResponseEntity<?> findChessPlayerByName(Integer id);
	
	ResponseEntity<?> findChessPlayerByName_Native(Integer id);
	
	ResponseEntity<?> findChessPlayerAndStateDetails(Integer id);
	
	ResponseEntity<?> findByFirstNameAndLastName(Integer id);

	ResponseEntity<?> updateByFirstNamePrefix(String firstname);

	ResponseEntity<?> findChessPlayerByLastName(String lastname, Pageable pageable);
	
 ResponseEntity<?> saveBookDetails(Book book);
	 
	 ResponseEntity<?> saveProductDetails(Product product);
	 
	 ResponseEntity<?> saveUserDetails(User user,String email);

}
