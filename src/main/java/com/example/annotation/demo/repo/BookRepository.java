package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
