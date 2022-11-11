package com.task.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.JwtAuthRequest;
import com.task.dto.TeacherDto;
import com.task.exception.InvalidUsernameOrPasswordException;
import com.task.security.JwtAuthResponse;
import com.task.security.JwtTokenHelper;
import com.task.service.TeacherService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(
			@RequestBody JwtAuthRequest request
			) throws Exception{
		this.authenticate(request.getEmail(),request.getPassword());
	 	UserDetails userDetails= this.userDetailsService.loadUserByUsername(request.getEmail());
		  String token=this.jwtTokenHelper.generateToken(userDetails);
		  
		  JwtAuthResponse jwtAuthResponse=new JwtAuthResponse();
		  jwtAuthResponse.setToken(token);
		  return new ResponseEntity<JwtAuthResponse>(jwtAuthResponse,HttpStatus.OK);
	}

	private void authenticate(String email, String password) throws Exception {
		
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(email, password);

		try {
			this.authenticationManager.authenticate(authenticationToken);
			
		} catch (BadCredentialsException e) {
		  System.out.println("Invalid Credentials!!");
		  throw new InvalidUsernameOrPasswordException("Invalid username or password!");
		}
		 
	}
	
	
	
	@PostMapping("/register")
	public ResponseEntity<TeacherDto> registerTeacher(@Valid @RequestBody TeacherDto teacherDto){
		TeacherDto newTeacherDto=this.teacherService.registerTeacher(teacherDto);
		
		return new ResponseEntity<TeacherDto>(newTeacherDto,HttpStatus.CREATED);
	}
	
	
}
