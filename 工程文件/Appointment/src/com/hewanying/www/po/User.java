package com.hewanying.www.po;
/**
 * 统一用户（登录用?）
 * @author 何婉莹
 *
 */
public class User {
	
	private String id;
	private String password;
	private String identity;
	
	public User(String id, String password, String identity) {
		super();
		this.id = id;
		this.password = password;
		this.identity = identity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
