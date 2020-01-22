package com.learning.spring5.springRestMVC.exception;

import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<StudentErrorResponse> handleGenericError(Exception ex) {
		
		StudentErrorResponse res = new StudentErrorResponse(ex.getMessage(), Calendar.getInstance().getTimeInMillis());
		return new ResponseEntity<StudentErrorResponse>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
