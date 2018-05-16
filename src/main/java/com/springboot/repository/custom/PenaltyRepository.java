package com.springboot.repository.custom;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.entities.Penalty;

@Repository
@Transactional
public class PenaltyRepository {
	
	
	public boolean addPenalty(EntityManager entityManager, Penalty penalty){
		boolean result = false;
		System.out.print(penalty.getPenaltyRate()+" = "+penalty.getTotalNoLate()+" = "+penalty.getTotalNoAbsent()+" = " +penalty.getTotalNoUndertime() + "asa naka?");
		entityManager.persist(penalty);// insert into table
		return result;
	}
	
}
