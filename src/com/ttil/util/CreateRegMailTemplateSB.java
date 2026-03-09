package com.ttil.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.AsyncContext;

import org.owasp.esapi.ESAPI;

import com.ttil.awsemail.AWSJavaMailSample;
import com.ttil.bean.ApplicationFormBean;

public class CreateRegMailTemplateSB implements Runnable {

	AsyncContext asyncContext;
	ApplicationFormBean applicationFormBean=null;
	String ipaddress,sessioId,browser;
	public CreateRegMailTemplateSB(AsyncContext asyncContext,ApplicationFormBean applicationFormBean,String ipaddress,String browser,String sessioId) {
		this.asyncContext = asyncContext;
		this.applicationFormBean=applicationFormBean;
		this.ipaddress=ipaddress;
		this.sessioId=sessioId;
		this.browser=browser;
	}

	@Override
	public void run() {
		Date date=new Date();
		SimpleDateFormat curFormater;
		String currDate="";
		try {
			curFormater = new SimpleDateFormat("dd MMM HH:mm"); 
			currDate=curFormater.format(date);

			if(applicationFormBean.getEmailaddress()!=null)
			{
				String emailaddress=ESAPI.encoder().canonicalize(applicationFormBean.getEmailaddress()).trim();
				long verifyStatus=1;
				if(verifyStatus>0 || verifyStatus==-1 || verifyStatus==-2)
				{

					String domicile_status="";
					if(applicationFormBean.isJk_domiciled()){ 
						domicile_status="Yes";
					}else{  domicile_status="No"; }


					StringBuilder template=new StringBuilder();
					/*template.append("<!DOCTYPE HTML><html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><title>::  ::</title><style>#wrapper { margin: 0px; padding: 0px; width: 100%; height: auto; float: left; background: #FFF; }#divpageOuter {margin: 0 auto 0 auto; padding: 20px 0px 10px 0px; width: 780px; height: auto; overflow: hidden; background-color: #FFF; }table.display {margin: 0px 0px 5px 0px; padding: 0px; float: left; width: 100%; border: 1px solid #D1D1D1; font: normal normal normal 80%/160% 'Lucida Grande', Verdana, Helvetica, Arial, sans-serif;}table.display tr {position: relative; border-bottom: 1px solid #CCC; }table.display tr td { padding: 0px 0px 3px 5px; margin: 0px 0px 0px 0px; border-right: 1px solid #CCC; border-bottom: 1px solid #CCC; vertical-align: middle; text-align: left; }table.display tr td.rightbodernoneclass { border-right:none; }</style> </head> <body><div id='wrapper'> <div id='divpageOuter'><table class='display'> <tbody><tr> <td colspan='2' style='font-size:15px;'>------------------PLEASE DO NOT REPLY TO THIS EMAIL------------------<br />This is an automated email sent by  BIHAR POLICE SUB-ORDINATE SERVICES COMMISSION in response to your application filled online at www.bpssc.bih.nic.in</b><br/><br/></td> </tr><tr> <td colspan='2' style='font-size:15px;'>Following are the details submitted by you in the Application Form filled for Post of BIHAR POLICE SUB INSPECTORS in Pay band - 1 (Rs 5,200 - 20,200) with grade pay of Rs.1,900/- in Railway Recruitment Board Employment Notification Number : RRB 07 / 2014 dated 01-07-2014.<br/><br/></td> </tr><tr> <td colspan='2' style='font-size:15px;'><b><u>The Application Form submitted by you is PROVISIONALLY REGISTERED.<br/><br/></u></b> </td> </tr><tr> <td colspan='2' style='font-size:15px;'>Please keep this email for reference. <br/><br/></td> </tr>");*/

					String email_content="";
					email_content=email_content+"<html> <style> h4{ text-align:center; color:blue; font-family: sans-serif; font-size:20px; } #text1 span{ text-align:center; color:red; font:bold; margin-left:10px; font-size:16px; } #text1 p{ text-align:center;} #text2 p{text-align:center; color:black;} table { width: 60%;border: 1px solid black;padding: 5px 20px; } table tr td{ padding: 5px 0; } .personalDetailsTable{width: 60%;border: 1px solid black;padding: 5px 20px; }.personalDetailsTable tr td:nth-child(2) {padding-right: 5%;}.personalDetailsTable tr td:nth-child(3) {padding-left: 5%;} .addressTable{ border-collapse:collapse;  table-layout:fixed; width:100%; border: 1px solid black; padding: 5px 20px; width: 60%; border-collapse: collapse; margin-top: 40px;} table.addressTable tr td { border: 1px solid black; text-align: center; width:100px; word-wrap:break-word   } .EducationTable{ width: 60%; border-collapse: collapse; margin-top: 40px; } table.EducationTable tr td { border: 1px solid black; text-align: center; } .criminalTable{ width: 60%; border-collapse: collapse; margin-top: 40px; } table.criminalTable tr td { border: 1px solid black; text-align: left; } </style>";
					email_content=email_content+"<body> <h4 style='text-align: center;color: blue;font-family: sans-serif;font-size: 20px;'>PLEASE DO NOT REPLY TO THIS EMAIL</h4> <div id='text1'> <p><span style='text-align: center; color: red; font: bold; margin-left: 10px; font-size: 16px;'>This is an automated email sent by SASHASTRA SEEMA BAL RECRUITMENT in response to your registration completed online at <a href='https://applyssb.com'>https://applyssb.com</a></span></p> <b><p>Following are the details submitted by you in the Registration Form filled for Post of "+ESAPI.encoder().canonicalize(applicationFormBean.getPost_selected_name())+" EXAMINATION, 2020</p></b> </div>";
					email_content=email_content+"<div id='text2'><p><b><u>The Registration Form filled by you is PROVISIONALLY SUBMITTED </u></b></p>  <b><p style='color:black'>Please Keep this Email as a Reference</p></b>	"
							+ "<p> Kindly check the  Application Status by clicking this link <a href='https://applyssb.com'>https://applyssb.com</a> and enter below details to Fill Application Form </p> "
							+ "<p>------------------------------------------------------------------------------------</p>"
							+ "<p>Registration ID "+applicationFormBean.getTransactionid()+"</p>"
							+ "<p>and</p>"
							+ "<p>Password : "+ESAPI.encoder().canonicalize(applicationFormBean.getPassword())+"</p>"
							+ "<p>------------------------------------------------------------------------------------</p>";
					email_content=email_content+"<table width='100%' align='center' class='personalDetailsTable' style='border: 1px solid black;'> <thead> <th colspan='2' align='center'>Applicant Details</th> </thead>";
					email_content=email_content+="<tr> <td ><b>Post Applied For:</b></td><td>"+ESAPI.encoder().canonicalize(applicationFormBean.getPost_selected_name())+"</td> </tr>";
					email_content=email_content+"<tr> <td width='30%'><b>Registration No:</b></td><td>"+applicationFormBean.getTransactionid()+"</td> </tr> <tr> <td ><b>Date & Time:</b></td><td>"+applicationFormBean.getDate_created()+"</td> </tr>";
					email_content=email_content+"<tr> <td ><b>Applicant Name:</b></td><td>"+ESAPI.encoder().canonicalize(applicationFormBean.getFirst_name())+" "+ESAPI.encoder().canonicalize(applicationFormBean.getMiddle_name())+" "+ESAPI.encoder().canonicalize(applicationFormBean.getLast_name())+"</td> </tr>";
					email_content=email_content+="<tr> <td ><b>Mobile Number:</b></td><td>"+ESAPI.encoder().canonicalize(applicationFormBean.getMobileNumber())+"</td> </tr>";
					email_content=email_content+="<tr>  <td ><b>Email Address :</b></td><td>"+ESAPI.encoder().canonicalize(applicationFormBean.getEmailaddress())+"</td> </tr>";
					email_content=email_content+="<tr> <td ><b>Community:</b></td><td>"+ESAPI.encoder().canonicalize(applicationFormBean.getCommunity())+"</td> </tr>";
					email_content=email_content+="<tr> <td ><b>Gender:</b></td><td>"+applicationFormBean.getSex()+"</td> </tr>";
					email_content=email_content+="<tr> <td ><b>Date of Birth:</b></td><td>"+ESAPI.encoder().canonicalize(applicationFormBean.getDob())+"</td> </tr> </table> </div> </body> </html>";
					template.append(email_content);

					AWSJavaMailSample awsJavaMailSample=new AWSJavaMailSample(emailaddress,"APPLICATION CONFIRMATION for SSB RECRUITMENT FOR 338/RC/SSB/Combined Advt./2020",template.toString(),applicationFormBean.getMobileNumber());
					awsJavaMailSample.sendEmailViaAWS();
					/*if(verifyStatus==-1)
					{
						LogsGeneration.generateErrorLogsWithMobileNumber("EmailVerifier Error", emailaddress, applicationFormBean.getMobileNumber(), ipaddress,browser);
					}else if(verifyStatus==-2)
					{
						LogsGeneration.generateErrorLogsWithMobileNumber("EmailVerifier Limit Error", emailaddress, applicationFormBean.getMobileNumber(), ipaddress,browser);
					}*/
				}else{
					//LogsGeneration.generateErrorLogsWithMobileNumber("Invalid EmailAddress", emailaddress, applicationFormBean.getMobileNumber(), ipaddress,browser);
				}
			}

		}catch(Exception e)
		{
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			//LogsGeneration.generateErrorLogsWithMobileNumber("CreateMailTemplate", exceptionAsString, applicationFormBean.getMobileNumber(), ipaddress,browser);

		}finally {
			try{
				if(asyncContext!=null)
					asyncContext.complete();
			}catch(Exception e)
			{
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				//LogsGeneration.generateErrorLogsWithMobileNumber("AsyncOTPRunner finally", exceptionAsString, null, ipaddress,browser);
			}
		}
	}

