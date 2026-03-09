package com.ttil.bean;

import java.io.Serializable;

public class PaymentBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5152543486844793358L;
	
	private int res_transactionid=0;
	private int res_orderid=0;
	private String res_bank_ref_id=null;
	private String res_status=null;
	private String res_amount=null;
	private String res_paymode=null;
	private String res_reason=null;
	private String res_bankCode=null;
	private String res_bank_ref_no=null;
	private String res_trans_date_time=null;
	private String res_cin=null;
	private String bank_response=null;
	private String responseType=null;
	private String currency=null;
	private String other_details=null;
	private String country=null;
	private String merchantId=null;
	private String trans_fee=null;
	
	
	public int getRes_transactionid() {
		return res_transactionid;
	}
	public void setRes_transactionid(int res_transactionid) {
		this.res_transactionid = res_transactionid;
	}
	public String getRes_bank_ref_id() {
		return res_bank_ref_id;
	}
	public void setRes_bank_ref_id(String res_bank_ref_id) {
		this.res_bank_ref_id = res_bank_ref_id;
	}
	public String getRes_status() {
		return res_status;
	}
	public void setRes_status(String res_status) {
		this.res_status = res_status;
	}
	public String getRes_amount() {
		return res_amount;
	}
	public void setRes_amount(String res_amount) {
		this.res_amount = res_amount;
	}
	public String getRes_paymode() {
		return res_paymode;
	}
	public void setRes_paymode(String res_paymode) {
		this.res_paymode = res_paymode;
	}
	public String getRes_reason() {
		return res_reason;
	}
	public void setRes_reason(String res_reason) {
		this.res_reason = res_reason;
	}
	public String getRes_bankCode() {
		return res_bankCode;
	}
	public void setRes_bankCode(String res_bankCode) {
		this.res_bankCode = res_bankCode;
	}
	public String getRes_bank_ref_no() {
		return res_bank_ref_no;
	}
	public void setRes_bank_ref_no(String res_bank_ref_no) {
		this.res_bank_ref_no = res_bank_ref_no;
	}
	public String getRes_trans_date_time() {
		return res_trans_date_time;
	}
	public void setRes_trans_date_time(String res_trans_date_time) {
		this.res_trans_date_time = res_trans_date_time;
	}
	public String getRes_cin() {
		return res_cin;
	}
	public void setRes_cin(String res_cin) {
		this.res_cin = res_cin;
	}
	public String getBank_response() {
		return bank_response;
	}
	public void setBank_response(String bank_response) {
		this.bank_response = bank_response;
	}
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getOther_details() {
		return other_details;
	}
	public void setOther_details(String other_details) {
		this.other_details = other_details;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getTrans_fee() {
		return trans_fee;
	}
	public void setTrans_fee(String trans_fee) {
		this.trans_fee = trans_fee;
	}
	public int getRes_orderid() {
		return res_orderid;
	}
	public void setRes_orderid(int res_orderid) {
		this.res_orderid = res_orderid;
	}
	
	
	
	

}
