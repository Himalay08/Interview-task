package com.task.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.task.entity.Teacher;
import com.task.exception.ResourceNotFoundException;
import com.task.repository.TeacherRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Teacher teacher;
		try {			
		    teacher=this.teacherRepository.findByEmail(email);
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("Teacher ", "Email "+ email,0);
		}
		return teacher;
	}

}