	/*
	@Override
	public void run() {
		Date date=new Date();
		SimpleDateFormat curFormater;
		String currDate="";
		try {
			curFormater = new SimpleDateFormat("dd MMM HH:mm"); 
			currDate=curFormater.format(date);
			String message=currDate+" Your provisional application has been successfully submitted with Transaction ID "+applicationFormBean.getTransactionid()+" - ";
			try {
				IMISendSMS imiSendSMS=new IMISendSMS();
				String smsStatus=imiSendSMS.SendSMS(applicationFormBean.getMobileNumber(), message, ipaddress,browser);
			}catch(Exception e)
			{
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				LogsGeneration.generateErrorLogsWithMobileNumber("IMISuceessMessage", exceptionAsString, applicationFormBean.getMobileNumber(), ipaddress,browser);
			}
			if(applicationFormBean.getEmailaddress()!=null)
			{
				String emailaddress=ESAPI.encoder().canonicalize(applicationFormBean.getEmailaddress()).trim();
				long verifyStatus=1;
				try{
					EmailVerifier emailVerifier = new EmailVerifier();
					verifyStatus=emailVerifier.verifyEmail(emailaddress,applicationFormBean.getMobileNumber(),ipaddress,browser);
				}catch(Exception e)
				{}
				if(verifyStatus>0 || verifyStatus==-1 || verifyStatus==-2)
				{

					String exam_passed_1=applicationFormBean.getExam_passed_1();
					String university_1=applicationFormBean.getUniversity_1();
					String edu_certno_1=applicationFormBean.getEdu_certno_1();
					String edu_date_issue_1=applicationFormBean.getEdu_date_issue_1();

					String exam_passed_2=applicationFormBean.getExam_passed_2();
					String university_2=applicationFormBean.getUniversity_2();
					String edu_certno_2=applicationFormBean.getEdu_certno_2();
					String edu_date_issue_2=applicationFormBean.getEdu_date_issue_2();

					String exam_passed_3=applicationFormBean.getExam_passed_3();
					String university_3=applicationFormBean.getUniversity_3();
					String edu_certno_3=applicationFormBean.getEdu_certno_3();
					String edu_date_issue_3=applicationFormBean.getEdu_date_issue_3();


					boolean edu_qual_1=true,edu_qual_2=true,edu_qual_3=true,edu_qual_4=true,edu_qual_5=true,edu_qual_6=true,edu_qual_7=true,edu_qual_8=true;
					if("".equalsIgnoreCase(exam_passed_1) || "".equalsIgnoreCase(university_1) || "".equalsIgnoreCase(edu_certno_1) || "".equalsIgnoreCase(edu_date_issue_1) ){
						edu_qual_1=false;
					}
					if("".equalsIgnoreCase(exam_passed_2)  || "".equalsIgnoreCase(university_2) || "".equalsIgnoreCase(edu_certno_2) || "".equalsIgnoreCase(edu_date_issue_2) ){
						edu_qual_2=false;
					}
					if(exam_passed_3==null  || "".equalsIgnoreCase(exam_passed_3)  || university_3==null  ||  "".equalsIgnoreCase(university_3) || edu_certno_3==null  ||  "".equalsIgnoreCase(edu_certno_3) || edu_date_issue_3==null  || "".equalsIgnoreCase(edu_date_issue_3) ){
						edu_qual_3=false;
					}
					boolean fir_cases=false;
					String fir_cases_value="",fir_cases_pending="",arrested="",criminal_case_acquitted="",good_behavior_bond="";
					if(applicationFormBean.isFir_cases()){
						fir_cases=true;
						fir_cases_value="Yes";
					}else{
						fir_cases_value="No";
					}
					if(applicationFormBean.isFir_cases_pending()){
						fir_cases=true;
						fir_cases_pending="Yes";
					}else{
						fir_cases_pending="No";
					}
					if(applicationFormBean.isArrested()){
						fir_cases=true;
						arrested="Yes";
					}else{
						arrested="No";
					}
					if(applicationFormBean.isCriminal_case_acquitted()){
						fir_cases=true;
						criminal_case_acquitted="Yes";
					}else{
						criminal_case_acquitted="No";
					}
					if(applicationFormBean.isGood_behavior_bond()){
						fir_cases=true;
						good_behavior_bond="Yes";
					}else{
						good_behavior_bond="No";
					}


					String domicile_status="",debarment="",debar_reason="";
					if(applicationFormBean.isJk_domiciled()){ 
						domicile_status="Yes";
					}else{  domicile_status="No"; }

					if(applicationFormBean.isDebarment()){ 
						debarment="Yes";
					}else{  debarment="No"; }
					if("Others".equalsIgnoreCase(applicationFormBean.getDebar_reason())){ 
						debar_reason=applicationFormBean.getOther_reason();
					}else{
						debar_reason=applicationFormBean.getDebar_reason();
					}
					StringBuilder template=new StringBuilder();
					template.append("<!DOCTYPE HTML><html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><title>::  ::</title><style>#wrapper { margin: 0px; padding: 0px; width: 100%; height: auto; float: left; background: #FFF; }#divpageOuter {margin: 0 auto 0 auto; padding: 20px 0px 10px 0px; width: 780px; height: auto; overflow: hidden; background-color: #FFF; }table.display {margin: 0px 0px 5px 0px; padding: 0px; float: left; width: 100%; border: 1px solid #D1D1D1; font: normal normal normal 80%/160% 'Lucida Grande', Verdana, Helvetica, Arial, sans-serif;}table.display tr {position: relative; border-bottom: 1px solid #CCC; }table.display tr td { padding: 0px 0px 3px 5px; margin: 0px 0px 0px 0px; border-right: 1px solid #CCC; border-bottom: 1px solid #CCC; vertical-align: middle; text-align: left; }table.display tr td.rightbodernoneclass { border-right:none; }</style> </head> <body><div id='wrapper'> <div id='divpageOuter'><table class='display'> <tbody><tr> <td colspan='2' style='font-size:15px;'>------------------PLEASE DO NOT REPLY TO THIS EMAIL------------------<br />This is an automated email sent by  BIHAR POLICE SUB-ORDINATE SERVICES COMMISSION in response to your application filled online at www.bpssc.bih.nic.in</b><br/><br/></td> </tr><tr> <td colspan='2' style='font-size:15px;'>Following are the details submitted by you in the Application Form filled for Post of BIHAR POLICE SUB INSPECTORS in Pay band - 1 (Rs 5,200 - 20,200) with grade pay of Rs.1,900/- in Railway Recruitment Board Employment Notification Number : RRB 07 / 2014 dated 01-07-2014.<br/><br/></td> </tr><tr> <td colspan='2' style='font-size:15px;'><b><u>The Application Form submitted by you is PROVISIONALLY REGISTERED.<br/><br/></u></b> </td> </tr><tr> <td colspan='2' style='font-size:15px;'>Please keep this email for reference. <br/><br/></td> </tr>");

					String email_content="";
					email_content="<!DOCTYPE HTML><html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><title>::  ::</title><style>#wrapper { margin: 0px; padding: 0px; width: 100%; height: auto; float: left; background: #FFF; }#divpageOuter {margin: 0 auto 0 auto; padding: 20px 0px 10px 0px; width: 780px; height: auto; overflow: hidden; background-color: #FFF; }table.display {margin: 0px 0px 5px 0px; padding: 0px; float: left; width: 100%; border: 1px solid #D1D1D1; font: normal normal normal 80%/160% 'Lucida Grande', Verdana, Helvetica, Arial, sans-serif;}table.display tr {position: relative; border-bottom: 1px solid #CCC; }table.display tr td { padding: 0px 0px 3px 5px; margin: 0px 0px 0px 0px; border-right: 1px solid #CCC; border-bottom: 1px solid #CCC; vertical-align: middle; text-align: left; }table.display tr td.rightbodernoneclass { border-right:none; }</style> </head> <body><div id='wrapper'> <div id='divpageOuter'><table class='display' style='font-size: 13px;'> <tbody><tr> <td colspan='2' style='font-size:15px;'>------------------PLEASE DO NOT REPLY TO THIS EMAIL------------------<br />This is an automated email sent by  BIHAR POLICE SUB-ORDINATE SERVICES COMMISSION in response to your application filled online at www.bpssc.bih.nic.in</b><br/><br/></td> </tr><tr> <td colspan='2' style='font-size:15px;'>Following are the details submitted by you in the Application Form filled for Post of BIHAR POLICE SUB INSPECTORS <br/><br/></td> </tr><tr> <td colspan='2' style='font-size:15px;'><b><u>The Application Form filled by you is PROVISIONALLY SUBMITTED.<br/><br/></u></b> </td> </tr><tr> <td colspan='2' style='font-size:15px;'>Please keep this email for reference. <br/><br/></td> </tr>";
					email_content=email_content+"<tr> <td width='90%'><table width='95%' border='0' align='center' cellpadding='5' cellspacing='0'>"; 
					email_content=email_content+"<tr> <td width='53.8%'><label class='label1'>Registration Id : </label> <label>"+applicationFormBean.getTransactionid()+"</label></td> <td><label class='label1'>Date &amp; Time  : </label>  <label>"+applicationFormBean.getDate_created()+"</label></td> </tr>";
					email_content=email_content+"<tr> <td><label class='label1'>Applicant Name : </label> <label>"+applicationFormBean.getFirst_name()+" "+applicationFormBean.getMiddle_name()+" "+applicationFormBean.getLast_name()+"</label></td><td><label class='label1'>Father's Name : </label><label>"+applicationFormBean.getFather_name()+"</label></td></tr>";
					email_content=email_content+"<tr><td><label class='label1'>Mother's Name : </label><label>"+applicationFormBean.getMother_name()+"</label></td><td>";
					if("Married".equalsIgnoreCase(applicationFormBean.getMarrital_status()) && "Female".equalsIgnoreCase(applicationFormBean.getSex()) ){
						email_content=email_content+"<label class='label1'>Husband's Name : </label><label> "+applicationFormBean.getHusband_name()+" </label>"; 
					}
					email_content=email_content+"</td></tr>  <tr><td><label class='label1'>Nationality : </label> <label>"+applicationFormBean.getNationality()+"</label></td><td><label class='label1'>Marital Status : </label><label>"+applicationFormBean.getMarrital_status()+"</label></td></tr>";   
					email_content=email_content+"<tr><td><label class='label1'>Mobile Number : </label><label>"+applicationFormBean.getMobileNumber()+"</label></td><td><label class='label1'>Email Address : </label><label>"+applicationFormBean.getEmailaddress()+"</label></td></tr>  ";
					email_content=email_content+"<tr><td><label class='label1'>Are you a domicile of Bihar State : </label><label>"+domicile_status+" </label></td> <td><label class='label1'>Category : </label><label>"+applicationFormBean.getCommunity()+"</label></td></tr>";
					email_content=email_content+"<tr><td><label class='label1'>Date of Birth : </label> <label>"+applicationFormBean.getDob()+"</label></td><td> <label class='label1'>Gender : </label><label>"+applicationFormBean.getSex()+"</label></td></tr> ";
					email_content=email_content+"<tr><td><label class='label1'>Identity Card No : </label><label>"+applicationFormBean.getAadharNo()+" ( "+applicationFormBean.getIdentity_type()+")</label></td><td><label class='label1'>Identification Marks : </label><label>"+applicationFormBean.getIdentification_mark()+"</label></td></tr> </table> </td>  </tr>";
					email_content=email_content+"<tr><td class='bdr' colspan='2'><h4>Education Qualification Details</h4></td></tr>";
					email_content=email_content+"<tr><td colspan='2'><table width='96%' border='0' align='center' cellpadding='5' cellspacing='0' style='margin-top: 10px; margin-bottom: 10px;'> <tr><td colspan='2'><table width='100%' border='0' cellspacing='0' cellpadding='5'><tr><td width='10%' class='border1'><label class='label1'>Exam Passed</label></td><td width='20%' class='border1'><label class='label1'>School/ University/ Board/ Institute</label></td><td width='10%' class='border1'><label class='label1'>Passing Certificate No</label></td><td width='10%' class='border1'><label class='label1'>Certificate Issued Date</label></td></tr>";               
					if(edu_qual_1){
						email_content=email_content+"<tr><td class='border1'><label class='label2'>"+exam_passed_1+"</label></td><td class='border1'><label class='label2'>"+university_1 +"</label></td><td class='border1'><label class='label2'>"+edu_certno_1 +"</label></td><td class='border1'><label class='label2'>"+edu_date_issue_1 +"</label></td></tr> ";
					}
					if(edu_qual_2){
						email_content=email_content+"<tr><td class='border1'><label class='label2'>"+exam_passed_2+"</label></td><td class='border1'><label class='label2'>"+university_2 +"</label></td><td class='border1'><label class='label2'>"+edu_certno_2 +"</label></td><td class='border1'><label class='label2'>"+edu_date_issue_2 +"</label></td></tr>";
					}
					if(edu_qual_3){  
						email_content=email_content+"<tr><td class='border1'><label class='label2'>"+exam_passed_3 +"</label></td><td class='border1'><label class='label2'>"+university_3 +"</label></td><td class='border1'><label class='label2'>"+edu_certno_3 +"</label></td><td class='border1'><label class='label2'>"+edu_date_issue_3 +"</label></td></tr> ";
					}
					email_content=email_content+"</table></td></tr></table></td></tr><tr><td class='bdr'  colspan='2'><h4>Address Details</h4></td></tr>";
					email_content=email_content+"<tr><td colspan='2'><table width='96%' border='1' align='center' cellpadding='5' cellspacing='0' style='margin-top: 10px; margin-bottom: 10px;'><tr><td colspan='2'><h6 style='text-align:center;'>Permanent Address </h6></td><td colspan='2'><h6 style='text-align:center;'>Correspondence Address </h6></td></tr><tr><td width='10%'><label class='label1'>House No </label></td><td width='36%'><label>"+applicationFormBean.getHno()+"</label></td><td width='10%'><label class='label1'>House No </label></td><td width='36%'><label>"+applicationFormBean.getHno1()+"</label></td></tr><tr><td width='10%'><label class='label1'>Street/mohalla </label></td><td width='36%'><label>"+applicationFormBean.getStreet()+"</label></td><td width='10%'><label class='label1'>Street/mohalla </label></td><td width='36%'><label>"+applicationFormBean.getStreet1()+"</label></td></tr><tr><td width='13%'><label class='label1'>Village/Town </label></td><td width='32%'><label>"+applicationFormBean.getVillage()+"</label></td><td width='13%'><label class='label1'>Village/Town </label></td><td width='32%'><label>"+applicationFormBean.getVillage1()+"</label></td></tr><tr><td ><label class='label1'>Post Office </label></td><td><label>"+applicationFormBean.getPostoffice()+"</label></td><td><label class='label1'>Post Office </label></td><td><label>"+applicationFormBean.getPostoffice1()+"</label></td></tr><tr><td><label class='label1'>District </label></td><td><label>"+applicationFormBean.getDistrict()+"</label></td><td><label class='label1'>District </label></td><td><label>"+applicationFormBean.getDistrict1()+"</label></td></tr><tr><td><label class='label1'>State </label></td><td><label>"+applicationFormBean.getState()+"</label></td><td><label class='label1'>State </label></td><td><label>"+applicationFormBean.getState1()+"</label></td></tr><tr><td><label class='label1'>Pin code </label></td><td><label>"+applicationFormBean.getPincode()+"</label></td><td><label class='label1'>Pin code </label></td><td><label>"+applicationFormBean.getPincode1()+"</label></td></tr></table></td></tr>";
					email_content=email_content+"<tr><td class='bdr' colspan='2'><h4>Declaration of Criminal Cases</h4></td></tr>";
					email_content=email_content+"<tr><td colspan='2'><table width='95%' border='0' align='center' cellpadding='5' cellspacing='0'>    <tr><td colspan='2'><table width='100%' border='0' align='center' cellpadding='5' cellspacing='0'>"
							+ "<tr><td width='82%' colspan='2'><label class='label1'>Have you ever been debarred by UPSC, SSC or SPSC or any recruitment board from appearing in any exam?</label></td><td><label>"+debarment+"</label></td></tr></table></td></tr>   ";
					if(applicationFormBean.isDebarment()){ 
						email_content=email_content+" <tr><td colspan='2'><table width='100%' border='0' align='center' cellpadding='5' cellspacing='0' class='border1'>"
								+ "<tr><td width='50%'><label class='label1'>Exam Organizer : </label> <label>"+applicationFormBean.getExamorganizer()+"</label></td><td width='50%'><label class='label1'>Exam Name : </label> <label>"+applicationFormBean.getExamname()+"</label></td></tr>"
								+ "<tr><td width='50%'><label class='label1'>Exam Date : </label> <label>"+applicationFormBean.getExamdate()+"</label></td><td width='50%'><label class='label1'>Debarment End Date : </label> <label>"+applicationFormBean.getDebarenddate()+"</label></td></tr>"
								+ "<tr><td colspan='2'><label class='label1'>Reason : </label><label>"+debar_reason+" </label></td></tr></table></td></tr>";
					}
					email_content=email_content+" <tr><td colspan='2'><table width='100%' border='0' align='center' cellpadding='5' cellspacing='0'><tr><td colspan='2'><label class='label1'>Criminal Proceeding details, if any </label></td></tr>"
							+ "<tr><td  width='2%' align='left' valign='middle'><label style='font-weight:bold;'> a) </label></td><td width='80%'><label class='label1'>Whether any FIR or criminal case(s) has ever been registered against you?</label></td><td><label>"+fir_cases_value+"</label></td></tr>"
							+ "<tr><td align='left' valign='middle'><label style='font-weight:bold;'> b) </label></td><td><label class='label1' style='line-height:13px;'>Whether any criminal complaint case or FIR or criminal case(s) is pendingagainst you in Court of Law, <br/> or with police at the time of submitting theapplication form?</label></td><td><label>"+fir_cases_pending+"</label></td></tr>"
							+ "<tr><td align='left' valign='middle'><label style='font-weight:bold;'> c) </label></td><td><label class='label1'>Have you ever been arrested/detained in any criminal case(s)?</label></td><td><label>"+arrested+"</label></td></tr>"
							+ "<tr><td align='left' valign='middle'><label style='font-weight:bold;'> d) </label></td><td><label class='label1'>Have you ever been tried &amp; convicted or acquitted by a Court of Law in any criminal case(s)?</label></td><td><label>"+criminal_case_acquitted+"</label></td></tr>"
							+ "<tr><td align='left' valign='middle'><label style='font-weight:bold;'> e) </label></td><td><label class='label1'>Have you ever been tried &amp; convicted by the Court by filling any bond for good behaviour etc.?</label></td><td><label>"+good_behavior_bond+"</label></td></tr></table></td></tr>";
					if(fir_cases){
						email_content=email_content+"  <tr><td colspan='2'><table width='100%' border='0' align='center' cellpadding='5' cellspacing='0' class='border1'><tr><td width='50%'><label class='label1'>FIR No. : </label> <label>"+applicationFormBean.getFirno()+"</label></td><td width='50%'><label class='label1'>Date : </label> <label>"+applicationFormBean.getFirdate()+"</label></td></tr><tr><td><label class='label1'>Under Section : </label> <label>"+applicationFormBean.getFirsection()+"</label></td><td><label class='label1'>District : </label> <label>"+applicationFormBean.getFirdistrict()+"</label></td></tr><tr><td colspan='2'><label class='label1'>Present status of the case at the time of filling up this application form : </label><label>"+applicationFormBean.getFirstatus()+"</label></td></tr></table></td></tr><%} %></table></td></tr>";
					}
					email_content=email_content+"</table>";
					template.append(email_content);
						if(!applicationFormBean.isPayExempted())
					{template.append("<tr> <td colspan='2' style='font-size:15px;'><b>You are advised to ensure the payment of fees before the due date mentioned in CHALLAN</b> <br/><br/></td> </tr>");}
					template.append("<tr> <td colspan='2' style='font-size:18px;' class='center'><b>Transaction Id : "+applicationFormBean.getTransactionid()+"</b></td> </tr><tr> <td width='35%'><b>Category</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getCategory()+"</td></tr> <tr> <td width='35%'><b>Railway Branch</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getRly_branch()+"</td></tr> <tr> <td width='35%'><b>Aadhar Card Number</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getAadharno()+"</td></tr> <tr> <td width='35%'><b>Full Name</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getFirst_name()+"</td> </tr><tr> <td width='35%'><b>Father's / Husband's Name</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getFather_name()+"</td></tr>");
					template.append("<tr> <td width='35%'><b>Religion</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getReligion()+"</td> </tr><tr> <td width='35%'><b>Sex</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getSex()+"</td> </tr><tr> <td width='35%'><b>Community</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getCommunity()+"</td> </tr>");if(applicationFormBean.getCommunity()!=null&&!("UR").equalsIgnoreCase(applicationFormBean.getCommunity()))
					{template.append("<tr><td colspan='2'><table><tr><td style='border: none;' colspan='4'><b>Community Certificate</b></td></tr><tr><td style='border: none;'><b>Certificate No :</b></td><td style='border: none;'>"+applicationFormBean.getCommunity_certficate_no()+"</td><td style='border: none;'><b>Date of Issue :</b></td><td style='border: none;'>"+applicationFormBean.getCommunity_date_issue_name()+"</td></tr><tr><td style='border: none;'><b>Place of Issue :</b></td><td style='border: none;'>"+applicationFormBean.getCommunity_place_issue()+"</td><td style='border: none;'><b>Name of issuing authority :</b></td><td style='border: none;'>"+applicationFormBean.getCommunity_assured_by()+"</td></tr></table></td></tr>");}
					template.append("<tr> <td width='35%'><b>Date of Birth</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getDob_name()+"</td> </tr><tr> <td width='35%'><b>Mobile number</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getMobileNumber()+"</td></tr><tr> <td width='35%'><b>Email address</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getEmailaddress()+"</td> </tr><tr> <td width='35%'><b>Nearest railway Station</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getNear_railway_station()+"</td> </tr><tr> <td width='35%'><b>Address for Communication</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getAddress()+"</td> </tr><tr> <td width='35%'><b>District</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getDistrict()+"</td> </tr><tr> <td width='35%'><b>State</b></td> <td class='rightbodernoneclass'>: "+applicationFormBean.getState()+"</td> </tr><tr> <td width='35%'><b>Pincode</b></td>"+"<td class='rightbodernoneclass'>: "+applicationFormBean.getPincode()+"</td> </tr><tr> <td width='35%'><b>Educational Qualifications</b> </td> <td class='rightbodernoneclass'>: "+applicationFormBean.getEducation_qualification_names()+"</td> </tr>");
					template.append("<tr> <td width='35%'><b>Are you Ex-Serviceman</b> </td> <td class='rightbodernoneclass'>: "+getStatus(applicationFormBean.isEx_serviceman())+"</td></tr>");if(applicationFormBean.isEx_serviceman()){template.append("<tr><td colspan='2'><table><tr><td style='border: none;' colspan='4'><b>Ex-Serviceman Certificate</b></td></tr><tr><td style='border: none;'><b>Certificate No :</b></td><td style='border: none;'>"+applicationFormBean.getExman_certficate_no()+"</td><td style='border: none;'><b>Date of Enrollment in Defense :</b></td><td style='border: none;'>"+applicationFormBean.getExman_enrollment_date_name()+"</td></tr><tr><td style='border: none;'><b>Total Duration of Service (in years) :</b></td><td style='border: none;'>"+applicationFormBean.getExman_service()+"</td><td style='border: none;'><b>Date of Retirement :</b></td><td style='border: none;'>"+applicationFormBean.getExman_retirement_date_name()+"</td></tr></table></td></tr>");}
					template.append("<tr><td width='35%'><b>Are you Person with Disabilities</b> </td><td class='rightbodernoneclass'>: "+getStatus(applicationFormBean.isPwd())+"</td></tr>");if(applicationFormBean.isPwd()){template.append("<tr><td colspan='2'><b>Disability Details</b></td></tr><tr<td style='border: none;' colspan='2'><b>Person with Disabilities: </b>"+applicationFormBean.getPwd_category_details()+"</td></tr><tr><td style='border: none;' colspan='2'><table><tr><td style='border: none;'><b>Certificate No :</b></td><td style='border: none;'>"+applicationFormBean.getPwd_certficate_no()+"</td><td style='border: none;'><b>Date of Issue :</b></td><td style='border: none;'>"+applicationFormBean.getPwd_date_issue_name()+"</td></tr><tr><td style='border: none;'><b>Place of Issue :</b></td><td style='border: none;'>"+applicationFormBean.getPwd_place_issue()+"</td><td style='border: none;'><b>Name of issuing authority :</b></td><td style='border: none;'>"+applicationFormBean.getPwd_assured_by()+"</td></tr></table></td></tr>");}
					template.append("<tr><td width='35%'><b>Are you Widow/Divorced/Judicially separated Women</b> </td><td class='rightbodernoneclass'>: "+getStatus(applicationFormBean.isWidow_women())+"</td></tr><tr><td width='35%'><b>Are you Economically Weaker Section</b> </td>"+"<td class='rightbodernoneclass'>: "+getStatus(applicationFormBean.isEconomic_weaker())+"</td></tr><tr><td width='35%'><b>Are you belonging to Minority Religion</b> </td>"+"<td class='rightbodernoneclass'>: "+getStatus(applicationFormBean.isMinority())+"</td></tr><tr><td width='35%'><b>Are you Railway/Govt/PSU Employee</b> </td><td class='rightbodernoneclass'>: "+getStatus(applicationFormBean.isGovt_employee_service())+"</td></tr><tr><td width='35%' ><b>Personal marks of Identification</b></td><td>: "+applicationFormBean.getIdentification_mark_1()+" <br/>: "+applicationFormBean.getIdentification_mark_2()+"</td></tr><tr><td colspan='2' style='border: none;'><b>If you want to Re-print Acknowledgement / Challan, then <a href='http://www.iroams.com/V1/searchApplication'>Click here</a></b> <br/> <br/>------------------PLEASE DO NOT REPLY TO THIS EMAIL------------------</td></tr></tbody></table></div></div></div></body></html>");

						AWSJavaMailSample awsJavaMailSample=new AWSJavaMailSample(emailaddress," BIHAR POLICE SUB INSPECTORS Acknowledgement",template.toString(),applicationFormBean.getMobileNumber());
						awsJavaMailSample.sendEmailViaAWS();
						if(verifyStatus==-1)
					{
						LogsGeneration.generateErrorLogsWithMobileNumber("EmailVerifier Error", emailaddress, applicationFormBean.getMobileNumber(), ipaddress,browser);
					}else if(verifyStatus==-2)
					{
						LogsGeneration.generateErrorLogsWithMobileNumber("EmailVerifier Limit Error", emailaddress, applicationFormBean.getMobileNumber(), ipaddress,browser);
					}
					}else{
						//LogsGeneration.generateErrorLogsWithMobileNumber("Invalid EmailAddress", emailaddress, applicationFormBean.getMobileNumber(), ipaddress,browser);
					}
				}

			}catch(Exception e)
			{
				e.printStackTrace();
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				//LogsGeneration.generateErrorLogsWithMobileNumber("CreateMailTemplate", exceptionAsString, applicationFormBean.getMobileNumber(), ipaddress,browser);

			}finally {
				try{
					if(asyncContext!=null)
						asyncContext.complete();
				}catch(Exception e)
				{
					StringWriter sw = new StringWriter();
					e.printStackTrace(new PrintWriter(sw));
					String exceptionAsString = sw.toString();
					//LogsGeneration.generateErrorLogsWithMobileNumber("AsyncOTPRunner finally", exceptionAsString, null, ipaddress,browser);
				}
			}
		}*/
	public static String getStatus(boolean flag)
	{
		if(flag){
			return "Yes";
		}else{ 
			return "No";
		}   
	}
}
