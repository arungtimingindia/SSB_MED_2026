package com.ttil.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.PreparedStatement;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class BOANSendSMS {

	String senderName, mobileNo, message;
	String outResponse = "";

	@SuppressWarnings("deprecation")
	//SendSMS method is used to send SMS to a mobile number specified by the sender with a message
	public String SendSMS(String mobileNo, String message,int transactionid) {
		String strUrl;
		String strOutput;
		String refId=null,status=null;
		try {
			String senderName;
			String outResponse = "";
			String url="http://boancomm.net/boansms/boansmsinterface.aspx";
			//message=message.replaceAll(" ", "%20");
			strUrl = "http://boancomm.net/boansms/boansmsinterface.aspx?mobileno=91"+mobileNo+"&smsmsg="+message+"&uname=rsgreensms&pwd=rsgreen14sms&pid=105";
			URL sendurl=new URL(url);
			
			HttpURLConnection httpconnection=(HttpURLConnection) sendurl.openConnection();
			httpconnection.setRequestMethod("POST");
			httpconnection.setReadTimeout(60000);
			httpconnection.setDoInput(true);
			httpconnection.setDoOutput(true);
			httpconnection.setUseCaches(false);
			DataOutputStream dataStreamToServer = new DataOutputStream(httpconnection.getOutputStream());
			dataStreamToServer.writeBytes("uname="
					+ URLEncoder.encode("rsgreensms", "UTF-8") + "&pwd="
					+ URLEncoder.encode("rsgreen14sms", "UTF-8") + "&pid="
					+ URLEncoder.encode("388", "UTF-8") + "&smsmsg="
					+ URLEncoder.encode(message, "UTF-8") + "&mobileno="
					+ URLEncoder.encode(mobileNo,"UTF-8"));           

			dataStreamToServer.flush();
			dataStreamToServer.close();

			BufferedReader dataStreamFromUrl = new BufferedReader(new InputStreamReader(httpconnection.getInputStream()));

			String dataBuffer = "";
			StringBuffer result = new StringBuffer();
			while ((dataBuffer = dataStreamFromUrl.readLine()) != null)
			{
				result.append(dataBuffer);
			}       
			strOutput=result.toString();
			dataStreamFromUrl.close();
			
			
			/*if(strOutput!=null){
				if(strOutput.contains("1,")){
					refId=strOutput.substring(strOutput.indexOf(",")+1,strOutput.length());
					status="1";
					////System.out.println("refId="+refId);
				}else{
					status=strOutput;
				}
			}	
			////System.out.println("transactionid="+transactionid+" output="+output);
			pstmt1.setInt(1, transactionid);
			pstmt1.setString(2, mobileNo);
			pstmt1.setString(3, strOutput);
			pstmt1.setString(4, status);
			pstmt1.setString(5, refId);
			pstmt1.execute();*/
		} catch (Exception e) {
			e.printStackTrace();
			strOutput = "unable to process request";
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
		}
		return strOutput;
	}
	/**
	 *
	 * @param senderName
	 * @param mobileNo
	 * @param message
	 * @return {@link String}
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	//SendSMS method is used to send SMS to a mobile number specified by the sender with a message
	public String SendSMS1(String mobileNo, String message) {
		this.mobileNo = mobileNo;
		this.message = message;
		String strUrl;
		String strOutput;
		try {
			message=message.replaceAll(" ", "%20");
			strUrl = "http://boancomm.net/boansms/boansmsinterface.aspx?mobileno=91"+mobileNo+"&smsmsg="+message+"&uname=rsgreensms&pwd=rsgreen14sms&pid=996";

			HttpClient client = new DefaultHttpClient();
			HttpPost request = new HttpPost(strUrl);
			HttpResponse response = client.execute(request);
			////System.out.println("\nSending 'GET' request to URL : " + url);
			////System.out.println("Response Code : " +  response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			////System.out.println(result.toString());
			strOutput=result.toString();

		} catch (Exception e) {
			e.printStackTrace();
			strOutput = "unable to process request";
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
		}
		return strOutput;
	}


	@SuppressWarnings("deprecation")
	//SendSMS method is used to send SMS to a mobile number specified by the sender with a message
	public String getSMSDeliveryStatus(String refId) {
		String strUrl;
		String strOutput;
		try {
			strUrl = "http://www.boancomm.net/BoanDLYstatus/DLYInterface.aspx?RefID="+refId;

			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(strUrl);
			HttpResponse response = client.execute(request);
			////System.out.println("\nSending 'GET' request to URL : " + url);
			////System.out.println("Response Code : " +  response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			////System.out.println(result.toString());
			strOutput=result.toString();

		} catch (Exception e) {
			e.printStackTrace();
			strOutput = "unable to process request";
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
		}
		return strOutput;
	}

	public static void main(String[] args)
	{
		BOANSendSMS sms1=new BOANSendSMS();
		String output=sms1.SendSMS1("8008889517", "You have paid INR 100.00 for Recruitment of ASI (STENOGRAPHER) EXAMINATION, 2018 with Reg Id: 10149581");
		//System.out.println("Publish Status="+output);
		if(output!=null){
			if(output.contains("1,")){
				String refId=output.substring(output.indexOf(",")+1,output.length());
				//System.out.println("refId="+refId);
				//String output1=sms1.getSMSDeliveryStatus(refId);
				////System.out.println("DeliverStatus="+output1);
			}else{
				//System.out.println("SMS Sent Failed=");
			}
		}
		/*String output1=sms1.getSMSDeliveryStatus("8717169");
		//System.out.println("DeliverStatus="+output1);*/
	}
}
