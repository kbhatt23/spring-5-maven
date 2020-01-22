package com.learning.spring5.springRestMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring5.springRestMVC.bean.Student;
import com.learning.spring5.springRestMVC.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping()
	public List<Student> fetchStudents() {
		return service.fetchAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student fetchStudent(@PathVariable int id) {

		return service.fetchStudentById(id);
	}
	//we can move this out to a glocal class and add @contoladvice to the class level
	
	/*
	 * @ExceptionHandler(StudentNotFoundException.class) public
	 * ResponseEntity<StudentErrorResponse>
	 * handleStudentException(StudentNotFoundException ex){
	 * 
	 * StudentErrorResponse res = new StudentErrorResponse(ex.getMessage(),
	 * Calendar.getInstance().getTimeInMillis());
	 * 
	 * return new ResponseEntity<StudentErrorResponse>(res, HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */
	
	@PostMapping()
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		
		return new ResponseEntity<>(service.createStudent(student), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
		return service.updateStudent(student, id);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent( @PathVariable int id){
		service.deleteStudent(id);
		return new ResponseEntity<String>("jai shree ram", HttpStatus.NO_CONTENT);
	}
	
	 
}
