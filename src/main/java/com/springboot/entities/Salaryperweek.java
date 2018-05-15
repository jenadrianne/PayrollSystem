package com.springboot.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the salaryperweek database table.
 * 
 */
@Entity
@NamedQuery(name="Salaryperweek.findAll", query="SELECT s FROM Salaryperweek s")
public class Salaryperweek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int salaryID;

	private double basicSalary;

	private double netSalary;

	//bi-directional many-to-one association to Overtimepay
	@OneToMany(mappedBy="salaryperweek")
	private List<Overtimepay> overtimepays;

	//bi-directional many-to-one association to Penalty
	@OneToMany(mappedBy="salaryperweek")
	private List<Penalty> penalties;

	//bi-directional many-to-one association to Reportsalary
	@OneToMany(mappedBy="salaryperweek")
	private List<Reportsalary> reportsalaries;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empID")
	private Employee employee;

	public Salaryperweek() {
	}

	public int getSalaryID() {
		return this.salaryID;
	}

	public void setSalaryID(int salaryID) {
		this.salaryID = salaryID;
	}

	public double getBasicSalary() {
		return this.basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getNetSalary() {
		return this.netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	public List<Overtimepay> getOvertimepays() {
		return this.overtimepays;
	}

	public void setOvertimepays(List<Overtimepay> overtimepays) {
		this.overtimepays = overtimepays;
	}

	public Overtimepay addOvertimepay(Overtimepay overtimepay) {
		getOvertimepays().add(overtimepay);
		overtimepay.setSalaryperweek(this);

		return overtimepay;
	}

	public Overtimepay removeOvertimepay(Overtimepay overtimepay) {
		getOvertimepays().remove(overtimepay);
		overtimepay.setSalaryperweek(null);

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
		penalty.setSalaryperweek(this);

		return penalty;
	}

	public Penalty removePenalty(Penalty penalty) {
		getPenalties().remove(penalty);
		penalty.setSalaryperweek(null);

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
		reportsalary.setSalaryperweek(this);

		return reportsalary;
	}

	public Reportsalary removeReportsalary(Reportsalary reportsalary) {
		getReportsalaries().remove(reportsalary);
		reportsalary.setSalaryperweek(null);

		return reportsalary;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}