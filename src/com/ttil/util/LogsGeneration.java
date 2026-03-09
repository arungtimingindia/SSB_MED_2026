package com.ttil.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.owasp.esapi.ESAPI;

import com.ttil.bean.ApplicationFormBean;



public class LogsGeneration {
	
	/*
	public static void generateAccessLog(String accessingPage,String mobileNumber,int registrationId,String ipaddress,String browser,String sessionId)
	{
		RabbitMQProducer tp=new RabbitMQProducer();
		tp.send("AccessLogsRegId#"+accessingPage+"#"+mobileNumber+"#"+registrationId+"#"+ipaddress+"#"+getCurrentDate()+"#"+sessionId+"#"+browser);
	}
	public static void generateAccessLogWithMobileNumber(String accessingPage,String mobileNumber,String ipaddress,String browser,String sessionId)
	{
		RabbitMQProducer tp=new RabbitMQProducer();
		////System.out.println("AccessLogs#"+accessingPage+"#"+mobileNumber+"#"+ipaddress+"#"+getCurrentDate()+"#"+sessionId+"#"+browser);
		tp.send("AccessLogs#"+accessingPage+"#"+mobileNumber+"#"+ipaddress+"#"+getCurrentDate()+"#"+sessionId+"#"+browser);
	}
	
	public static void generateErrorLogs(String pageName,String Error,String mobileNumber,int registrationId,String ipaddress,String browser)
	{
		RabbitMQProducer tp=new RabbitMQProducer();
		tp.send("ErrorLogsRegId#"+pageName+"#"+Error+"#"+mobileNumber+"#"+registrationId+"#"+ipaddress+"#"+getCurrentDate()+"#"+browser);
	}
	public static void generateErrorLogsWithMobileNumber(String pageName,String Error,String mobileNumber,String ipaddress,String browser)
	{
		RabbitMQProducer tp=new RabbitMQProducer();
		tp.send("ErrorLogs#"+pageName+"#"+Error+"#"+mobileNumber+"#"+ipaddress+"#"+getCurrentDate()+"#"+browser);
	}
	
	public static void generateFormSuccessLog(String TransactionId,String registrationId,String ipaddress,String sessionId,String browser)
	{
		RabbitMQProducer tp=new RabbitMQProducer();
		tp.send("ApplicationSuccessLog#"+"#"+TransactionId+"#"+registrationId+"#"+ipaddress+"#"+getCurrentDate()+"#"+sessionId+"#"+browser);
	}
	
	public static void generateRegFormData(ApplicationFormBean appFormBean,String ipaddress,String browser,String sessionId)
	{
		try{
		StringBuffer sb=new StringBuffer();
		sb.append(appFormBean.getFirst_name()+"#%");
		sb.append(appFormBean.getMiddle_name()+"#%");
		sb.append(appFormBean.getLast_name()+"#%");
		sb.append(appFormBean.getNationality()+"#%");
		sb.append(appFormBean.getMobileNumber()+"#%");
		sb.append(ESAPI.encoder().canonicalize(appFormBean.getEmailaddress())+"#%");
		sb.append(appFormBean.isJk_domiciled()+"#%");
		sb.append(appFormBean.getCommunity()+"#%");
		sb.append(appFormBean.getSex()+"#%");
		sb.append(appFormBean.getDob()+"#%"); // date
		sb.append(getCurrentDate()+"#%"); // date_created
		sb.append(ipaddress+"#%"); // ipAddress
		sb.append(sessionId+"#%");
		sb.append(browser+"#%");
		
		RabbitMQProducer tp=new RabbitMQProducer();
		tp.send("RegFormData#"+sb);
		}catch(Exception e)
		{
			e.printStackTrace();
			// do log
		}
	}
	
	*/
	public static  String  getCurrentDate()
	{
		Date date=new Date();
		SimpleDateFormat curFormater;
		String currDate="";
		try
		{
			curFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			currDate=curFormater.format(date);
		}
		catch(Exception e)
		{
			//e.printStackTrace();	
		}
		return currDate;
	}
}
