package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.annotation.demo.model.Items1;


public interface Items1Repository extends JpaRepository<Items1, Long> {

	@Query(value="select * from items1_details where card1_id=:cardId limit 1",nativeQuery = true)
	Items1 findByCard1Id(long cardId);


}
