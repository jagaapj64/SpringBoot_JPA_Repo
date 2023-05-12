package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
