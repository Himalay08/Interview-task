package com.task.service;


import java.util.List;

import com.task.entity.Student;

public interface StudentService {
  Student addStudent(Student student);
  Student updateStudent(Student student,Integer id);
  Student getStudentById(Integer id);
  List<Student> getAllStudents(Integer pageSize,Integer pageNum);
}
