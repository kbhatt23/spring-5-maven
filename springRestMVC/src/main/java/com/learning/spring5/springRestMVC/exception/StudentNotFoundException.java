package com.learning.spring5.springRestMVC.exception;

public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException(String message) {
		super(message);
	}
}
