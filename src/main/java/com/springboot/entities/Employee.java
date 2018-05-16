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
	@Column(name="emp_id")
	private int empId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="hourly_rate")
	private double hourlyRate;

	@Column(name="last_name")
	private String lastName;

	private String type;

	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="employee")
	private List<Log> logs;

	//bi-directional many-to-one association to OvertimePay
	@OneToMany(mappedBy="employee")
	private List<OvertimePay> overtimePays;

	//bi-directional many-to-one association to Penalty
	@OneToMany(mappedBy="employee")
	private List<Penalty> penalties;

	//bi-directional many-to-one association to ReportSalary
	@OneToMany(mappedBy="employee")
	private List<ReportSalary> reportSalaries;

	//bi-directional many-to-one association to SalaryPerWeek
	@OneToMany(mappedBy="employee")
	private List<SalaryPerWeek> salaryPerWeeks;

	public Employee() {
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public List<OvertimePay> getOvertimePays() {
		return this.overtimePays;
	}

	public void setOvertimePays(List<OvertimePay> overtimePays) {
		this.overtimePays = overtimePays;
	}

	public OvertimePay addOvertimePay(OvertimePay overtimePay) {
		getOvertimePays().add(overtimePay);
		overtimePay.setEmployee(this);

		return overtimePay;
	}

	public OvertimePay removeOvertimePay(OvertimePay overtimePay) {
		getOvertimePays().remove(overtimePay);
		overtimePay.setEmployee(null);

		return overtimePay;
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

	public List<ReportSalary> getReportSalaries() {
		return this.reportSalaries;
	}

	public void setReportSalaries(List<ReportSalary> reportSalaries) {
		this.reportSalaries = reportSalaries;
	}

	public ReportSalary addReportSalary(ReportSalary reportSalary) {
		getReportSalaries().add(reportSalary);
		reportSalary.setEmployee(this);

		return reportSalary;
	}

	public ReportSalary removeReportSalary(ReportSalary reportSalary) {
		getReportSalaries().remove(reportSalary);
		reportSalary.setEmployee(null);

		return reportSalary;
	}

	public List<SalaryPerWeek> getSalaryPerWeeks() {
		return this.salaryPerWeeks;
	}

	public void setSalaryPerWeeks(List<SalaryPerWeek> salaryPerWeeks) {
		this.salaryPerWeeks = salaryPerWeeks;
	}

	public SalaryPerWeek addSalaryPerWeek(SalaryPerWeek salaryPerWeek) {
		getSalaryPerWeeks().add(salaryPerWeek);
		salaryPerWeek.setEmployee(this);

		return salaryPerWeek;
	}

	public SalaryPerWeek removeSalaryPerWeek(SalaryPerWeek salaryPerWeek) {
		getSalaryPerWeeks().remove(salaryPerWeek);
		salaryPerWeek.setEmployee(null);

		return salaryPerWeek;
	}

}