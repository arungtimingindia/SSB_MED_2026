<%@ page import="com.ttil.bean.ApplicationFormBean"%>
<%@ page import="java.util.List"%>
<%@ page import="org.owasp.html.Sanitizers"%>
<%@ page import="org.owasp.html.PolicyFactory"%>
<%@ page import="com.ttil.bean.PostsBean" %>
<%@ page import="org.owasp.esapi.ESAPI" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="shortcut icon" href="images/favicon.jpg" />
 <script type="text/javascript" src="js/jquery.min.js"></script>
<title>welcome to ssb online application</title>
<style type="text/css">

</style>

<script>
	function challanReport1() {
		alert("You may please pay Challan amount on or before 09-SEPTEMBER-2018."+"\n"+" Any payment after will not be applicable.");
		document.applicationView.action="printChallan?challan_type=PostOffice";
        document.applicationView.submit();
	}
/* 	function challanReport2() {
		document.applicationView.action="printChallan?challan_type=IndianBank";
        document.applicationView.submit();
} */
	function payOnline() {
	
		document.applicationView.action="https://test.sbiepay.com/secure/AggregatorHostedListener";
        document.applicationView.submit();
}
	function challanReport3() {
		alert("You may please pay Challan amount on or before 09-SEPTEMBER-2018.\n Any payment after will not be applicable.");
		document.applicationView.action="printChallan?challan_type=sbi";
        document.applicationView.submit();
}
	function uploadPhoto() {
		//document.applicationView.requestFrom.value="uploadPhotoPage";
		document.getElementById("requestFrom1").value = "uploadPhotoPage";
		document.applicationView.action="uploadPhoto";
        document.applicationView.submit();
	}
	function acknoweledgementView() {
		document.applicationView.action="acknowledgement";
        document.applicationView.submit();
	}
	function goToInstructions() {
		document.location.href = "applicationAfterIndex";
	}
</script>

<script type="text/javascript">window.history.forward();function noBack(){
	window.history.forward();}
