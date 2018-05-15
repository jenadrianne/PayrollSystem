package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the overtimepay database table.
 * 
 */
@Entity
@NamedQuery(name="Overtimepay.findAll", query="SELECT o FROM Overtimepay o")
public class Overtimepay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int overtimeID;

	private double overtimeHours;

	private double overtimeRate;

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

	public Overtimepay() {
	}

	public int getOvertimeID() {
		return this.overtimeID;
	}

	public void setOvertimeID(int overtimeID) {
		this.overtimeID = overtimeID;
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