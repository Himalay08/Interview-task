package com.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name="students")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="rollNum",nullable = true,length = 100)
	private int rollNum;
	
	@Column(name="name",nullable = true,length = 100)
	private String name;
	
	@Column(name="department",nullable = true,length = 100)
	private String department;
	
	@Column(name="standard",nullable = true,length = 100)
	private String standard;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="age")
	private String age;
}
