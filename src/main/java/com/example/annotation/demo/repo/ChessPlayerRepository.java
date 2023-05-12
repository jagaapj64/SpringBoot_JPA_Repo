package com.example.annotation.demo.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.annotation.demo.model.ChessPlayer;
import com.example.annotation.demo.request.PlayerNameDto;
import com.example.annotation.demo.request.PlayerStateDto;

public interface ChessPlayerRepository extends JpaRepository<ChessPlayer, Integer> ,PagingAndSortingRepository<ChessPlayer, Integer> {

//	website for this topic
//	https://thorben-janssen.com/spring-data-jpa-dto-native-queries/
	
	@Query(value="select c.first_name as firstName , c.last_name as lastName from chess_player c where c.id=:id",nativeQuery = true)
	PlayerNames findPlayerNameById(Integer id);
	
//	@Query(value="select c.first_name as firstName , c.last_name as lastName from chess_player c where c.id=:id",nativeQuery = true)
//	PlayerNameDto findPlayerNameById(Long id);

	
//	https://thorben-janssen.com/spring-data-jpa-named-queries/
	@Query(nativeQuery = true)
	PlayerNameDto findPlayerNameDtoById_Named(Integer id);
	
	@Query(nativeQuery = true)
	List<PlayerStateDto> findByPlayerAndStateDetails(Integer id);
	
	@Query(value="select c.first_name,c.last_name,c.team_name ,c.id as Id,c.date from chess_player c where c.id=:id",name  = "ChessPlayerMapping",nativeQuery = true)
	ChessPlayer findByFirstNameAndLastName(Integer id);
	
	
	List<ChessPlayer> findByStateBoardBoardName(String boardName);
	
	@Query(value="select c from ChessPlayer c left join fetch c.stateBoard")
	List<ChessPlayer> getByChessPlayersAndStateBoard();
	
	@Query(value="select * from chess_player c where c.team_name=:lastName", 
            countQuery = "select count(id) from chess_player c where c.team_name=:lastName", 
            nativeQuery = true)
	Page<ChessPlayer> getChessPlayerByLastName(String lastName,Pageable pageable);
	
	 
}

