package com.task.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entity.Student;
import com.task.repository.StudentRepository;
import com.task.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Student addStudent(Student student) {
		
		return this.studentRepository.save(student);
	}

}
