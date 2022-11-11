package com.task.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entity.Student;
import com.task.exception.ResourceNotFoundException;
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
	@Override
	public Student updateStudent(Student student, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return this.studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student"," Id ",id));
	}

}
