package com.hewanying.www.po;

import java.util.Date;
/**
 * 预约请求
 * @author 何婉莹
 *
 */

public class Appointment {
	
	private int id;
	private String studentId;
	private String tutorId;
	private Date submitTime;
	private Date time;
	private int status;
	
	
	public Appointment(int id, String studentId, String tutorId, Date submitTime, Date time, int status) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.tutorId = tutorId;
		this.submitTime = submitTime;
		this.time = time;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getTutorId() {
		return tutorId;
	}


	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}


	public Date getSubmitTime() {
		return submitTime;
	}


	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
