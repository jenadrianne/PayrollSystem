package com.springboot.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int empID;

	private String firstName;

	private double hourlyRate;

	private String lastName;

	private String type;

	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="employee")
	private List<Log> logs;

	//bi-directional many-to-one association to Overtimepay
	@OneToMany(mappedBy="employee")
	private List<Overtimepay> overtimepays;

	//bi-directional many-to-one association to Penalty
	@OneToMany(mappedBy="employee")
	private List<Penalty> penalties;

	//bi-directional many-to-one association to Reportsalary
	@OneToMany(mappedBy="employee")
	private List<Reportsalary> reportsalaries;

	//bi-directional many-to-one association to Salaryperweek
	@OneToMany(mappedBy="employee")
	private List<Salaryperweek> salaryperweeks;

	public Employee() {
	}

	public int getEmpID() {
		return this.empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getHourlyRate() {
		return this.hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public Log addLog(Log log) {
		getLogs().add(log);
		log.setEmployee(this);

		return log;
	}

	public Log removeLog(Log log) {
		getLogs().remove(log);
		log.setEmployee(null);

		return log;
	}

	public List<Overtimepay> getOvertimepays() {
		return this.overtimepays;
	}

	public void setOvertimepays(List<Overtimepay> overtimepays) {
		this.overtimepays = overtimepays;
	}

	public Overtimepay addOvertimepay(Overtimepay overtimepay) {
		getOvertimepays().add(overtimepay);
		overtimepay.setEmployee(this);

		return overtimepay;
	}

	public Overtimepay removeOvertimepay(Overtimepay overtimepay) {
		getOvertimepays().remove(overtimepay);
		overtimepay.setEmployee(null);

		return overtimepay;
	}

	public List<Penalty> getPenalties() {
		return this.penalties;
	}

	public void setPenalties(List<Penalty> penalties) {
		this.penalties = penalties;
	}

	public Penalty addPenalty(Penalty penalty) {
		getPenalties().add(penalty);
		penalty.setEmployee(this);

		return penalty;
	}

	public Penalty removePenalty(Penalty penalty) {
		getPenalties().remove(penalty);
		penalty.setEmployee(null);

		return penalty;
	}

	public List<Reportsalary> getReportsalaries() {
		return this.reportsalaries;
	}

	public void setReportsalaries(List<Reportsalary> reportsalaries) {
		this.reportsalaries = reportsalaries;
	}

	public Reportsalary addReportsalary(Reportsalary reportsalary) {
		getReportsalaries().add(reportsalary);
		reportsalary.setEmployee(this);

		return reportsalary;
	}

	public Reportsalary removeReportsalary(Reportsalary reportsalary) {
		getReportsalaries().remove(reportsalary);
		reportsalary.setEmployee(null);

		return reportsalary;
	}

	public List<Salaryperweek> getSalaryperweeks() {
		return this.salaryperweeks;
	}

	public void setSalaryperweeks(List<Salaryperweek> salaryperweeks) {
		this.salaryperweeks = salaryperweeks;
	}

	public Salaryperweek addSalaryperweek(Salaryperweek salaryperweek) {
		getSalaryperweeks().add(salaryperweek);
		salaryperweek.setEmployee(this);

		return salaryperweek;
	}

	public Salaryperweek removeSalaryperweek(Salaryperweek salaryperweek) {
		getSalaryperweeks().remove(salaryperweek);
		salaryperweek.setEmployee(null);

		return salaryperweek;
	}

}