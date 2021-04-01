package com.ibm.employee.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
