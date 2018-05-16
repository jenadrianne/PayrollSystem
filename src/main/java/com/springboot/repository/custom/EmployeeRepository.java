package com.springboot.repository.custom;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.entities.Employee;


@Repository
@Transactional
public class EmployeeRepository {

	public boolean addEmployee(EntityManager entityManager, Employee employee) {
		boolean result = false;
		System.out.print(employee.getFirstName()+" = "+employee.getLastName()+" = "+employee.getHourlyRate()+" kayata ");
		entityManager.persist(employee);// insert into table
		System.out.println("EASDF");
		return result;
	}
}
