package com.springboot.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.Log;
import com.springboot.entities.Employee;
import com.springboot.entities.SalaryPerWeek;
import com.springboot.entities.Student;
import com.springboot.repository.custom.LogsRepository;
import com.springboot.repository.custom.SalaryperweekRepository;
import com.springboot.repository.custom.EmployeeRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("SalaryperweekService")
public class SalaryperweekService {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private LogsRepository logsrepository;
	@Autowired
	private EmployeeRepository employeerepository;
	@Autowired
	private SalaryperweekRepository salaryperweekrepository;
	
	public void calculateSalaryPerWeek(String id){
		 double total = 0;
		 List<Log> logs = logsrepository.getEmployeeLogs(em, id);
		 
		 int size = logs.size();
		
		 for(int i = 0; i < size; i++){
			 total = logs.get(i).getDailyEarning();
		 }
		 
		 SalaryPerWeek salaryperweek = new SalaryPerWeek();
		 Employee employee = employeerepository.getEmployee(em, id);
		 
		 Calendar cal = Calendar.getInstance();	
		 Date dater = cal.getTime();
		 
		 salaryperweek.setNetSalary(total);
		 salaryperweek.setEmployee(employee);
		 salaryperweek.setBasicSalary(12);
		 salaryperweek.setDateCreated(dater);
		 
		 System.out.println("asds = "+salaryperweek.getBasicSalary() + " "+salaryperweek.getEmployee().getFirstName() + " "+salaryperweek.getNetSalary());
		
		 salaryperweekrepository.saveSalaryPerWeek(em, salaryperweek);
	}
	
	public List<SalaryPerWeek> getSalariesPerWeek() {
		return  salaryperweekrepository.getSalaries(em);
	}
}
