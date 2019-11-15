package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;
	
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Lob
	@Column(name = "skills", columnDefinition = "CLOB")
	private String skills;
	
	@NotNull
	@Column(name = "designation")
	private String designation;
	
	@NotNull
	@Column(name = "user_type")
	private String userType;
	
	@NotNull
	@Column(name = "email", unique = true)
	private String email;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "availability", columnDefinition="boolean default 1")
	private boolean availability;
}
