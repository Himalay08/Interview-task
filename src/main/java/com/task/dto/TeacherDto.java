package com.task.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeacherDto {
	
	private int id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Size(min = 4,message = "Username must be 4 characters long")
	private String username;
	
    @Email(message = "Enter valid email addresss")
	@NotEmpty
	private String email;
	
    @NotEmpty
	@Size(min = 3,max = 10,message = "Password must be minimum of 3 chars and maximum of 10 characters long")
	private String password;
	
	private String gender;
	
	private String age;
}
