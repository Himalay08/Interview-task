package com.task.exception;


import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class EmailAlreadyExist extends RuntimeException {

	String message; 
	
	public EmailAlreadyExist(String message) {
		super(message);
		this.message = message;
	}
}
