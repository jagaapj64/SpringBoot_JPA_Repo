package com.example.annotation.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.annotation.demo.model.Card1;

public interface Card1Repository extends JpaRepository<Card1, Long> {

	@Query(value="select * from card1_details cds left join items1_details ids ON cds.card1_id=ids.card1_id",nativeQuery = true)
	List<Card1> findAllCards();

}
