package com.ibm.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.employee.entity.Employee;
import com.ibm.employee.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository; // Dependency Injection

	public String createEmployee(Employee employee) {
		Employee savedemployee = employeeRepository.save(employee);
		return savedemployee.getId();
	}

	public Optional<Employee> getEmployee(String employeeId) {
		return employeeRepository.findById(employeeId);
	}

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
}
