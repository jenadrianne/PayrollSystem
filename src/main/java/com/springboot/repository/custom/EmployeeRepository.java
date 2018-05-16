package com.springboot.repository.custom;

import java.util.ArrayList;
import java.util.List;

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
		System.out.print(employee.getFirstName()+" = "+employee.getLastName()+" = "+employee.getHourlyRate()+" kayata ");
		entityManager.merge(employee);// insert or update into table
		return result;
	}
	
	public Employee getEmployee(EntityManager entityManager, String id){
		StringBuilder employeeQuery = new StringBuilder("FROM Employee WHERE emp_id = :id");
		Query query = entityManager.createQuery(employeeQuery.toString());
		query.setParameter("id",id);
		Employee employee = (Employee)query.getSingleResult();
		
		return employee;
	}
	
	public List<Employee> getEmployees(EntityManager em){
		StringBuilder employeeQuery = new StringBuilder("FROM Employee");
		Query query = em.createQuery(employeeQuery.toString());
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}
	
	public void removeEmployee(EntityManager em, String[] empID){
		Query query = em.createQuery("DELETE FROM Employee WHERE empId = :employeeID");
		List<Integer> employeeList = new ArrayList<Integer>();
		for(String employeeToDelete : empID) {
			employeeList.add(Integer.parseInt(employeeToDelete));
		}
		query.setParameter("employeeID", employeeList);
		query.executeUpdate();

	}
	
	public Employee getEmployeeById(EntityManager em, String empID){
		return em.find(Employee.class, Integer.parseInt(empID));
	}
}
	

