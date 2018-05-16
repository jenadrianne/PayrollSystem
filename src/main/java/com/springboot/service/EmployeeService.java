package com.springboot.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.Employee;
import com.springboot.repository.custom.EmployeeRepository;



@Service("EmployeeService")
public class EmployeeService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public boolean addEmployee(String lastName, String firstName, double hourlyRate, String employeeType) {
		boolean result = false;
		
		Employee employee = new Employee();
		employee.setLastName(lastName);
		employee.setFirstName(firstName);
		employee.setHourlyRate(hourlyRate);
		employee.setType(employeeType);
		
		
		result = employeeRepository.addEmployee(em, employee);
		
		return result;
	}
	
	
}
