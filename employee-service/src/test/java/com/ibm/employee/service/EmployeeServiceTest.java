package com.ibm.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.ibm.employee.entity.Employee;
import com.ibm.employee.repo.EmployeeRepository;

class EmployeeServiceTest {

	@Test
	void testCreateEmployee() { // test case for creation of employee
		EmployeeService employeeService = new EmployeeService();
		EmployeeRepository dummyRepo = new DummyEmployeeRepository();
		employeeService.setEmployeeRepository(dummyRepo);
		Employee employee = new Employee();
		String employeeId = employeeService.createEmployee(employee);
		assertNotNull(employeeId);
	}

	@Test
	void testGetEmployee() { // test case for getting employee by id
		EmployeeService employeeService = new EmployeeService();
		EmployeeRepository dummyRepo = new DummyEmployeeRepository();
		employeeService.setEmployeeRepository(dummyRepo);
		employeeService.getEmployeeRepository();
		Employee employee = new Employee();
		String employeeId = employeeService.createEmployee(employee);
		Optional<Employee> employeeRecord = employeeService.getEmployee(employeeId);
		assertEquals(true, employeeRecord.isPresent());
	}

	@Test
	void testGetEmployees() { // test case for getting list of employees
		EmployeeService employeeService = new EmployeeService();
		EmployeeRepository dummyRepo = new DummyEmployeeRepository();
		employeeService.setEmployeeRepository(dummyRepo);
		employeeService.getEmployeeRepository();
		List<Employee> employeeList = employeeService.getEmployees();
		assertNotNull(employeeList);
	}

}
