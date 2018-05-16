package com.springboot.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the logs database table.
 * 
 */
@Entity
@Table(name="logs")
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="log_id")
	private int logId;

	@Column(name="daily_earning")
	private double dailyEarning;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="time_in")
	private Time timeIn;

	@Column(name="time_out")
	private Time timeOut;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	//bi-directional many-to-one association to OvertimePay
	@OneToMany(mappedBy="log")
	private List<OvertimePay> overtimePays;

	//bi-directional many-to-one association to Penalty
	@OneToMany(mappedBy="log")
	private List<Penalty> penalties;

	public Log() {
	}

	public int getLogId() {
		return this.logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public double getDailyEarning() {
		return this.dailyEarning;
	}

	public void setDailyEarning(double dailyEarning) {
		this.dailyEarning = dailyEarning;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTimeIn() {
		return this.timeIn;
	}

	public void setTimeIn(Time timeIn) {
		this.timeIn = timeIn;
	}

	public Time getTimeOut() {
		return this.timeOut;
	}

	public void setTimeOut(Time timeOut) {
		this.timeOut = timeOut;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<OvertimePay> getOvertimePays() {
		return this.overtimePays;
	}

	public void setOvertimePays(List<OvertimePay> overtimePays) {
		this.overtimePays = overtimePays;
	}

	public OvertimePay addOvertimePay(OvertimePay overtimePay) {
		getOvertimePays().add(overtimePay);
		overtimePay.setLog(this);

		return overtimePay;
	}

	public OvertimePay removeOvertimePay(OvertimePay overtimePay) {
		getOvertimePays().remove(overtimePay);
		overtimePay.setLog(null);

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
		penalty.setLog(this);

		return penalty;
	}

	public Penalty removePenalty(Penalty penalty) {
		getPenalties().remove(penalty);
		penalty.setLog(null);

		return penalty;
	}

}