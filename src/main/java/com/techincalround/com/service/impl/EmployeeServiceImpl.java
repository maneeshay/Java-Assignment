package com.techincalround.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techincalround.com.model.Employee;
import com.techincalround.com.repository.EmployeeRepository;
import com.techincalround.com.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
		
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepo.save(employee);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepo.getById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

}