</script>
</head>
<body  onLoad="noBack();" onUnload="" oncontextmenu="return true;">
<jsp:include page="header.jsp" flush="true" />
	<!--wrapper div starts here-->
	   <div class="container-fluid">
  <div class="row">    
    <div class="col-md-12"> 

      <div class="panel">
        	<div class="panel-body	registrationDetails1">
        	
        	<div class="contentoutter">
					<div class="contentinner">
     <!--  <form name="applicationView" id="applicationView" method="post" action="#" target="_blank"> -->
     <form name="applicationView" id="applicationView" method="post" action="https://test.sbiepay.com/secure/AggregatorHostedListener" target="_blank"> 
     
      <jsp:useBean id="ApplicationFormBean" scope="session" class="com.ttil.bean.ApplicationFormBean" />
					<input type="hidden" name="requestFrom" value="TransactionPage" />
					
					<%--   <input type="hidden" id="org_name1" name="org_name1" value="RECRUITMENT FOR THE POSTS OF ASSISTANT SUB-INSPECTOR (STENO) AND HEAD CONSTABLE (MINISTERIAL) CADRE - 2017 FROM MALE AND FEMALE CITIZENS OF INDIA"/>
          <input type="hidden" id="notification_number1" name="notification_number1" value="XXXXXXXX DD/YYYY Dated DD-MM-YYYY"/>
          <input type="hidden" id="post_name1" name="post_name1" value="<jsp:getProperty name="ApplicationFormBean" property="post_applied"/>"/>
          <input type="hidden" id="post_end_date1" name="post_end_date1" value="30-05-2017"/>

		<input type="hidden" id="post_applied1" name="post_applied1" value="<jsp:getProperty name="ApplicationFormBean" property="post_applied"/>"/>
		<input type="hidden" id="marrital_status1" name="marrital_status1" value="<jsp:getProperty name="ApplicationFormBean" property="marrital_status"/>"/>
		<input type="hidden" id="nationality1" name="nationality1" value="<jsp:getProperty name="ApplicationFormBean" property="nationality"/>"/>
		<input type="hidden" id="aadharNo1" name="aadharNo1" value="<jsp:getProperty name="ApplicationFormBean" property="aadharNo"/>"/>
 --%>
 
          <input type="hidden" id="transactionid" name="transactionid" value="<jsp:getProperty name="ApplicationFormBean" property="transactionid"/>"/>
          <input type="hidden" id="first_name" name="first_name" value="<jsp:getProperty name="ApplicationFormBean" property="first_name"/>"/>
          <input type="hidden" id="middle_name" name="middle_name" value="<jsp:getProperty name="ApplicationFormBean" property="middle_name"/>"/>
          <input type="hidden" id="last_name" name="last_name" value="<jsp:getProperty name="ApplicationFormBean" property="last_name"/>"/>
          <input type="hidden" id="father_name" name="father_name" value="<jsp:getProperty name="ApplicationFormBean" property="father_name"/>"/>
          <input type="hidden" id="mother_name" name="mother_name" value="<jsp:getProperty name="ApplicationFormBean" property="mother_name"/>"/>
          <input type="hidden" id="village" name="village" value="<jsp:getProperty name="ApplicationFormBean" property="village"/>"/>
          <input type="hidden" id="postoffice" name="postoffice" value="<jsp:getProperty name="ApplicationFormBean" property="postoffice"/>"/>
          <input type="hidden" id="tehsil" name="tehsil" value="<jsp:getProperty name="ApplicationFormBean" property="tehsil"/>"/>
          <input type="hidden" id="policestation" name="policestation" value="<jsp:getProperty name="ApplicationFormBean" property="policestation"/>"/>
          <input type="hidden" id="district" name="district" value="<jsp:getProperty name="ApplicationFormBean" property="district"/>"/>
          <input type="hidden" id="state" name="state" value="<jsp:getProperty name="ApplicationFormBean" property="state"/>"/>
          <input type="hidden" id="pincode" name="pincode" value="<jsp:getProperty name="ApplicationFormBean" property="pincode"/>"/>
          <input type="hidden" id="village1" name="village1" value="<jsp:getProperty name="ApplicationFormBean" property="village1"/>"/>
          <input type="hidden" id="postoffice1" name="postoffice1" value="<jsp:getProperty name="ApplicationFormBean" property="postoffice1"/>"/>
          <input type="hidden" id="tehsil1" name="tehsil1" value="<jsp:getProperty name="ApplicationFormBean" property="tehsil1"/>"/>
          <input type="hidden" id="policestation1" name="policestation1" value="<jsp:getProperty name="ApplicationFormBean" property="policestation1"/>"/>
          <input type="hidden" id="district1" name="district1" value="<jsp:getProperty name="ApplicationFormBean" property="district1"/>"/>
          <input type="hidden" id="state1" name="state1" value="<jsp:getProperty name="ApplicationFormBean" property="state1"/>"/>
          <input type="hidden" id="pincode1" name="pincode1" value="<jsp:getProperty name="ApplicationFormBean" property="pincode1"/>"/>
          <input type="hidden" id="mobileNumber" name="mobileNumber" value="<jsp:getProperty name="ApplicationFormBean" property="mobileNumber"/>"/>
          <input type="hidden" id="emailaddress" name="emailaddress" value="<jsp:getProperty name="ApplicationFormBean" property="emailaddress"/>"/>
          <input type="hidden" id="religion" name="religion" value="<jsp:getProperty name="ApplicationFormBean" property="religion"/>"/>
          <input type="hidden" id="other_religion" name="other_religion" value="<jsp:getProperty name="ApplicationFormBean" property="other_religion"/>"/>
          <input type="hidden" id="sex" name="sex" value="<jsp:getProperty name="ApplicationFormBean" property="sex"/>"/>
          <input type="hidden" id="category" name="category" value="<jsp:getProperty name="ApplicationFormBean" property="category"/>"/>
          <input type="hidden" id="community" name="community" value="<jsp:getProperty name="ApplicationFormBean" property="community"/>"/>
           <input type="hidden" id="dob" name="dob" value="<jsp:getProperty name="ApplicationFormBean" property="dob"/>"/>
         <%--  <input type="hidden" id="affected_category_names" name="affected_category_names" value="<jsp:getProperty name="ApplicationFormBean" property="affected_category_names"/>"/> --%>
        <input type="hidden" id="marrital_status1" name="marrital_status1" value="<jsp:getProperty name="ApplicationFormBean" property="marrital_status"/>"/>
		<input type="hidden" id="nationality1" name="nationality1" value="<jsp:getProperty name="ApplicationFormBean" property="nationality"/>"/>
		<input type="hidden" id="aadharNo1" name="aadharNo1" value="<jsp:getProperty name="ApplicationFormBean" property="aadharNo"/>"/>
		
          <input type="hidden" id="ex_serviceman" name="ex_serviceman" value="<jsp:getProperty name="ApplicationFormBean" property="ex_serviceman"/>"/>
           <input type="hidden" id="exman_enrollment_date" name="exman_enrollment_date" value="<jsp:getProperty name="ApplicationFormBean" property="exman_enrollment_date"/>"/>
          <input type="hidden" id="exman_retirement_date" name="exman_retirement_date" value="<jsp:getProperty name="ApplicationFormBean" property="exman_retirement_date"/>"/>
          <input type="hidden" id="exman_med_cat" name="exman_med_cat" value="<jsp:getProperty name="ApplicationFormBean" property="exman_med_cat"/>"/>
          <input type="hidden" id="exman_awd_dec" name="exman_awd_dec" value="<jsp:getProperty name="ApplicationFormBean" property="exman_awd_dec"/>"/>
          <input type="hidden" id="exman_discharge_reason" name="exman_discharge_reason" value="<jsp:getProperty name="ApplicationFormBean" property="exman_discharge_reason"/>"/>
          <input type="hidden" id="exman_edu_qual" name="exman_edu_qual" value="<jsp:getProperty name="ApplicationFormBean" property="exman_edu_qual"/>"/>
          <input type="hidden" id="employee_ssb" name="employee_ssb" value="<jsp:getProperty name="ApplicationFormBean" property="employee_ssb"/>"/>
          <input type="hidden" id="govt_service" name="govt_service" value="<jsp:getProperty name="ApplicationFormBean" property="govt_service"/>"/>
          <input type="hidden" id="correspondence_address" name="correspondence_address" value="<jsp:getProperty name="ApplicationFormBean" property="correspondence_address"/>"/>
          <input type="hidden" id="debarment" name="debarment" value="<jsp:getProperty name="ApplicationFormBean" property="debarment"/>"/>
          <input type="hidden" id="fir_cases" name="fir_cases" value="<jsp:getProperty name="ApplicationFormBean" property="fir_cases"/>"/>
          <input type="hidden" id="fir_cases_pending" name="fir_cases_pending" value="<jsp:getProperty name="ApplicationFormBean" property="fir_cases_pending"/>"/>
          <input type="hidden" id="arrested" name="arrested" value="<jsp:getProperty name="ApplicationFormBean" property="arrested"/>"/>
          <input type="hidden" id="criminal_case_acquitted" name="criminal_case_acquitted" value="<jsp:getProperty name="ApplicationFormBean" property="criminal_case_acquitted"/>"/>
          <input type="hidden" id="good_behavior_bond" name="good_behavior_bond" value="<jsp:getProperty name="ApplicationFormBean" property="good_behavior_bond"/>"/>
          <input type="hidden" id="present_employer" name="present_employer" value="<jsp:getProperty name="ApplicationFormBean" property="present_employer"/>"/>
          <input type="hidden" id="emp_date_since" name="emp_date_since" value="<jsp:getProperty name="ApplicationFormBean" property="emp_date_since"/>"/>
          <input type="hidden" id="post_held" name="post_held" value="<jsp:getProperty name="ApplicationFormBean" property="post_held"/>"/>
          <input type="hidden" id="nocdesignation" name="nocdesignation" value="<jsp:getProperty name="ApplicationFormBean" property="nocdesignation"/>"/>
          <input type="hidden" id="firno" name="firno" value="<jsp:getProperty name="ApplicationFormBean" property="firno"/>"/>
          <input type="hidden" id="firdate" name="firdate" value="<jsp:getProperty name="ApplicationFormBean" property="firdate"/>"/>
          <input type="hidden" id="firsection" name="firsection" value="<jsp:getProperty name="ApplicationFormBean" property="firsection"/>"/>
          <input type="hidden" id="firdistrict" name="firdistrict" value="<jsp:getProperty name="ApplicationFormBean" property="firdistrict"/>"/>
          <input type="hidden" id="firstatus" name="firstatus" value="<jsp:getProperty name="ApplicationFormBean" property="firstatus"/>"/>
          <input type="hidden" id="photoFileName" name="photoFileName" value="<jsp:getProperty name="ApplicationFormBean" property="photoFileName"/>"/>
          <input type="hidden" id="sigFileName" name="sigFileName" value="<jsp:getProperty name="ApplicationFormBean" property="sigFileName"/>"/>
          <input type="hidden" id="identification_mark" name="identification_mark" value="<jsp:getProperty name="ApplicationFormBean" property="identification_mark"/>"/>
          <input type="hidden" id="date_created" name="date_created" value="<jsp:getProperty name="ApplicationFormBean" property="date_created"/>"/>
         <input type="hidden" id="payExempted" name="payExempted" value="<jsp:getProperty name="ApplicationFormBean" property="payExempted"/>"/>
         <input type="hidden" id="fee_amount" name="fee_amount" value="<jsp:getProperty name="ApplicationFormBean" property="fee_amount"/>"/>
        
          <input type="hidden" id="examorganizer" name="examorganizer" value="<jsp:getProperty name="ApplicationFormBean" property="examorganizer"/>"/>
          <input type="hidden" id="examname" name="examname" value="<jsp:getProperty name="ApplicationFormBean" property="examname"/>"/>
          <input type="hidden" id="examdate" name="examdate" value="<jsp:getProperty name="ApplicationFormBean" property="examdate"/>"/>
          <input type="hidden" id="debarenddate" name="debarenddate" value="<jsp:getProperty name="ApplicationFormBean" property="debarenddate"/>"/>
          <input type="hidden" id="debar_reason" name="debar_reason" value="<jsp:getProperty name="ApplicationFormBean" property="debar_reason"/>"/>
          <input type="hidden" id="other_reason" name="other_reason" value="<jsp:getProperty name="ApplicationFormBean" property="other_reason"/>"/>
          
            <input type="hidden" id="exam_passed_1" name="exam_passed_1" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_1"/>"/>
          <input type="hidden" id="stream_1" name="stream_1" value="<jsp:getProperty name="ApplicationFormBean" property="stream_1"/>"/>
          <input type="hidden" id="edu_marks_1" name="edu_marks_1" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_1"/>"/>
          <input type="hidden" id="university_1" name="university_1" value="<jsp:getProperty name="ApplicationFormBean" property="university_1"/>"/>
          <input type="hidden" id="edu_rollno_1" name="edu_rollno_1" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_1"/>"/>
          <input type="hidden" id="edu_certno_1" name="edu_certno_1" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_1"/>"/>
          <input type="hidden" id="edu_date_issue_1" name="edu_date_issue_1" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_1"/>"/>
          
          <input type="hidden" id="exam_passed_2" name="exam_passed_2" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_2"/>"/>
          <input type="hidden" id="stream_2" name="stream_2" value="<jsp:getProperty name="ApplicationFormBean" property="stream_2"/>"/>
          <input type="hidden" id="edu_marks_2" name="edu_marks_2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_2"/>"/>
           <input type="hidden" id="university_2" name="university_2" value="<jsp:getProperty name="ApplicationFormBean" property="university_2"/>"/>
          <input type="hidden" id="edu_rollno_2" name="edu_rollno_2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_2"/>"/>
          <input type="hidden" id="edu_certno_2" name="edu_certno_2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_2"/>"/>
          <input type="hidden" id="edu_date_issue_2" name="edu_date_issue_2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_2"/>"/>
          
          <input type="hidden" id="exam_passed_3" name="exam_passed_3" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_3"/>"/>
          <input type="hidden" id="stream_3" name="stream_3" value="<jsp:getProperty name="ApplicationFormBean" property="stream_3"/>"/>
          <input type="hidden" id="edu_marks_3" name="edu_marks_3" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_3"/>"/>
           <input type="hidden" id="university_3" name="university_3" value="<jsp:getProperty name="ApplicationFormBean" property="university_3"/>"/>
          <input type="hidden" id="edu_rollno_3" name="edu_rollno_3" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_3"/>"/>
          <input type="hidden" id="edu_certno_3" name="edu_certno_3" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_3"/>"/>
          <input type="hidden" id="edu_date_issue_3" name="edu_date_issue_3" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_3"/>"/>
          
          <input type="hidden" id="exam_passed_4" name="exam_passed_4" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_4"/>"/>
          <input type="hidden" id="stream_4" name="stream_4" value="<jsp:getProperty name="ApplicationFormBean" property="stream_4"/>"/>
          <input type="hidden" id="edu_marks_4" name="edu_marks_4" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_4"/>"/>
           <input type="hidden" id="university_4" name="university_4" value="<jsp:getProperty name="ApplicationFormBean" property="university_4"/>"/>
          <input type="hidden" id="edu_rollno_4" name="edu_rollno_4" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_4"/>"/>
          <input type="hidden" id="edu_certno_4" name="edu_certno_4" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_4"/>"/>
          <input type="hidden" id="edu_date_issue_4" name="edu_date_issue_4" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_4"/>"/>
          
          <input type="hidden" id="exam_passed_6" name="exam_passed_6" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_6"/>"/>
          <input type="hidden" id="stream_6" name="stream_6" value="<jsp:getProperty name="ApplicationFormBean" property="stream_6"/>"/>
          <input type="hidden" id="edu_marks_6" name="edu_marks_6" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_6"/>"/>
           <input type="hidden" id="university_6" name="university_6" value="<jsp:getProperty name="ApplicationFormBean" property="university_6"/>"/>
          <input type="hidden" id="edu_rollno_6" name="edu_rollno_6" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_6"/>"/>
          <input type="hidden" id="edu_certno_6" name="edu_certno_6" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_6"/>"/>
          <input type="hidden" id="edu_date_issue_6" name="edu_date_issue_6" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_6"/>"/>
          
          <input type="hidden" id="exam_passed_7" name="exam_passed_7" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_7"/>"/>
          <input type="hidden" id="stream_7" name="stream_7" value="<jsp:getProperty name="ApplicationFormBean" property="stream_7"/>"/>
          <input type="hidden" id="edu_marks_7" name="edu_marks_7" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_7"/>"/>
           <input type="hidden" id="university_7" name="university_7" value="<jsp:getProperty name="ApplicationFormBean" property="university_7"/>"/>
          <input type="hidden" id="edu_rollno_7" name="edu_rollno_7" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_7"/>"/>
          <input type="hidden" id="edu_certno_7" name="edu_certno_7" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_7"/>"/>
          <input type="hidden" id="edu_date_issue_7" name="edu_date_issue_7" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_7"/>"/>
					
       <input type="hidden" id="other_nationality" name="other_nationality" value="<jsp:getProperty name="ApplicationFormBean" property="other_nationality"/>"/>
       					
		<input type="hidden" id="categoty_belongs" name="categoty_belongs" value="<jsp:getProperty name="ApplicationFormBean" property="categoty_belongs"/>"/>			
		<input type="hidden" id="jk_domiciled" name="jk_domiciled" value="<jsp:getProperty name="ApplicationFormBean" property="jk_domiciled"/>"/>
		<input type="hidden" id="riots_affected" name="riots_affected" value="<jsp:getProperty name="ApplicationFormBean" property="riots_affected"/>"/>
		<input type="hidden" id="riots_gujarat" name="riots_gujarat" value="<jsp:getProperty name="ApplicationFormBean" property="riots_gujarat"/>"/>
		
		<input type="hidden" id="cat_cert_no" name="cat_cert_no" value="<jsp:getProperty name="ApplicationFormBean" property="cat_cert_no"/>"/>
		<input type="hidden" id="cat_date_Issue" name="cat_date_Issue" value="<jsp:getProperty name="ApplicationFormBean" property="cat_date_Issue"/>"/>
		<input type="hidden" id="cat_issue_authority" name="cat_issue_authority" value="<jsp:getProperty name="ApplicationFormBean" property="cat_issue_authority"/>"/>
		
		<input type="hidden" id="jk_cert_no" name="jk_cert_no" value="<jsp:getProperty name="ApplicationFormBean" property="jk_cert_no"/>"/>
		<input type="hidden" id="jk_date_Issue" name="jk_date_Issue" value="<jsp:getProperty name="ApplicationFormBean" property="jk_date_Issue"/>"/>
		<input type="hidden" id="jk_issue_authority" name="jk_issue_authority" value="<jsp:getProperty name="ApplicationFormBean" property="jk_issue_authority"/>"/>
		
		<input type="hidden" id="riots_cert_no" name="riots_cert_no" value="<jsp:getProperty name="ApplicationFormBean" property="riots_cert_no"/>"/>
		<input type="hidden" id="riots_date_Issue" name="riots_date_Issue" value="<jsp:getProperty name="ApplicationFormBean" property="riots_date_Issue"/>"/>
		<input type="hidden" id="riots_issue_authority" name="riots_issue_authority" value="<jsp:getProperty name="ApplicationFormBean" property="riots_issue_authority"/>"/>
		
		<input type="hidden" id="riots_guj_cert_no" name="riots_guj_cert_no" value="<jsp:getProperty name="ApplicationFormBean" property="riots_guj_cert_no"/>"/>
		<input type="hidden" id="riots_guj_date_Issue" name="riots_guj_date_Issue" value="<jsp:getProperty name="ApplicationFormBean" property="riots_guj_date_Issue"/>"/>
		<input type="hidden" id="riots_guj_issue_authority" name="riots_guj_issue_authority" value="<jsp:getProperty name="ApplicationFormBean" property="riots_guj_issue_authority"/>"/>
		
					<%
                      ApplicationFormBean applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
        			 %>
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="padding:30px 0px 0px 0px;">
          
            
          <tr>
            <td colspan="4" align="center" valign="middle" class="bdr"><h2>Application Status</h2></td>
          </tr>
          <tr>
            <td colspan="4" align="center" valign="middle">
              <input type="hidden" name="requestFrom1" id="requestFrom1" />
            
            <table width="95%" border="0" align="center" cellpadding="5" cellspacing="0" >
             <%--  <%
                     if(applicationFormBean.getMessage()!=null && !"".equalsIgnoreCase(applicationFormBean.getMessage()))
                     {
                     %>
						<tr>
							<td colspan="2"
								class="center rightbodernoneclass colorText"><b><jsp:getProperty
										name="ApplicationFormBean" property="message" /></b></td>
						</tr>
						<%} %> --%>

				          <tr>
				            <td colspan="2" height="80"  align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle2">RegistrationID : <%=applicationFormBean.getTransactionid() %></div></td>
				          </tr>
				          
				           <tr>
							   <td colspan="2" align="left" valign="middle">
							      <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
							   <%if(applicationFormBean.getApplication_status()!=null && applicationFormBean.getApplication_status().equalsIgnoreCase("NEW")) {%>
							  <tr>
					            <td colspan="2" height="70"  align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle3"> You have successfully filled in the Application Form.</div></td>
					          </tr>
							 
							  <tr>
							    <td><div class="buttonWrapper" style="margin:20px 0px 0px 0px;"> 
							            <input type="button" class="nextbutton appFormBtmRight" value="Upload Photo &amp; Signature" onClick="uploadPhoto()" style="margin:0px 0px  0px 20px;width:270px;">
							                        
							          </div></td>
							  </tr>
							  <%} else if(applicationFormBean.getApplication_status()!=null && applicationFormBean.getApplication_status().equalsIgnoreCase("FINISHED")) {
							  if(applicationFormBean.isPayExempted()==false){
							  %>
							  
							  
							  <tr>
					            <td colspan="2" height="70"  align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle3">  Proceed to make Payment - Amount to be paid : <%=applicationFormBean.getFee_amount() %>.</div></td>
					          </tr>
					          
					            <tr>
								    <td><div class="buttonWrapper" style="margin:20px 0px 0px 0px;"> 
								    <input type="hidden" name="EncryptTrans" value="<%=request.getAttribute("EncryptTrans")%>">
									<input type="hidden" name="merchIdVal" value="1000420" />
		
								                        <!-- <input type="button" class="nextbutton appFormBtmleft" value="Pay Online" onClick="challanReport2()" style="margin:0px 0px  0px 20px;width:200px;"> -->
								                         <input type="button" class="nextbutton appFormBtmleft" value="Print Acknowledgemnent" onClick="acknoweledgementView()" style="margin:0px 0px  0px 20px;width:250px;">
								                        <input name="formBack0" type="button" class="nextbutton appFormBtmRight" value="SBI Challan" alt="Next step" style="width:150px;" onClick="challanReport3()">
								                        <input name="formBack0" type="submit" class="nextbutton appFormBtmRight" value="Pay Online" alt="Next step" style="width:200px; margin:0px 20px 0px 0px;" >
								                        <!-- <input name="formBack0" type="button" class="nextbutton appFormBtmRight" value="Postoffice Challan" alt="Next step" style="width:200px; margin:0px 20px 0px 0px;" onClick="challanReport1()"> -->
								                        
								                      </div></td>
								  </tr>
								  <%}else{ %>
								   <tr>
					            <td colspan="2" height="100"  align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle3">  Your application has been submitted successfully and payment has been received.</div></td>
					          </tr>
					          
								   <tr>
							    <td><div class="buttonWrapper" style="margin:20px 0px 0px 0px;"> 
							            <input type="button" class="nextbutton appFormBtmRight" value="Print Acknowledgemnent" onClick="acknoweledgementView()" style="margin:0px 0px  0px 20px;width:270px;">
							                        
							          </div></td>
							  </tr>
   							<%} %>
					          
							   <%}  else if(applicationFormBean.getApplication_status()!=null && applicationFormBean.getApplication_status().equalsIgnoreCase("COMPLETED")) {%>
							   <tr>
					            <td colspan="2" height="100"  align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle3">  Your application has been submitted successfully and payment has been received.</div></td>
					          </tr>
					          <tr>
							    <td><div class="buttonWrapper" style="margin:20px 0px 0px 0px;"> 
							            <input type="button" class="nextbutton appFormBtmRight" value="Print Acknowledgemnent" onClick="acknoweledgementView()" style="margin:0px 0px  0px 20px;width:270px;">
							                        
							          </div></td>
							  </tr>
					          
							   <%} %>
                            </table>
                            </td>
                            </tr>
					
						</table>
					</td>
			</tr>
						
											
             <tr>
				<td colspan="2" class="bdr"><h4>Personal Details</h4></td>
			</tr>
			<tr>
				<td colspan="2"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0"> 
             <tr>
                <td width="39%"><label class="label1">Post Applied For : </label></td>
                <td width="61%"><label><jsp:getProperty name="ApplicationFormBean" property="post_applied" /></label></td>
              </tr>
              <tr>
                <td width="39%"><label class="label1">Name : </label></td>
                 <td width="61%"><label><jsp:getProperty name="ApplicationFormBean" property="first_name" /> <jsp:getProperty name="ApplicationFormBean" property="middle_name" /> <jsp:getProperty name="ApplicationFormBean" property="last_name" /></label></td>
              </tr>
             
              <tr>
                <td><label class="label1">Father's Name : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="father_name" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Mother's Name : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="mother_name" /></label></td>
              </tr>
              
              <tr>
                <td><label class="label1">Date of Birth : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="dob" /></label></td>
              </tr>
               <tr>
                <td><label class="label1">Gender : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="sex" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Religion : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="religion" /></label></td>
              </tr>
               <% if("Others".equalsIgnoreCase(applicationFormBean.getOther_religion())){%>
              <tr>
                <td><label class="label1">Other Religion : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="other_religion" /></label></td>
              </tr>
              <%} %>
               <tr>
                <td><label class="label1">Marital Status : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="marrital_status" /></label></td>
              </tr>
               <tr>
                <td><label class="label1">Nationality  : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="nationality" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Category : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="community" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Community belonging to any  : </label></td>
                <td><label><% if(applicationFormBean.isCategoty_belongs()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%if(applicationFormBean.isCategoty_belongs()){ %>
              <tr>
                <td colspan="2">
                   <table width="100%" cellspacing="0" cellpadding="5" border="0" align="center" class="border1">
                     <tbody>
                     <tr>
                       <td><label class="label1">Community</label></td>
                       <td><label class="label1">Certificate No</label></td>
                       <td><label class="label1">Date Of Issued</label></td>
                       <td><label class="label1">Issuing authority</label></td>
                      </tr>
                      <tr>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="category" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="cat_cert_no" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="cat_date_Issue" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="cat_issue_authority" /></label></td>
                      </tr>  
                     </tbody>
                   </table>
                </td>
              </tr>
              <%} %>
               <tr>
                <td><label class="label1">Whether domiciled ordinary in J&amp;K during 1980 to 1989  : </label></td>
                <td><label><% if(applicationFormBean.isJk_domiciled()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%if(applicationFormBean.isJk_domiciled()){ %>
              <tr>
                <td colspan="2">
                   <table width="100%" cellspacing="0" cellpadding="5" border="0" align="center" class="border1">
                     <tbody>
                     <tr>
                       <td><label class="label1">Certificate No</label></td>
                       <td><label class="label1">Date Of Issued</label></td>
                       <td><label class="label1">Issuing authority</label></td>
                      </tr>
                      <tr>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="jk_cert_no" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="jk_date_Issue" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="jk_issue_authority" /></label></td>
                      </tr>  
                     </tbody>
                   </table>
                </td>
              </tr>
              <%} %>
              
               <tr>
                <td><label class="label1">Whether affected in 1984 riots  : </label></td>
                <td><label><% if(applicationFormBean.isRiots_affected()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%if(applicationFormBean.isRiots_affected()){ %>
              <tr>
                <td colspan="2">
                   <table width="100%" cellspacing="0" cellpadding="5" border="0" align="center" class="border1">
                     <tbody>
                     <tr>
                       <td><label class="label1">Certificate No</label></td>
                       <td><label class="label1">Date Of Issued</label></td>
                       <td><label class="label1">Issuing authority</label></td>
                      </tr>
                      <tr>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="riots_cert_no" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="riots_date_Issue" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="riots_issue_authority" /></label></td>
                      </tr>  
                     </tbody>
                   </table>
                </td>
              </tr>
              <%} %>
              
              <tr>
                <td><label class="label1">Whether affected in 2002 communal riots of Gujarat  : </label></td>
                <td><label><% if(applicationFormBean.isRiots_gujarat()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%if(applicationFormBean.isRiots_gujarat()){ %>
              <tr>
                <td colspan="2">
                   <table width="100%" cellspacing="0" cellpadding="5" border="0" align="center" class="border1">
                     <tbody>
                     <tr>
                       <td><label class="label1">Certificate No</label></td>
                       <td><label class="label1">Date Of Issued</label></td>
                       <td><label class="label1">Issuing authority</label></td>
                      </tr>
                      <tr>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="riots_guj_cert_no" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="riots_guj_date_Issue" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="riots_guj_issue_authority" /></label></td>
                      </tr>  
                     </tbody>
                   </table>
                </td>
              </tr>
              <%} %>
              
            
              <tr>
                <td><label class="label1">Whether Ex-Serviceman : </label></td>
                <td><label><% if(applicationFormBean.isEx_serviceman()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%if(applicationFormBean.isEx_serviceman()){ %>
              <tr>
                <td colspan="2">
                   <table width="100%" cellspacing="0" cellpadding="5" border="0" align="center" class="border1">
                     <tbody>
                     <tr>
                       <td><label class="label1">Date of Enrollment</label></td>
                       <td><label class="label1">Date of Retirement / Discharge</label></td>
                       <td><label class="label1">Medical Category</label></td>
                       <td><label class="label1">Award or Decoration</label></td>
                       <td><label class="label1">Reasons for release/Discharge</label></td>
                       <td><label class="label1">Education Qualification</label></td>
                      </tr>
                      <tr>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_enrollment_date" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_retirement_date" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_med_cat" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_awd_dec" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_discharge_reason" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_edu_qual" /></label></td>
                      </tr>  
                     </tbody>
                   </table>
                </td>
              </tr>
              <%} %>
              
               <tr>
                <td><label class="label1">Whether Employed In SSB : </label></td>
                <td><label><% if(applicationFormBean.isEmployee_ssb()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
               <tr>
                <td><label class="label1">Whether in Government Service : </label></td>
                <td><label><% if(applicationFormBean.isGovt_service()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <% if(applicationFormBean.isGovt_service() || applicationFormBean.isEmployee_ssb()){ %> 
               <tr>
                <td colspan="2">
                   <table width="100%" cellspacing="0" cellpadding="5" border="0" align="center" class="border1">
                     <tbody>
                     <tr>
                       <td><label class="label1">Name of Present Employer</label></td>
                       <td><label class="label1">Date Since When</label></td>
                       <td><label class="label1">Post held</label></td>
                       <td><label class="label1">Name and Designation of Authority Issuing N.O.C</label></td>
                      </tr>
                      <tr>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="present_employer" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="emp_date_since" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="post_held" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="nocdesignation" /></label></td>
                      </tr>  
                     </tbody>
                   </table>
                </td>
              </tr>
              <%} %>
             
		</table>
		</td>
		</tr>
		
		<tr>
		   <td colspan="2"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0"> 
		      <tr>
                <td  width="39%"><label class="label1">Aadhar Card No : </label></td>
                <td  width="61%"><label><jsp:getProperty name="ApplicationFormBean" property="aadharNo" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Identification Marks : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="identification_mark" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Mobile Number : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="mobileNumber" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Email Address : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="emailaddress" /></label></td>
              </tr>
           </table>
          </td>
          </tr>
															 
           <tr>
				<td class="bdr" colspan="2"><h4>Education Qualification Details</h4></td>
			</tr>
			
			<tr>
				<td colspan="2"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
              
              <%--  <tr>
                <td><label class="label1">Qualification</label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="edu_qual" /></label></td>
              </tr> --%>
              
              <tr>
                <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                  
                 <tr>
                    <td width="10%" class="border1"><label class="label1">Exam Passed</label></td>
                    <td width="20%" class="border1"><label class="label1">School/ University/ Board/ Institute</label></td>
                    <td width="20%" class="border1"><label class="label1">Roll No</label></td>
                    <td width="10%" class="border1"><label class="label1">Certificate No</label></td>
                    <td width="10%" class="border1"><label class="label1">Date Of Issued</label></td>
                    <td width="17%" class="border1"><label class="label1">Subject</label></td>
                    <td width="13%" class="border1"><label class="label1">Percentage of Marks</label></td>
                  </tr>
                  <% 
                  String exam_passed_1=applicationFormBean.getExam_passed_1();
                  String stream_1=applicationFormBean.getStream_1();
                  String university_1=applicationFormBean.getUniversity_1();
                  String edu_rollno_1=applicationFormBean.getEdu_rollno_1();
                  String edu_certno_1=applicationFormBean.getEdu_certno_1();
                  String edu_date_issue_1=applicationFormBean.getEdu_date_issue_1();
                  
                  String exam_passed_2=applicationFormBean.getExam_passed_2();
                  String stream_2=applicationFormBean.getStream_2();
                  String university_2=applicationFormBean.getUniversity_2();
                  String edu_rollno_2=applicationFormBean.getEdu_rollno_2();
                  String edu_certno_2=applicationFormBean.getEdu_certno_2();
                  String edu_date_issue_2=applicationFormBean.getEdu_date_issue_2();
                  
                  String exam_passed_3=applicationFormBean.getExam_passed_3();
                  String stream_3=applicationFormBean.getStream_3();
                  String university_3=applicationFormBean.getUniversity_3();
                  String edu_rollno_3=applicationFormBean.getEdu_rollno_3();
                  String edu_certno_3=applicationFormBean.getEdu_certno_3();
                  String edu_date_issue_3=applicationFormBean.getEdu_date_issue_3();
                  
                  String exam_passed_4=applicationFormBean.getExam_passed_4();
                  String stream_4=applicationFormBean.getStream_4();
                  String university_4=applicationFormBean.getUniversity_4();
                  String edu_rollno_4=applicationFormBean.getEdu_rollno_4();
                  String edu_certno_4=applicationFormBean.getEdu_certno_4();
                  String edu_date_issue_4=applicationFormBean.getEdu_date_issue_4();
                  
                  String exam_passed_6=applicationFormBean.getExam_passed_6();
                  String stream_6=applicationFormBean.getStream_6();
                  String university_6=applicationFormBean.getUniversity_6();
                  String edu_rollno_6=applicationFormBean.getEdu_rollno_6();
                  String edu_certno_6=applicationFormBean.getEdu_certno_6();
                  String edu_date_issue_6=applicationFormBean.getEdu_date_issue_6();
                  
                  String exam_passed_7=applicationFormBean.getExam_passed_7();
                  String stream_7=applicationFormBean.getStream_7();
                  String university_7=applicationFormBean.getUniversity_7();
                  String edu_rollno_7=applicationFormBean.getEdu_rollno_7();
                  String edu_certno_7=applicationFormBean.getEdu_certno_7();
                  String edu_date_issue_7=applicationFormBean.getEdu_date_issue_7();
                  
                  String edu_marks_1=applicationFormBean.getEdu_marks_1();
                  String edu_marks_2=applicationFormBean.getEdu_marks_2();
                  String edu_marks_3=applicationFormBean.getEdu_marks_3();
                  String edu_marks_4=applicationFormBean.getEdu_marks_4();
                  String edu_marks_6=applicationFormBean.getEdu_marks_6();
                  String edu_marks_7=applicationFormBean.getEdu_marks_7();
                     
                    
                  boolean edu_qual_1=true,edu_qual_2=true,edu_qual_3=true,edu_qual_4=true,edu_qual_5=true,edu_qual_6=true,edu_qual_7=true,edu_qual_8=true;
                     if(exam_passed_1==null || stream_1==null || university_1==null || edu_rollno_1==null || edu_certno_1==null || edu_date_issue_1==null || edu_marks_1==null || 
                    		 "".equalsIgnoreCase(exam_passed_1) || "".equalsIgnoreCase(stream_1) || "".equalsIgnoreCase(university_1) || "".equalsIgnoreCase(edu_rollno_1) || "".equalsIgnoreCase(edu_certno_1) || "".equalsIgnoreCase(edu_date_issue_1) || "".equalsIgnoreCase(edu_marks_1) 
                    	){
                    	 edu_qual_1=false;
                     }
                     if(exam_passed_2==null || stream_2==null || university_2==null || edu_rollno_2==null || edu_certno_2==null || edu_date_issue_2==null || edu_marks_2==null ||
                    		 "".equalsIgnoreCase(exam_passed_2) || "".equalsIgnoreCase(stream_2) || "".equalsIgnoreCase(university_2) || "".equalsIgnoreCase(edu_rollno_2) || "".equalsIgnoreCase(edu_certno_2) || "".equalsIgnoreCase(edu_date_issue_2) || "".equalsIgnoreCase(edu_marks_2)){
                    	 edu_qual_2=false;
                     }
                     if(exam_passed_3==null || stream_3==null || university_3==null || edu_rollno_3==null || edu_certno_3==null || edu_date_issue_3==null || edu_marks_3==null ||
                    		 "".equalsIgnoreCase(exam_passed_3) || "".equalsIgnoreCase(stream_3) || "".equalsIgnoreCase(university_3) || "".equalsIgnoreCase(edu_rollno_3) || "".equalsIgnoreCase(edu_certno_3) || "".equalsIgnoreCase(edu_date_issue_3) || "".equalsIgnoreCase(edu_marks_3)){
                    	 edu_qual_3=false;
                     }
                     if(exam_passed_4==null || stream_4==null || university_4==null || edu_rollno_4==null || edu_certno_4==null || edu_date_issue_4==null || edu_marks_4==null ||
                    		 "".equalsIgnoreCase(exam_passed_4) || "".equalsIgnoreCase(stream_4) || "".equalsIgnoreCase(university_4) || "".equalsIgnoreCase(edu_rollno_4) || "".equalsIgnoreCase(edu_certno_4) || "".equalsIgnoreCase(edu_date_issue_4) || "".equalsIgnoreCase(edu_marks_4)){
                    	 edu_qual_4=false;
                     }
                     if(exam_passed_6==null || stream_6==null || university_6==null || edu_rollno_6==null || edu_certno_6==null || edu_date_issue_6==null || edu_marks_6==null ||
                    		 "".equalsIgnoreCase(exam_passed_6) || "".equalsIgnoreCase(stream_6) || "".equalsIgnoreCase(university_6) || "".equalsIgnoreCase(edu_rollno_6) || "".equalsIgnoreCase(edu_certno_6) || "".equalsIgnoreCase(edu_date_issue_6) || "".equalsIgnoreCase(edu_marks_6)){
                    	 edu_qual_6=false;
                     }
                     if(exam_passed_7==null || stream_7==null || university_7==null || edu_rollno_7==null || edu_certno_7==null || edu_date_issue_7==null || edu_marks_7==null ||
                    		 "".equalsIgnoreCase(exam_passed_7) || "".equalsIgnoreCase(stream_7) || "".equalsIgnoreCase(university_7) || "".equalsIgnoreCase(edu_rollno_7) || "".equalsIgnoreCase(edu_certno_7) || "".equalsIgnoreCase(edu_date_issue_7) || "".equalsIgnoreCase(edu_marks_7)){
                    	 edu_qual_7=false;
                     }
                   
                     %>
                    <%if(edu_qual_1){ %>
                  <tr>
                   <td class="border1"><label class="label2"><%=exam_passed_1 %></label></td>
                    <td class="border1"><label class="label2"><%=university_1 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_rollno_1 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_certno_1 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_date_issue_1 %></label></td>
                     <td class="border1"><label class="label2"><%=stream_1 %></label></td>
                      <td class="border1"><label class="label2"><%=edu_marks_1 %></label></td>
                  </tr>
                  <%}if(edu_qual_2){  %>
                  <tr>
                    <td class="border1"><label class="label2"><%=exam_passed_2 %></label></td>
                    <td class="border1"><label class="label2"><%=university_2 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_rollno_2 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_certno_2 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_date_issue_2 %></label></td>
                     <td class="border1"><label class="label2"><%=stream_2 %></label></td>
                     <td class="border1"><label class="label2"><%=edu_marks_2 %></label></td>
                  </tr>
                  <%}if(edu_qual_3){  %>
                  <tr>
                    <td class="border1"><label class="label2"><%=exam_passed_3 %></label></td>
                    <td class="border1"><label class="label2"><%=university_3 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_rollno_3 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_certno_3 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_date_issue_3 %></label></td>
                     <td class="border1"><label class="label2"><%=stream_3 %></label></td>
                     <td class="border1"><label class="label2"><%=edu_marks_3 %></label></td>
                  </tr>
                  <%}if(edu_qual_4){  %>
                  <tr>
                     <td class="border1"><label class="label2"><%=exam_passed_4 %></label></td>
                    <td class="border1"><label class="label2"><%=university_4 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_rollno_4 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_certno_4 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_date_issue_4 %></label></td>
                     <td class="border1"><label class="label2"><%=stream_4 %></label></td>
                     <td class="border1"><label class="label2"><%=edu_marks_4 %></label></td>
                  </tr>
                  <%}if(edu_qual_6){  %>
                  <tr>
                    <td class="border1"><label class="label2"><%=exam_passed_6 %></label></td>
                    <td class="border1"><label class="label2"><%=university_6 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_rollno_6 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_certno_6 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_date_issue_6 %></label></td>
                     <td class="border1"><label class="label2"><%=stream_6 %></label></td>
                     <td class="border1"><label class="label2"><%=edu_marks_6 %></label></td>
                  </tr>
                  <%}if(edu_qual_7){  %>
                  <tr>
                     <td class="border1"><label class="label2"><%=exam_passed_7 %></label></td>
                    <td class="border1"><label class="label2"><%=university_7 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_rollno_7 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_certno_7 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_date_issue_7 %></label></td>
                     <td class="border1"><label class="label2"><%=stream_7 %></label></td>
                     <td class="border1"><label class="label2"><%=edu_marks_7 %></label></td>
                  </tr>
                  <%}%>
                </table></td>
              </tr>
           </table>
           </td>
           </tr>
              
            <tr>
				<td class="bdr"  colspan="2"><h4>Address Details</h4></td>
			</tr>
			<tr>
				<td colspan="2"><table width="96%" border="1" align="center" cellpadding="5" cellspacing="0" style="margin-top: 10px; margin-bottom: 10px;">
           
			  <tr>
					<td colspan="2"><h6 style="text-align:center;">Permanent Address </h6></td>
					<td colspan="2"><h6 style="text-align:center;">Correspondence Address </h6></td>
			 </tr>
              <tr>
                <td width="10%"><label class="label1">Village/Town </label></td>
                <td width="36%"><label><jsp:getProperty name="ApplicationFormBean" property="village" /></label></td>
                <td width="10%"><label class="label1">Village/Town </label></td>
                <td width="36%"><label><jsp:getProperty name="ApplicationFormBean" property="village1" /></label></td>
              </tr>
              <tr>
                <td ><label class="label1">Post Office </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="postoffice" /></label></td>
                 <td><label class="label1">Post Office </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="postoffice1" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Tehsil </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="tehsil" /></label></td>
                <td><label class="label1">Tehsil </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="tehsil1" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Police Station </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="policestation" /></label></td>
                 <td><label class="label1">Police Station </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="policestation1" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">District </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="district" /></label></td>
                <td><label class="label1">District </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="district1" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">State </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="state" /></label></td>
                 <td><label class="label1">State </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="state1" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Pin code </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="pincode" /></label></td>
                 <td><label class="label1">Pin code </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="pincode1" /></label></td>
              </tr>
              </table>
         </td>
         </tr>
            
            <tr>
				<td class="bdr"  colspan="2"><h4>Declaration of Criminal Cases</h4></td>
			</tr>
			<tr>
				<td colspan="2"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">    
              
               <tr>
                <td colspan="2"><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                 <tr>
                    <td width="73%" colspan="2"><label class="label1">Have you ever been debarred by UPSC, SSC or SPSC or any recruitment board from appearing in any exam?</label></td>
                    <td valign="top"><label><% if(applicationFormBean.isDebarment()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                 </table>
                </td>
               </tr>     
             <% if(applicationFormBean.isDebarment()){ %> 
             <tr>
                <td><label class="label1">Exam Organizer : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="examorganizer" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Exam Name : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="examname" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Exam Date : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="examdate" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Debarment End Date : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="debarenddate" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Reason : </label></td>
                <td><label>
                <% if("Others".equalsIgnoreCase(applicationFormBean.getDebar_reason())){ %> 
                <jsp:getProperty name="ApplicationFormBean" property="other_reason" />
                <%}else{%>
                 <jsp:getProperty name="ApplicationFormBean" property="debar_reason" />
               <% }%>
                </label></td>
              </tr>
              
              <%} %>
              <tr>
                <td colspan="2"><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                 <tr>
                    <td colspan="2"><label class="label1">Criminal Proceeding details, if any </label></td>
                  </tr>
                  <tr>
                    <td  width="2%" align="center" valign="top"><label style="font-weight:bold;"> a) </label></td>
                    <td width="71%"><label class="label1">Whether any FIR or criminal case(s) has ever been registered against you?</label></td>
                    <td valign="top"><label><% if(applicationFormBean.isFir_cases()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="center" valign="top"><label style="font-weight:bold;"> b) </label></td>
                    <td><label class="label1">Whether any criminal complaint case or FIR or criminal case(s) is pending 
                      against you in Court of Law, <br/>or with police at the time of submitting the
                      application form?</label></td>
                    <td valign="top"><label><% if(applicationFormBean.isFir_cases_pending()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="center" valign="top"><label style="font-weight:bold;"> c) </label></td>
                    <td><label class="label1">Have you ever been arrested/detained in any criminal case(s)?</label></td>
                    <td valign="top"><label><% if(applicationFormBean.isArrested()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="center" valign="top"><label style="font-weight:bold;"> d) </label></td>
                    <td><label class="label1">Have you ever been tried &amp; convicted or acquitted by a Court of Law in any criminal case(s)?</label></td>
                    <td valign="top"><label><% if(applicationFormBean.isCriminal_case_acquitted()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="center" valign="top"><label style="font-weight:bold;"> e) </label></td>
                    <td><label class="label1">Have you ever been tried &amp; convicted by the Court by filling any bond for good behaviour etc.?</label></td>
                    <td valign="top"><label><% if(applicationFormBean.isGood_behavior_bond()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                </table></td>
                </tr>
               <%
               boolean fir_cases=false;
               if(applicationFormBean.isFir_cases())
            	   fir_cases=true;
               if(applicationFormBean.isFir_cases_pending())
            	   fir_cases=true;
               if(applicationFormBean.isArrested())
            	   fir_cases=true;
               if(applicationFormBean.isCriminal_case_acquitted())
            	   fir_cases=true;
               if(applicationFormBean.isGood_behavior_bond())
            	   fir_cases=true;
               if(fir_cases){
               %> 
              <tr>
                <td><label class="label1">FIR No. : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="firno" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Date : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="firdate" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Under Section : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="firsection" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">District : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="firdistrict" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Present status of the case at the time of filling up this application form : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="firstatus" /></label></td>
              </tr>
              <%} %>
            
              </table>
          </td>
          </tr>    
              
       </table>
         
        </form>
      </div>
    </div>
    
  </div>
</div>
</div>
</div>
</div>
<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
