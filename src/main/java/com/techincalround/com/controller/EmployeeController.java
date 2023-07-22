/*
 * This class handles requests, prepare a model and return view page of Employee
 * @author Manisha Yadav
 * 
 */
package com.techincalround.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techincalround.com.model.Employee;
import com.techincalround.com.service.IEmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	/*
	 * This method return employee form and return login form if user is not logged in
	 * @param session Check whether the user is logged in our not
	 * 
	 * @return loginForm redirect to login page
	 * @return employeeForm redirect to employee form
	 */
	@GetMapping("/employee")
	public String getForm(HttpSession session) {
		
		if(session.getAttribute("user")==null) {
			return "loginForm";
		}
		return "employeeForm";
	}
	
	/*
	 * This method add employee to the database
	 * 
	 * @employee Object of model Employee
	 * @return home home page
	 */
	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		
		service.addEmployee(employee);
		return "home";
	}
	
	
	/*
	 * This method list out the employee stored in database
	 * @param model model of MVC
	 * @param session user interval inside the app
	 * 
	 * @return loginForm Login page
	 * @return employeeList employee list page
	 */
	@GetMapping("/employeeList")
	public String listEmployee(Model model, HttpSession session) {
		
		if(session.getAttribute("user")==null) {
			return "loginForm";
		}
		
		model.addAttribute("empList", service.getAllEmployees());
		
		return "employeeList";
	}
	
	
	/*
	 * This method deletes the desired employee data
	 * @param id id of a selected employee
	 * 
	 * @return employeeList employee list page
	 */
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Long id) {
		
		service.deleteEmployee(id);

		return "redirect:/employeeList";
	}
	
	/*
	 * This method open edit form of employee
	 * 
	 * @param id id of a selected employee
	 * @model model
	 * 
	 * @return employeeEditForm employee edit html form page
	 */
	@GetMapping("/edit/{id}")
	public String updateEmp(@PathVariable Long id,Model model) {
		
		model.addAttribute("emp",service.getEmployeeById(id));
		
		return "employeeEditForm";
	}
	
	/*
	 * This method update the data of an employee
	 * @param employee object of model class Employee
	 * @return employeeList employee list page
	 */
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee employee) {
		
		service.updateEmployee(employee);
		
		return "redirect:/employeeList";
	}
	

}
