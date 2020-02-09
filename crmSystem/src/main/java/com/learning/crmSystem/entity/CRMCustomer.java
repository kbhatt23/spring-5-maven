package com.learning.crmSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "crm_customer")
public class CRMCustomer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crm_customer_id")
	private Integer id;
	
	@Column(name = "crm_customer_first_name")
	private String firstName;
	
	@Column(name = "crm_customer_last_name")
	private String lastName;
	
	@Column(name = "crm_customer_email")
	private String email;

	public CRMCustomer() {
		super();
	}

	public CRMCustomer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CRMCustomer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	

}
