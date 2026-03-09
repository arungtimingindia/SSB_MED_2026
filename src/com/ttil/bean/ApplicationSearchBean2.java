package com.ttil.bean;

import java.io.Serializable;

public class ApplicationSearchBean2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5152543486844793358L;
	
	private String transactionid=null;
	private String dob=null;
	private String password=null;
	private String post_applied=null;
	private String mobilenumber=null;
	private String message="";
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPost_applied() {
		return post_applied;
	}
	public void setPost_applied(String post_applied) {
		this.post_applied = post_applied;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

}
