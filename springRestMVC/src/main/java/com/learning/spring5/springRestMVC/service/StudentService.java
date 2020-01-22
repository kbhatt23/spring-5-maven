package com.learning.spring5.springRestMVC.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.management.monitor.CounterMonitorMBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.learning.spring5.springRestMVC.bean.Address;
import com.learning.spring5.springRestMVC.bean.Student;
import com.learning.spring5.springRestMVC.exception.StudentNotFoundException;

@Service
//default is singleton but for readabilitity added below
@Scope("singleton")
public class StudentService {

	//instead of using static java feature
	//we can use post construct
	//since scope of service is global
//	private static List<Student> allStudents = new ArrayList<Student>();
	
	private  List<Student> allStudents = new ArrayList<Student>();
	private int studentCount=0;
	
	/*
	 * static { Address address1 = new Address("c502 majestic appartment",
	 * "dwarka delhi", "new delhi", "india");
	 * 
	 * Address address2 = new Address("c502 majestic appartment", "dwarka delhi",
	 * "new delhi", "india");
	 * 
	 * 
	 * Student s1 = new Student("sita", "ram", address1); Student s2 = new
	 * Student("radha", "krishna",address2); allStudents.add(s1);
	 * allStudents.add(s2); }
	 */
	
	//gets called after constructor call
	//sincel scope is singleton this will be loaded only once
	//also modification from one thrad will load same data for all threads
	//as instance is same
	@PostConstruct
	public void loadStudents() {
		Address address1 = new Address("c502 majestic appartment", "dwarka delhi", "new delhi", "india");
		
		Address address2 = new Address("c502 majestic appartment", "dwarka delhi", "new delhi", "india");
		
		
		Student s1 = new Student("sita", "ram", address1);
		Student s2 = new Student("radha", "krishna",address2);
		Student s3 = new Student("uma", "maheshwar",address2);
		s1.setId(++studentCount);
		s2.setId(++studentCount);
		s3.setId(++studentCount);
		allStudents.add(s1);
		allStudents.add(s2);
		allStudents.add(s3);
	}

	public List<Student> fetchAllStudents(){
		return allStudents;
	}
	
	public Student fetchStudentById(int id) {
		return this.fetchAllStudents()
		.stream()
		.filter(student -> id == student.getId())
		.findFirst()
		.orElseThrow(() -> new StudentNotFoundException("Student not found with id "+id));
	}
	public Student createStudent(Student student) {
		student.setId(++studentCount);
		allStudents.add(student);
		return student;
	}
	
	public Student updateStudent(Student student,int id) {
		Student stu = fetchStudentById(id);
		stu.setAddress(student.getAddress());
		stu.setFirstName(student.getFirstName());
		stu.setLastName(student.getLastName());
		return stu;
	}
	
	public void deleteStudent(int id) {
		for(Student student :fetchAllStudents()) {
			if(id==student.getId()) {
				allStudents.remove(student);
				--studentCount;
				break;
			}
				
		}
	
	}
}
