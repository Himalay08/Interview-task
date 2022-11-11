package com.task.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

	Teacher findByEmail(String email);
	
}
