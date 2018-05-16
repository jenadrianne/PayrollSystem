package com.springboot.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the report_salary database table.
 * 
 */
@Entity
@Table(name="report_salary")
@NamedQuery(name="ReportSalary.findAll", query="SELECT r FROM ReportSalary r")
public class ReportSalary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="report_id")
	private int reportId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_created")
	private Date dateCreated;

	@Column(name="salary_expense")
	private double salaryExpense;

	//bi-directional many-to-one association to SalaryPerWeek
	@ManyToOne
	@JoinColumn(name="salary_id")
	private SalaryPerWeek salaryPerWeek;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	public ReportSalary() {
	}

	public int getReportId() {
		return this.reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public double getSalaryExpense() {
		return this.salaryExpense;
	}

	public void setSalaryExpense(double salaryExpense) {
		this.salaryExpense = salaryExpense;
	}

	public SalaryPerWeek getSalaryPerWeek() {
		return this.salaryPerWeek;
	}

	public void setSalaryPerWeek(SalaryPerWeek salaryPerWeek) {
		this.salaryPerWeek = salaryPerWeek;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}