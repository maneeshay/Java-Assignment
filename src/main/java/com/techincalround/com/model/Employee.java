package com.techincalround.com.model;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fname;
	private String lname;
	private String gender;
	private String phone;
	private String email;
	private int age;
	private String companyName;
	private String post;
	private int salary;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate joinDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	private LocalDate createdAt=LocalDate.now();
	
	@ElementCollection
	@CollectionTable
	private Set<String> projects;

}
