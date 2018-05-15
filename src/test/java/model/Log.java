package model;

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
	private int logId;

	@Temporal(TemporalType.DATE)
	private Date date;

	private Time timeIN;

	private Time timeOUT;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empID")
	private Employee employee;

	//bi-directional many-to-one association to Overtimepay
	@OneToMany(mappedBy="log")
	private List<Overtimepay> overtimepays;

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

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTimeIN() {
		return this.timeIN;
	}

	public void setTimeIN(Time timeIN) {
		this.timeIN = timeIN;
	}

	public Time getTimeOUT() {
		return this.timeOUT;
	}

	public void setTimeOUT(Time timeOUT) {
		this.timeOUT = timeOUT;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Overtimepay> getOvertimepays() {
		return this.overtimepays;
	}

	public void setOvertimepays(List<Overtimepay> overtimepays) {
		this.overtimepays = overtimepays;
	}

	public Overtimepay addOvertimepay(Overtimepay overtimepay) {
		getOvertimepays().add(overtimepay);
		overtimepay.setLog(this);

		return overtimepay;
	}

	public Overtimepay removeOvertimepay(Overtimepay overtimepay) {
		getOvertimepays().remove(overtimepay);
		overtimepay.setLog(null);

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
		penalty.setLog(this);

		return penalty;
	}

	public Penalty removePenalty(Penalty penalty) {
		getPenalties().remove(penalty);
		penalty.setLog(null);

		return penalty;
	}

}