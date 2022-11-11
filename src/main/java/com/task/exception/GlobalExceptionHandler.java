package com.task.exception;


import java.util.HashMap; 
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.task.utils.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String,String> res=new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
		  String fieldName=((FieldError)error).getField();
		  String message=error.getDefaultMessage();
		  res.put(fieldName, message);
		}
		);
		return new ResponseEntity<Map<String,String>>(res,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailAlreadyExist.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(EmailAlreadyExist ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.FOUND);
		
	}
	
	@ExceptionHandler(InvalidUsernameOrPasswordException.class)
	public ResponseEntity<ApiResponse> invalidUsernameOrPasswordExceptionHandler(InvalidUsernameOrPasswordException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ApiResponse> accessDeniedExceptionExceptionHandler(AccessDeniedException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.UNAUTHORIZED);
		
	}
}
