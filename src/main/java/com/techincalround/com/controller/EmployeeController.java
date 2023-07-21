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
	
	@GetMapping("/employee")
	public String getForm(HttpSession session) {
		
		if(session.getAttribute("user")==null) {
			return "loginForm";
		}
		return "employeeForm";
	}
	
	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		
		service.addEmployee(employee);
		return "home";
	}
	
	@GetMapping("/employeeList")
	public String listEmployee(Model model, HttpSession session) {
		
		if(session.getAttribute("user")==null) {
			return "loginForm";
		}
		
		model.addAttribute("empList", service.getAllEmployees());
		
		return "employeeList";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Long id) {
		
		service.deleteEmployee(id);

		return "redirect:/employeeList";
	}
	
	@GetMapping("/edit/{id}")
	public String updateEmp(@PathVariable Long id,Model model) {
		
		model.addAttribute("emp",service.getEmployeeById(id));
		
		return "employeeEditForm";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee employee) {
		
		service.updateEmployee(employee);
		
		return "redirect:/employeeList";
	}
	

}
