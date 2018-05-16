package com.springboot.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the salary_per_week database table.
 * 
 */
@Entity
@Table(name="salary_per_week")
@NamedQuery(name="SalaryPerWeek.findAll", query="SELECT s FROM SalaryPerWeek s")
public class SalaryPerWeek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="salary_id")
	private int salaryId;

	@Column(name="basic_salary")
	private double basicSalary;
	
	@Column(name="date_created")
	private Date dateCreated;

	@Column(name="net_salary")
	private double netSalary;

	//bi-directional many-to-one association to OvertimePay
	@OneToMany(mappedBy="salaryPerWeek")
	private List<OvertimePay> overtimePays;

	//bi-directional many-to-one association to Penalty
	@OneToMany(mappedBy="salaryPerWeek")
	private List<Penalty> penalties;

	//bi-directional many-to-one association to ReportSalary
	@OneToMany(mappedBy="salaryPerWeek")
	private List<ReportSalary> reportSalaries;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	public SalaryPerWeek() {
	}

	public int getSalaryId() {
		return this.salaryId;
	}
	
	public Date getDateCreated(){
		return this.dateCreated;
	}
	public void setDateCreated(Date date){
		this.dateCreated = date;
	}
	
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
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

	public List<OvertimePay> getOvertimePays() {
		return this.overtimePays;
	}

	public void setOvertimePays(List<OvertimePay> overtimePays) {
		this.overtimePays = overtimePays;
	}

	public OvertimePay addOvertimePay(OvertimePay overtimePay) {
		getOvertimePays().add(overtimePay);
		overtimePay.setSalaryPerWeek(this);

		return overtimePay;
	}

	public OvertimePay removeOvertimePay(OvertimePay overtimePay) {
		getOvertimePays().remove(overtimePay);
		overtimePay.setSalaryPerWeek(null);

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
		penalty.setSalaryPerWeek(this);

		return penalty;
	}

	public Penalty removePenalty(Penalty penalty) {
		getPenalties().remove(penalty);
		penalty.setSalaryPerWeek(null);

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
		reportSalary.setSalaryPerWeek(this);

		return reportSalary;
	}

	public ReportSalary removeReportSalary(ReportSalary reportSalary) {
		getReportSalaries().remove(reportSalary);
		reportSalary.setSalaryPerWeek(null);

		return reportSalary;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}