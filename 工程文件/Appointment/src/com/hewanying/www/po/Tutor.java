package com.hewanying.www.po;

import java.util.Date;
/**
 * 导师
 * @author 何婉莹
 *
 */
public class Tutor {
	
	private String id;
	private String name;
	private String institute;
	private String TEL;
	private String password;
	private String identity;
	private Date availableTime;
	private String schedule;
	
	
	public Tutor(String id, String name, String institute, String tEL, String password, String identity,
			Date availableTime, String schedule) {
		super();
		this.id = id;
		this.name = name;
		this.institute = institute;
		TEL = tEL;
		this.password = password;
		this.identity = identity;
		this.availableTime = availableTime;
		this.schedule = schedule;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getInstitute() {
		return institute;
	}


	public void setInstitute(String institute) {
		this.institute = institute;
	}


	public String getTEL() {
		return TEL;
	}


	public void setTEL(String tEL) {
		TEL = tEL;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}


	public Date getAvailableTime() {
		return availableTime;
	}


	public void setAvailableTime(Date availableTime) {
		this.availableTime = availableTime;
	}


	public String getSchedule() {
		return schedule;
	}


	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	
}
