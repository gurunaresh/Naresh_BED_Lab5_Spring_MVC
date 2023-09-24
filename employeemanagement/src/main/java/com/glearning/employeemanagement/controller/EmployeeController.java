package com.glearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.glearning.employeemanagement.entity.Employee;
import com.glearning.employeemanagement.service.EmployeeService;



@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
//	Employee List API
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees",employees);
		return "employees/employeeslist";
	}
	
//	Employee form
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return("employees/employee-create-form");
	}
	
//	Function to save the Employee record
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/list";
	}
	
//	Employee form to update the record
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int Id, Model model) {
		Employee employee = employeeService.findById(Id);
		model.addAttribute("employee", employee);
		return "/employees/employee-update-form";
	}
	
//	Delete Employee record
	@PostMapping("/delete")
	public String delete(@RequestParam("employeeId")int Id) {
		employeeService.deleteById(Id);
		return "redirect:/employees/list";
	}

}
