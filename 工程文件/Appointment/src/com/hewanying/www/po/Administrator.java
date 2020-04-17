package com.hewanying.www.po;
/**
 * 管理员
 * @author 何婉莹
 *
 */
public class Administrator {
	
	private String id;
	private String name;
	private String TEL;
	private String password;
	private String identity;
	
	
	public Administrator(String id, String name, String tEL, String password, String identity) {
		super();
		this.id = id;
		this.name = name;
		TEL = tEL;
		this.password = password;
		this.identity = identity;
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
	
	
}
