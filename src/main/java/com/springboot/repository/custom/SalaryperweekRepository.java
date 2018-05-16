package com.springboot.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.entities.SalaryPerWeek;

@Repository
@Transactional
public class SalaryperweekRepository {
	
	 public boolean saveSalaryPerWeek(EntityManager entityManager,SalaryPerWeek salaryperweek){	  
		  boolean ret = false; 
		  entityManager.persist(salaryperweek);
		  return ret;
	 }
	 
	 public List<SalaryPerWeek> getSalaries(EntityManager em) {
			StringBuilder studentQuery = new StringBuilder("FROM SalaryPerWeek");
			Query query = em.createQuery(studentQuery.toString());
			List<SalaryPerWeek> salaryList = query.getResultList();
			return salaryList;
		}
}
