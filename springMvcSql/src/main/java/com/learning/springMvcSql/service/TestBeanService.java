package com.learning.springMvcSql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springMvcSql.entity.TestBean;
import com.learning.springMvcSql.entity.TestBeanJPARepository;

@Service
@Transactional
public class TestBeanService {
	
	@Autowired
	private TestBeanJPARepository testBeanJPARepository;
	
	public void save(TestBean testBean) {
		testBeanJPARepository.save(testBean);
	}
	
	public List<TestBean> fetchAll(){
		return testBeanJPARepository.findAll();
	}

}
