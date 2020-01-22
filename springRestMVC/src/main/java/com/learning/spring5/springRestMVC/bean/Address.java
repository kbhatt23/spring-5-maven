package com.learning.spring5.springRestMVC.bean;

public class Address {

	private String address1;
	private String city;
	private String state;
	private String country;
	public Address() {
		super();
	}
	public Address(String address1, String city, String state, String country) {
		super();
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
