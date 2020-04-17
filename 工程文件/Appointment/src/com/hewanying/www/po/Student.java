package com.hewanying.www.po;
/**
 * 学生
 * @author 何婉莹
 *
 */
public class Student {

	private String id;
	private String name;
	private String institute;
	private String TEL;
	private String password;
	private String identity;
	private int status;
	
	
	public Student(String id, String name, String institute, String tEL, String password, String identity, int status) {
		super();
		this.id = id;
		this.name = name;
		this.institute = institute;
		TEL = tEL;
		this.password = password;
		this.identity = identity;
		this.status = status;
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
