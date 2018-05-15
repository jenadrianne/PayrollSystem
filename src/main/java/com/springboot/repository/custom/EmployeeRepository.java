package com.springboot.repository.custom;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	public boolean addEmployee(EntityManager entityManager, Employee employee) {
		boolean result = false;

		entityManager.persist(employee);// insert into table
		
		return result;
	}
}
