package com.learning.springMvcSql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_bean")
public class TestBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "test_property1")
	private String testProperty1;
	
	@Column(name = "test_property2")
	private String testProperty2;

	public Integer getId() {
		return id;
	}


	public TestBean(String testProperty1, String testProperty2) {
		this.testProperty1 = testProperty1;
		this.testProperty2 = testProperty2;
	}


	public TestBean() {
	}


	public String getTestProperty1() {
		return testProperty1;
	}

	public void setTestProperty1(String testProperty1) {
		this.testProperty1 = testProperty1;
	}

	public String getTestProperty2() {
		return testProperty2;
	}

	public void setTestProperty2(String testProperty2) {
		this.testProperty2 = testProperty2;
	}
	

}
