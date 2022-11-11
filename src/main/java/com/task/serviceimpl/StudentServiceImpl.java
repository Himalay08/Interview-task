package com.task.serviceimpl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		Student student1=this.studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student"," Id ",id));
		
		student1.setName(student.getName());
		student1.setDepartment(student.getDepartment());
		student1.setRollNum(student.getRollNum());
		student1.setGender(student.getGender());
		student1.setStandard(student.getStandard());
		student1.setAge(student.getAge());
		return this.studentRepository.save(student1);
	}
	@Override
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return this.studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student"," Id ",id));
	}
	@Override
	public List<Student> getAllStudents(Integer pageSize,Integer pageNum) {
		Pageable p=PageRequest.of(pageNum,pageSize);
		Page<Student> pageStudent=this.studentRepository.findAll(p);
	
		return pageStudent.getContent();
	}

}
