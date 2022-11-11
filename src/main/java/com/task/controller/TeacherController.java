package com.task.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
