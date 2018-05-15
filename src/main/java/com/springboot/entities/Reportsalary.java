package com.springboot.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reportsalary database table.
 * 
 */
@Entity
@NamedQuery(name="Reportsalary.findAll", query="SELECT r FROM Reportsalary r")
public class Reportsalary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int reportID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	private double salaryExpense;

	//bi-directional many-to-one association to Salaryperweek
	@ManyToOne
	@JoinColumn(name="salaryID")
	private Salaryperweek salaryperweek;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empID")
	private Employee employee;

	public Reportsalary() {
	}

	public int getReportID() {
		return this.reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
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

	public Salaryperweek getSalaryperweek() {
		return this.salaryperweek;
	}

	public void setSalaryperweek(Salaryperweek salaryperweek) {
		this.salaryperweek = salaryperweek;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}