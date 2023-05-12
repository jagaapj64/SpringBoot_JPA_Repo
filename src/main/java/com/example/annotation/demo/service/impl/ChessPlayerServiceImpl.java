package com.example.annotation.demo.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.annotation.demo.model.Book;
import com.example.annotation.demo.model.UserProfile;
import com.example.annotation.demo.model.ChessPlayer;
import com.example.annotation.demo.model.Product;
import com.example.annotation.demo.model.StateBoard;
import com.example.annotation.demo.model.User;
import com.example.annotation.demo.repo.UserProfileRepository;
import com.example.annotation.demo.repo.UserRepository;
import com.example.annotation.demo.repo.BookRepository;
import com.example.annotation.demo.repo.ChessPlayerRepository;
import com.example.annotation.demo.repo.PlayerNames;
import com.example.annotation.demo.repo.ProductRepository;
import com.example.annotation.demo.repo.StateBoardRepository;
import com.example.annotation.demo.request.ChessPlayreDto;
import com.example.annotation.demo.request.PlayerNameDto;
import com.example.annotation.demo.request.PlayerStateDto;
import com.example.annotation.demo.service.ChessPlayerService;

@Service
public class ChessPlayerServiceImpl implements ChessPlayerService {

	@Autowired
	ChessPlayerRepository chessPlayerRepository;
	
	@Autowired
	StateBoardRepository stateBoardRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<?> saveChessPlayer(ChessPlayreDto dto) {
		StateBoard stateBoard1=StateBoard.builder().sid(107).boardName("kano Chess Marathon").state("Chennai").build();
		StateBoard stateBoard2=StateBoard.builder().sid(108).boardName("Melan Chess Yatra").state("Hydrabad").build();
		Set<StateBoard> statelist=new HashSet<>();
		statelist.add(stateBoard1);
		statelist.add(stateBoard2);
		
		ChessPlayer chessPlayer = ChessPlayer.builder().firstName(dto.getFirstName()).lastName(dto.getLastName())
				.teamName(dto.getTeamName()).date(new Date()).stateBoard(statelist).build();
		
		
		
//		stateBoardRepository.save(stateBoard1);
//		stateBoardRepository.save(stateBoard2);
		chessPlayerRepository.save(chessPlayer);
		return ResponseEntity.ok(chessPlayer);
	}

	@Override
	public ResponseEntity<?> findChessPlayerByName(Integer id) {
		PlayerNames player= chessPlayerRepository.findPlayerNameById(id);
		 return  ResponseEntity.ok(player.getFirstName()+" "+player.getLastName());
	}

	@Override
	public ResponseEntity<?> findChessPlayerByName_Native(Integer id) {
		PlayerNameDto playerNameDto= chessPlayerRepository.findPlayerNameDtoById_Named(id);
		return ResponseEntity.ok(playerNameDto.getId() +" "+ playerNameDto.getFirstName()+" "+playerNameDto.getLastName());
	}

	@Override
	public ResponseEntity<?> findChessPlayerAndStateDetails(Integer id) {
	 List<PlayerStateDto> playerStateDto=	chessPlayerRepository.findByPlayerAndStateDetails(id);
	 return ResponseEntity.ok(playerStateDto);
	}

	@Override
	public ResponseEntity<?> findByFirstNameAndLastName(Integer id) {
	  ChessPlayer chessPlayer=	chessPlayerRepository.findByFirstNameAndLastName(id);
		return ResponseEntity.ok(chessPlayer.getId() + " " + chessPlayer.getFirstName() + " "
				+ chessPlayer.getLastName() + " " + chessPlayer.getTeamName() + " " + chessPlayer.getDate());
	}

	@Override
	public ResponseEntity<?> updateByFirstNamePrefix(String firstname) {
//		List<ChessPlayer> list=chessPlayerRepository.findByStateBoardBoardName(firstname);
		List<ChessPlayer>  list =chessPlayerRepository.getByChessPlayersAndStateBoard();
		return ResponseEntity.ok(list);
	}

	@Override
	public ResponseEntity<?> findChessPlayerByLastName(String lastname, Pageable pageable) {
		Page<ChessPlayer> page=chessPlayerRepository.getChessPlayerByLastName(lastname,pageable);
		return ResponseEntity.ok(page);
	}
	
	@Override
	public ResponseEntity<?> saveBookDetails(Book book) {

		Book books=Book.builder().bookName(book.getBookName()).title(book.getTitle()).build();
		
		return ResponseEntity.ok(bookRepository.save(books));
		
	}

	@Override
	public ResponseEntity<?> saveProductDetails(Product product) {

		Product products=Product.builder().price(product.getPrice()).productName(product.getProductName()).build();
		return ResponseEntity.ok(productRepository.save(products));
		
	}

	@Override
	public ResponseEntity<?> saveUserDetails(User user,String email) {

		User users=User.builder().firstName(user.getFirstName()).lastName(user.getLastName()).build();
		UserProfile userProfile=UserProfile.builder().email(email).user(users).build();
	
		return ResponseEntity.ok(userProfileRepository.save(userProfile));
	}


}
