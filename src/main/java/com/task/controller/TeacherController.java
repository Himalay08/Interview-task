package com.task.controller;


import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.task.entity.Student;
import com.task.service.StudentService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student) {
		return this.studentService.addStudent(student); 
	}
	
	@GetMapping("/{id}")
	public  Student getSingleUser(@PathVariable("id") Integer id){
		System.out.println(id);
		return this.studentService.getStudentById(id);
	}
	
	@PutMapping("update/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable("id") Integer id){
		return this.studentService.updateStudent(student, id);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(
			@RequestParam(value="pageSize",defaultValue = "1",required = false) Integer pageSize,
			@RequestParam(value="pageNumber",defaultValue = "1",required = false) Integer pageNumber
			){
	
		return this.studentService.getAllStudents(pageSize,pageNumber);
	}
}
