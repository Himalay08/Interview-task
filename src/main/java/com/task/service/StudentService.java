package com.task.service;


import com.task.entity.Student;

public interface StudentService {
  Student addStudent(Student student);
  Student updateStudent(Student student,Integer id);
	
	Student getStudentById(Integer id);
}
