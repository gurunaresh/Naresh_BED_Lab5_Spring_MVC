package com.glearning.employeemanagement.service;

import java.util.List;

import com.glearning.employeemanagement.entity.Employee;


//Service where all the CRUD operations are declared

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

}
