package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.annotation.demo.model.CourseDetails;

public interface CourseDetailsRepository extends JpaRepository<CourseDetails, Long> {

}
