/*
 * This class the implements the method created in interface IEmployeeService
 * @author Manisha Yadav
 */
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
	
	/*
	 * This method implements add method.
	 * @param employee obejct of Employee
	 * @return nothing
	 */
	@Override
	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
		
	}
	
	/*
	 * This method implements delete method functionalities
	 * @param id primary key of an Employee
	 * @return nothing
	 * 
	 */
	@Override
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
		
	}
	
	/*
	 * This method implements update method functionalities
	 * @param employee object of an Employee
	 * @return nothing
	 * 
	 */
	@Override
	public void updateEmployee(Employee employee) {
		employeeRepo.save(employee);
		
	}
	
	/*
	 * This method implements functionalities to find employee by id
	 * @param id primary key of an Employee
	 * @return nothing
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepo.getById(id);
	}
	
	/*
	 * This method implements functionalities to list employee
	 * 
	 * @return nothing
	 * 
	 */
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

}
