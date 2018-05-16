package com.springboot.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the overtime_pay database table.
 * 
 */
@Entity
@Table(name="overtime_pay")
@NamedQuery(name="OvertimePay.findAll", query="SELECT o FROM OvertimePay o")
public class OvertimePay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="overtime_id")
	private int overtimeId;

	@Column(name="overtime_hours")
	private double overtimeHours;

	@Column(name="overtime_rate")
	private double overtimeRate;

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

	public OvertimePay() {
	}

	public int getOvertimeId() {
		return this.overtimeId;
	}

	public void setOvertimeId(int overtimeId) {
		this.overtimeId = overtimeId;
	}

	public double getOvertimeHours() {
		return this.overtimeHours;
	}

	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}

	public double getOvertimeRate() {
		return this.overtimeRate;
	}

	public void setOvertimeRate(double overtimeRate) {
		this.overtimeRate = overtimeRate;
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