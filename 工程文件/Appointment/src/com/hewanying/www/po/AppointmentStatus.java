package com.hewanying.www.po;
/**
 * 预约请求状态标签
 * @author 何婉莹
 *
 */
public class AppointmentStatus {

	private int pend;
	private int pass;
	private int fail;
	
	
	public AppointmentStatus(int pend, int pass, int fail) {
		super();
		this.pend = pend;
		this.pass = pass;
		this.fail = fail;
	}


	public int getPend() {
		return pend;
	}


	public void setPend(int pend) {
		this.pend = pend;
	}


	public int getPass() {
		return pass;
	}


	public void setPass(int pass) {
		this.pass = pass;
	}


	public int getFail() {
		return fail;
	}


	public void setFail(int fail) {
		this.fail = fail;
	}
	
	
}
