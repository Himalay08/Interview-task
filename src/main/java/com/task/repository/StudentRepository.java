package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
