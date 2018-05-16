package com.springboot.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.Penalty;
import com.springboot.repository.custom.PenaltyRepository;

@Service("penaltyService")
public class PenaltyService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PenaltyRepository penaltyRepository;
	
	public void calculatePenalty(String time_in, String time_out){
		Penalty pen = new Penalty();
		System.out.println(time_in);
		double penalty = 0.0;
		double total_late = 0;
		double total_absent = 0;
		double total_undertime = 0;
		long timeIn = Long.parseLong(time_in);
		long timeOut = Long.parseLong(time_out);
		long startTime = 28800000; //8AM
		long endTime = 57600000; //4PM
		
		if(timeIn >= 46800000){
			total_absent = 1;
			penalty = 1000;
		}else{
			if(startTime > timeIn){
				long totalTime = timeIn - startTime;
				if(totalTime <= 900000){
					total_late = 1;
					penalty = 25;
				}else{
					int temp = (int) Math.ceil( totalTime / 900000);
					total_late = temp;
					penalty = 25 * total_late;
				}
			}
		}
		
		if(timeOut < endTime){
			long totalTime = endTime - timeOut;
			
			if(totalTime <= 900000){
				total_undertime = 1;
				penalty += 25;				
			}else{
				int temp = (int) Math.ceil( totalTime / 900000);
				total_undertime = temp;
				penalty = 25 * total_undertime;
			}
		}
		
		pen.setTotalNoAbsent(total_absent);
		pen.setTotalNoLate(total_late);
		pen.setTotalNoUndertime(total_undertime);
		pen.setPenaltyRate(penalty);
		
		penaltyRepository.addPenalty(em, pen);
	}
}
