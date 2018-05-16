package com.springboot.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.entities.Employee;
import com.springboot.entities.Log;
import com.springboot.entities.SalaryPerWeek;

@Repository
@Transactional
public class LogsRepository {
	
 public List<Log> getEmployeeLogs(EntityManager entityManager, String id){
	 
	 
	 Calendar cal = Calendar.getInstance();
	 cal.add(Calendar.DATE, -5);
	
	 Date dater = cal.getTime();
	 
	 int ids = Integer.parseInt(id);
	 
	 StringBuilder logQuery = new StringBuilder("FROM Log l WHERE l.employee = :ids AND l.date >= :dater AND l.date < NOW()"); 
	 Query query = entityManager.createQuery(logQuery.toString());
	 
	 query.setParameter("ids", entityManager.find(Employee.class, ids));
	 query.setParameter("dater", dater);
	 
	 List<Log> logs = query.getResultList();
	 System.out.print(logs.size()+ " jereco ");
	 
	 
	 return logs;
 }
 

	
}
