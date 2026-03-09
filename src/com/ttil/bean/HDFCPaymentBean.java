package com.ttil.bean;

import java.io.Serializable;

public class HDFCPaymentBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5152543486844793358L;
	
	private int res_transactionid=0;
	private String order_id=null;
	private String tracking_id=null;
	private String bank_ref_no=null;
	private String order_status=null;
	private String failure_message=null;
	private String payment_mode=null;
	private String card_name=null;
	private String status_code=null;
	private String status_message=null;
	private String currency=null;
	private String amount=null;
	private String merchant_param1=null;
	private String merchant_param2=null;
	private String mer_amount=null;
	private String vault=null;
	private String retry=null;
	private String response_code=null;
	private String billing_notes=null;
	private String trans_date=null;
	private String bin_country=null;
	private String bank_response=null;
	private String responseType=null;
	
	public int getRes_transactionid() {
		return res_transactionid;
	}
	public void setRes_transactionid(int res_transactionid) {
		this.res_transactionid = res_transactionid;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getTracking_id() {
		return tracking_id;
	}
	public void setTracking_id(String tracking_id) {
		this.tracking_id = tracking_id;
	}
	public String getBank_ref_no() {
		return bank_ref_no;
	}
	public void setBank_ref_no(String bank_ref_no) {
		this.bank_ref_no = bank_ref_no;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getFailure_message() {
		return failure_message;
	}
	public void setFailure_message(String failure_message) {
		this.failure_message = failure_message;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getStatus_message() {
		return status_message;
	}
	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getMerchant_param1() {
		return merchant_param1;
	}
	public void setMerchant_param1(String merchant_param1) {
		this.merchant_param1 = merchant_param1;
	}
	public String getMerchant_param2() {
		return merchant_param2;
	}
	public void setMerchant_param2(String merchant_param2) {
		this.merchant_param2 = merchant_param2;
	}
	public String getMer_amount() {
		return mer_amount;
	}
	public void setMer_amount(String mer_amount) {
		this.mer_amount = mer_amount;
	}
	
	public String getVault() {
		return vault;
	}
	public void setVault(String vault) {
		this.vault = vault;
	}
	public String getRetry() {
		return retry;
	}
	public void setRetry(String retry) {
		this.retry = retry;
	}
	public String getResponse_code() {
		return response_code;
	}
	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}
	public String getBilling_notes() {
		return billing_notes;
	}
	public void setBilling_notes(String billing_notes) {
		this.billing_notes = billing_notes;
	}
	public String getTrans_date() {
		return trans_date;
	}
	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}
	public String getBin_country() {
		return bin_country;
	}
	public void setBin_country(String bin_country) {
		this.bin_country = bin_country;
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
	
	
	
	
	
	

}
