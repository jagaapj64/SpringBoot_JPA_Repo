package com.example.annotation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.annotation.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByStudentId(Long stId);

	Student findByStudentName(String name);

	@Query(value="select * from student_details st where st.address_Id in (select Id from address_details ad where ad.Id=:id)",nativeQuery = true)
	Student findByStudentByAddressId(@Param("id") Long id);

}
