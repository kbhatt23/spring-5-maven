package com.learning.springMvcSql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springMvcSql.entity.TestBean;
import com.learning.springMvcSql.service.TestBeanService;

@RestController
public class TestController {

	@Autowired
	private TestBeanService testBeanService;
	
	@RequestMapping("/test")
	public String test() {
		return "jai shree ram";
	}
	
	@GetMapping("/jpaTest")
	public List<TestBean> fetchAll(){
		return testBeanService.fetchAll();
	}
	
	@PostMapping("/jpaTest")
	public ResponseEntity<String> save(@RequestBody TestBean testBean){
		testBeanService.save(testBean);
		
		return new ResponseEntity<String>("jai shree ram", HttpStatus.CREATED);
	}
}
