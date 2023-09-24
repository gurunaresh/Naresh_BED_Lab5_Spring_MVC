package com.glearning.employeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glearning.employeemanagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
