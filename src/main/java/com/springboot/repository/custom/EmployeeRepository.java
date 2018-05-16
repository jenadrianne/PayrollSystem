package com.springboot.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.entities.Employee;


@Repository
@Transactional
public class EmployeeRepository {

	public boolean addEmployee(EntityManager entityManager, Employee employee) {
		boolean result = false;
		entityManager.persist(employee);// insert into table
		System.out.println("EASDF");
		return result;
	}
	
	public Employee getEmployee(EntityManager entityManager, String id){
		
		StringBuilder employeeQuery = new StringBuilder("FROM Employee WHERE emp_id = :id");
		Query query = entityManager.createQuery(employeeQuery.toString());
		query.setParameter("id",id);
		Employee employee = (Employee)query.getSingleResult();
		
		return employee;
	}
}
