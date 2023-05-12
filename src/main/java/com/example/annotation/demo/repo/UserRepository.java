package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
