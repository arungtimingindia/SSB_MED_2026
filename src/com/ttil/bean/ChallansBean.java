package com.ttil.bean;

import java.io.Serializable;

public class ChallansBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5152543486844793358L;
	
	private int transactionid=0;
	private String first_name=null;
	private String middle_name=null;
	private String last_name=null;
	private String mobileNumber=null;
	private String emailaddress=null;
	private String sex=null;
	private String community=null;
	private String dob_name=null;
	private boolean payExempted;
	private int fee_amount=0;
	private int bank_charges=0;
	private int total_amount=0;
	private String notification_number=null;
	private String org_name=null;
	private String post_name=null;
	private String post_end_date=null;
	
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getDob_name() {
		return dob_name;
	}
	public void setDob_name(String dob_name) {
		this.dob_name = dob_name;
	}
	public String getNotification_number() {
		return notification_number;
	}
	public void setNotification_number(String notification_number) {
		this.notification_number = notification_number;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getPost_end_date() {
		return post_end_date;
	}
	public void setPost_end_date(String post_end_date) {
		this.post_end_date = post_end_date;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public boolean isPayExempted() {
		return payExempted;
	}
	public void setPayExempted(boolean payExempted) {
		this.payExempted = payExempted;
	}
	public int getFee_amount() {
		return fee_amount;
	}
	public void setFee_amount(int fee_amount) {
		this.fee_amount = fee_amount;
	}
	public int getBank_charges() {
		return bank_charges;
	}
	public void setBank_charges(int bank_charges) {
		this.bank_charges = bank_charges;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	

}
