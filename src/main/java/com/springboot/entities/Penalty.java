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
	@Column(name="penalty_id")
	private int penaltyId;

	@Column(name="penalty_rate")
	private double penaltyRate;

	@Column(name="total_no_absent")
	private double totalNoAbsent;

	@Column(name="total_no_late")
	private double totalNoLate;

	@Column(name="total_no_undertime")
	private double totalNoUndertime;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	//bi-directional many-to-one association to SalaryPerWeek
	@ManyToOne
	@JoinColumn(name="salary_id")
	private SalaryPerWeek salaryPerWeek;

	//bi-directional many-to-one association to Log
	@ManyToOne
	@JoinColumn(name="log_id")
	private Log log;

	public Penalty() {
	}

	public int getPenaltyId() {
		return this.penaltyId;
	}

	public void setPenaltyId(int penaltyId) {
		this.penaltyId = penaltyId;
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

	public double getTotalNoUndertime() {
		return this.totalNoUndertime;
	}

	public void setTotalNoUndertime(double totalNoUndertime) {
		this.totalNoUndertime = totalNoUndertime;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public SalaryPerWeek getSalaryPerWeek() {
		return this.salaryPerWeek;
	}

	public void setSalaryPerWeek(SalaryPerWeek salaryPerWeek) {
		this.salaryPerWeek = salaryPerWeek;
	}

	public Log getLog() {
		return this.log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

}