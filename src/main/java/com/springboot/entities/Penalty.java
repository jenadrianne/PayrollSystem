package com.springboot.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the penalty database table.
 * 
 */
@Entity
@NamedQuery(name="Penalty.findAll", query="SELECT p FROM Penalty p")
public class Penalty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int penaltyiD;

	private double penaltyRate;

	private double totalNoAbsent;

	private double totalNoLate;

	private double totalNoUnderTime;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empID")
	private Employee employee;

	//bi-directional many-to-one association to Salaryperweek
	@ManyToOne
	@JoinColumn(name="salaryID")
	private Salaryperweek salaryperweek;

	//bi-directional many-to-one association to Log
	@ManyToOne
	@JoinColumn(name="logID")
	private Log log;

	public Penalty() {
	}

	public int getPenaltyiD() {
		return this.penaltyiD;
	}

	public void setPenaltyiD(int penaltyiD) {
		this.penaltyiD = penaltyiD;
	}

	public double getPenaltyRate() {
		return this.penaltyRate;
	}

	public void setPenaltyRate(double penaltyRate) {
		this.penaltyRate = penaltyRate;
	}

	public double getTotalNoAbsent() {
		return this.totalNoAbsent;
	}

	public void setTotalNoAbsent(double totalNoAbsent) {
		this.totalNoAbsent = totalNoAbsent;
	}

	public double getTotalNoLate() {
		return this.totalNoLate;
	}

	public void setTotalNoLate(double totalNoLate) {
		this.totalNoLate = totalNoLate;
	}

	public double getTotalNoUnderTime() {
		return this.totalNoUnderTime;
	}

	public void setTotalNoUnderTime(double totalNoUnderTime) {
		this.totalNoUnderTime = totalNoUnderTime;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Salaryperweek getSalaryperweek() {
		return this.salaryperweek;
	}

	public void setSalaryperweek(Salaryperweek salaryperweek) {
		this.salaryperweek = salaryperweek;
	}

	public Log getLog() {
		return this.log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

}