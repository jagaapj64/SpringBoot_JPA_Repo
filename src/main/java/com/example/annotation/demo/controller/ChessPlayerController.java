package com.example.annotation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.annotation.demo.model.Book;
import com.example.annotation.demo.model.Product;
import com.example.annotation.demo.model.User;
import com.example.annotation.demo.request.ChessPlayreDto;
import com.example.annotation.demo.service.ChessPlayerService;

@RestController
@RequestMapping("/api")
public class ChessPlayerController {

	@Autowired(required = true)
	private RestTemplate restTemplate;
	@Autowired
	ChessPlayerService chessPlayerService;

	@PostMapping("/save/chessplayer")
	public ResponseEntity<?> saveStudent(@RequestBody ChessPlayreDto dto) {
		return ResponseEntity.ok(chessPlayerService.saveChessPlayer(dto));

	}

	@GetMapping("/get/chessplayer/names/{id}")
	public ResponseEntity<?> getChessPlayerName(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(chessPlayerService.findChessPlayerByName(id));
	}

	@GetMapping("/get/chessplayer/named/native/query/{id}")
	public ResponseEntity<?> getChessPlayerName_Native(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(chessPlayerService.findChessPlayerByName_Native(id));
	}

	@GetMapping("/get/chessplayer/state/{id}")
	public ResponseEntity<?> getChessPlayerAndState(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(chessPlayerService.findChessPlayerAndStateDetails(id));
	}

	@GetMapping("/get/chessplayer/first/last/{id}")
	public ResponseEntity<?> getByFirstNameAndLastName(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(chessPlayerService.findByFirstNameAndLastName(id));
	}

	@PostMapping("/update/chessplayer/firstname/{firstname}")
	public ResponseEntity<?> updateByFirstNameByPrefix(@PathVariable("firstname") String firstname) {
		return ResponseEntity.ok(chessPlayerService.updateByFirstNamePrefix(firstname));
	}

	@GetMapping("/get/chessplayer/lastname/{lastname}")
	public ResponseEntity<?> getByChessPlayerByLastName(@PathVariable("lastname") String lastname,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "5") int size) {
		return ResponseEntity.ok(chessPlayerService.findChessPlayerByLastName(lastname, PageRequest.of(page, size)));
	}

	@PostMapping("/save/book/details/")
	public ResponseEntity<?> saveBookDetails(@RequestBody Book book) {
		return ResponseEntity.ok(chessPlayerService.saveBookDetails(book));

	}

	@PostMapping("/save/product/details/")
	public ResponseEntity<?> saveProductDetails(@RequestBody Product product) {
		return ResponseEntity.ok(chessPlayerService.saveProductDetails(product));

	}

	@PostMapping("/save/users/details/{email}")
	public ResponseEntity<?> saveUsersDetails(@RequestBody User user, @PathVariable("email") String email) {
		return ResponseEntity.ok(chessPlayerService.saveUserDetails(user, email));

	}

	@GetMapping("/get/product/details")
	public ResponseEntity<?> getProductDetails() {
		ResponseEntity<Product> responseEntity = restTemplate
				.getForEntity("http://localhost:8091/api/product/get/details/", Product.class);
		return ResponseEntity.ok(responseEntity.getBody());

	}
}
