package com.ttil.bean;

import java.io.Serializable;

public class AppDataBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5152543486844793358L;

	private int transactionid=0;
	private int order_id=0;
	private int fee_amount=0;
	private String message=null;
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getFee_amount() {
		return fee_amount;
	}
	public void setFee_amount(int fee_amount) {
		this.fee_amount = fee_amount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}




}
