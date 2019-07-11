package com.lero.model;

public class Bqperson {
	
 private int id;     
 private String num;
 private String bqstyle;  
 private String state;   
 private String absenceTime;  
 private String reason;
 private String applyTime;
 
 public Bqperson() {
		super();
		// TODO Auto-generated constructor stub
	}
 public Bqperson(String num, String bqstyle, String state, String absenceTime, String reason, String applyTime) {
		this.num = num;
		this.bqstyle = bqstyle;
		this.state = state;
		this.absenceTime = absenceTime;
		this.reason = reason;
		this.applyTime = applyTime;
	}
 
public Bqperson(int id, String num, String bqstyle, String state, String absenceTime, String reason, String applyTime) {
	super();
	this.id = id;
	this.num = num;
	this.bqstyle = bqstyle;
	this.state = state;
	this.absenceTime = absenceTime;
	this.reason = reason;
	this.applyTime = applyTime;
}
public String getApplyTime() {
	return applyTime;
}
public void setApplyTime(String applyTime) {
	this.applyTime = applyTime;
}

@Override
public String toString() {
	return "Bqperson [id=" + id + ", num=" + num + ", bqstyle=" + bqstyle + ", state=" + state + ", absenceTime="
			+ absenceTime + ", reason=" + reason + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getBqstyle() {
	return bqstyle;
}
public void setBqstyle(String bqstyle) {
	this.bqstyle = bqstyle;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getAbsenceTime() {
	return absenceTime;
}
public void setAbsenceTime(String absenceTime) {
	this.absenceTime = absenceTime;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}  

}
