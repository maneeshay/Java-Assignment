package com.techincalround.com.service;

import java.util.List;

import com.techincalround.com.model.Employee;

public interface IEmployeeService {
	void addEmployee(Employee employee);
	void deleteEmployee(Long id);
	void updateEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	
	List<Employee> getAllEmployees();
}
