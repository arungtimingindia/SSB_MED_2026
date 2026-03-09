package com.ttil.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.AsyncContext;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AsyncOTPRunner  implements Runnable {
	AsyncContext asyncContext;
	String mobilenumber=null;
	int transactionid=0;
	int otp=0;
	String ipaddress,sessioId,browser,sms_text;
	public AsyncOTPRunner(AsyncContext asyncContext,String mobilenumber,String sms_text ,String ipaddress,String browser,String sessioId) {
		this.asyncContext = asyncContext;
		this.mobilenumber=mobilenumber;
		this.otp=otp;
		this.ipaddress=ipaddress;
		this.sessioId=sessioId;
		this.browser=browser;
		this.sms_text=sms_text;
	}

	@Override
	public void run() {
		Date date=new Date();
		SimpleDateFormat curFormater;
		String currDate="";
		try {
			
			  curFormater = new SimpleDateFormat("dd MMM HH:mm"); 
			currDate=curFormater.format(date);
			//String message=currDate+" Your one time password is "+otp+" . Please do not share this password with anyone";
			String message=sms_text;
			BOANSendSMS boanSMS=new BOANSendSMS();
			String output=boanSMS.SendSMS1(mobilenumber, message);
			String refId="",status="";
			if(output!=null){
				if(output.contains("1,")){
					refId=output.substring(output.indexOf(",")+1,output.length());
					status="1";
					////System.out.println("refId="+refId);
				}else{
					status=output;
				}
			}
			
		
		}catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			//LogsGeneration.generateErrorLogsWithMobileNumber("AsyncOTPRunner Catch", exceptionAsString, mobilenumber, ipaddress,browser);
		} finally {
			try{
				if(asyncContext!=null)
				asyncContext.complete();
			}catch(Exception e)
			{
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				//LogsGeneration.generateErrorLogsWithMobileNumber("AsyncOTPRunner finally", exceptionAsString, mobilenumber, ipaddress,browser);
			}
		}
	}

	public void readStatus(String outResponse,String service_type)
	{
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(outResponse);
			JSONObject jsonObject = (JSONObject) obj;
			// loop array
			JSONObject outboundSMSMessageRequest = (JSONObject) jsonObject.get("outboundSMSMessageRequest");
			if(outboundSMSMessageRequest!=null)
			{
				String resourceURL = (String) outboundSMSMessageRequest.get("resourceURL");
				if(resourceURL!=null)
				{
					String transactonId=resourceURL.substring(resourceURL.lastIndexOf("/")+1,resourceURL.length());
					//LogsGeneration.generateOTPGeneratedLog("OTP", mobilenumber,otp,ipaddress,browser,sessioId,service_type,transactonId,null);
				}else{
					//LogsGeneration.generateOTPGeneratedLog("OTP", mobilenumber,otp,ipaddress,browser,sessioId,service_type,"0",null);
				}
			}else {
				JSONObject requestError = (JSONObject) jsonObject.get("requestError");
				if(requestError!=null)
				{
					JSONObject policyException = (JSONObject) requestError.get("policyException");
					if(policyException!=null)
					{
						String text = (String) policyException.get("text");
						//LogsGeneration.generateOTPGeneratedLog("OTP", mobilenumber,otp,ipaddress,browser,sessioId,service_type,"0",text);
					}/*else*/
						//LogsGeneration.generateOTPGeneratedLog("OTP", mobilenumber,otp,ipaddress,browser,sessioId,service_type,"0",null);
				}else{
					//LogsGeneration.generateOTPGeneratedLog("OTP", mobilenumber,otp,ipaddress,browser,sessioId,service_type,"0",null);
				}
			}


		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			//LogsGeneration.generateErrorLogsWithMobileNumber("AsyncOTPRunner read IMI status", exceptionAsString, mobilenumber, ipaddress,browser);
		}
	}
}

