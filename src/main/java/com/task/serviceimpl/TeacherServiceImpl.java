package com.task.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.dto.TeacherDto;
import com.task.entity.Teacher;
import com.task.exception.EmailAlreadyExist;
import com.task.repository.TeacherRepository;
import com.task.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public TeacherDto registerTeacher(TeacherDto teacherDto) {
		
		if(this.teacherRepository.findByEmail(teacherDto.getEmail())!=null) {
			throw new EmailAlreadyExist("This email id already register with us!!");
		}
		
		Teacher teacher = this.modelMapper.map(teacherDto,Teacher.class);
		
		teacher.setPassword(this.passwordEncoder.encode(teacherDto.getPassword()));
		
		Teacher newTeacher = this.teacherRepository.save(teacher);
		
		return this.modelMapper.map(newTeacher,TeacherDto.class);
	}

}
