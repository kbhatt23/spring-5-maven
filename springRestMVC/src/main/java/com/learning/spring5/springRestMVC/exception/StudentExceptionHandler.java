package com.learning.spring5.springRestMVC.exception;

import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//this means any exception will take a look here
//if exception is handled here it uses it to retunr data in json using jackson
@ControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<StudentErrorResponse> handleStudentException(StudentNotFoundException ex){
		
		StudentErrorResponse res = new StudentErrorResponse(ex.getMessage(), Calendar.getInstance().getTimeInMillis());
		
		return new ResponseEntity<StudentErrorResponse>(res, HttpStatus.NOT_FOUND);
		
	}
}
