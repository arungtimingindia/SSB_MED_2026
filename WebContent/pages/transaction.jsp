<%@ page import="com.ttil.bean.ApplicationFormBean" %>
<%@ page import="com.ttil.bean.PostsBean" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="shortcut icon" href="images/favicon.jpg" />
<title>welcome to ssb online application</title>
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
	function challanReport2() {
		alert("You may please pay Challan amount on or before 09-SEPTEMBER-2018.\n Any payment after will not be applicable.");
		document.applicationView.action="printChallan?challan_type=sbbj";
        document.applicationView.submit();
}
	function challanReport3() {
		alert("You may please pay Challan amount on or before 09-SEPTEMBER-2018.\n Any payment after will not be applicable.");
		document.applicationView.action="printChallan?challan_type=sbi";
        document.applicationView.submit();
}
	
	function acknoweledgementView() {
		document.applicationView.action="acknowledgement";
        document.applicationView.submit();
	}
	function sbiPayment() {
		document.applicationView.action="sbipaymentgateway";
        document.applicationView.submit();
	}
	function hdfcPayment() {
		document.applicationView.action="paymentgateway";
        document.applicationView.submit();
	}
	function goToInstructions() {
		document.location.href = "applicationIndex";
	}
</script>
<script type="text/javascript">window.history.forward();function noBack(){
	window.history.forward();}
</script>
</head>
<body onLoad="noBack()" onpageshow="if (event.persisted) noBack();" onUnload="" oncontextmenu="return true;">

<jsp:include page="header.jsp" flush="true" />
	<!--wrapper div starts here-->
	   <div class="container-fluid">
  <div class="row">    
    <div class="col-md-12"> 

      <div class="panel">
        	<div class="panel-body	registrationDetails">
        	
        	<div class="contentoutter">
					<div class="contentinner">
					
      <!-- <form name="applicationView" id="applicationView" method="post"	target="_blank" action="https://test.sbiepay.com/secure/AggregatorHostedListener"> -->
      <!-- <form name="applicationView" id="applicationView" method="post" target="_blank" 	action="https://secure.ccavenue.com/transaction/transaction.do?command=initiateTransaction"> -->
     <form name="applicationView" id="applicationView" method="post" target="_blank" 	action="paymentgateway"> 
      
			<jsp:useBean id="ApplicationFormBean" scope="request"
				class="com.ttil.bean.ApplicationFormBean" />
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="padding:30px 0px 0px 0px;">
          <%
         // PostsBean postsBean=(PostsBean)request.getAttribute("postDetails");
          ApplicationFormBean applicationFormBean= (ApplicationFormBean)request.getAttribute("ApplicationFormBean");
          %>
           <tr>
            <td colspan="4" align="left" valign="middle" class="bdr"><h2>Acknowledgement</h2>
          <input type="hidden" id="requestFrom" name="requestFrom" value="TransactionPage"/>
          <%-- <input type="hidden" id="org_name" name="org_name" value="<%=postsBean.getOrg_name()%>"/>
          <input type="hidden" id="notification_number" name="notification_number" value="<%=postsBean.getNotification_number()%>"/>
          <input type="hidden" id="post_name" name="post_name" value="<%=postsBean.getPost_name() %>"/>
          <input type="hidden" id="post_end_date" name="post_end_date" value="<%=postsBean.getPost_end_date() %>"/> --%>
          
          <%-- <input type="hidden" id="org_name" name="org_name" value="RECRUITMENT FOR THE POSTS OF ASSISTANT SUB-INSPECTOR (STENO) AND HEAD CONSTABLE (MINISTERIAL) CADRE - 2017 FROM MALE AND FEMALE CITIZENS OF INDIA"/>
          <input type="hidden" id="notification_number" name="notification_number" value="XXXXXXXX DD/YYYY Dated DD-MM-YYYY"/>
          <input type="hidden" id="post_end_date" name="post_end_date" value="30-05-2017"/>

		
		<input type="hidden" id="domicile_state" name="domicile_state" value="<jsp:getProperty name="ApplicationFormBean" property="domicile_state"/>"/>
		<input type="hidden" id="marrital_status" name="marrital_status" value="<jsp:getProperty name="ApplicationFormBean" property="marrital_status"/>"/>
		<input type="hidden" id="nationality" name="nationality" value="<jsp:getProperty name="ApplicationFormBean" property="nationality"/>"/>
		<input type="hidden" id="aadharNo" name="aadharNo" value="<jsp:getProperty name="ApplicationFormBean" property="aadharNo"/>"/>
 --%>
        <input type="hidden" id="post_applied" name="post_applied" value="<jsp:getProperty name="ApplicationFormBean" property="post_applied"/>"/>
        <input type="hidden" id="post_selected_name" name="post_selected_name" value="<jsp:getProperty name="ApplicationFormBean" property="post_selected_name"/>"/>
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
          <%-- <input type="hidden" id="affected_category_names" name="affected_category_names" value="<jsp:getProperty name="ApplicationFormBean" property="affected_category_names"/>"/> --%>
          <input type="hidden" id="marrital_status" name="marrital_status" value="<jsp:getProperty name="ApplicationFormBean" property="marrital_status"/>"/>
		<input type="hidden" id="nationality" name="nationality" value="<jsp:getProperty name="ApplicationFormBean" property="nationality"/>"/>
		<input type="hidden" id="aadharNo" name="aadharNo" value="<jsp:getProperty name="ApplicationFormBean" property="aadharNo"/>"/>
		<input type="hidden" id="identity_type" name="identity_type" value="<jsp:getProperty name="ApplicationFormBean" property="identity_type"/>"/>
		
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
          <input type="hidden" id="edu_year_1" name="edu_year_1" value="<jsp:getProperty name="ApplicationFormBean" property="edu_year_1"/>"/>
          
          <input type="hidden" id="exam_passed_2" name="exam_passed_2" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_2"/>"/>
          <input type="hidden" id="stream_2" name="stream_2" value="<jsp:getProperty name="ApplicationFormBean" property="stream_2"/>"/>
          <input type="hidden" id="edu_marks_2" name="edu_marks_2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_2"/>"/>
           <input type="hidden" id="university_2" name="university_2" value="<jsp:getProperty name="ApplicationFormBean" property="university_2"/>"/>
          <input type="hidden" id="edu_rollno_2" name="edu_rollno_2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_2"/>"/>
          <input type="hidden" id="edu_certno_2" name="edu_certno_2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_2"/>"/>
          <input type="hidden" id="edu_date_issue_2" name="edu_date_issue_2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_2"/>"/>
          <input type="hidden" id="edu_year_2" name="edu_year_2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_year_2"/>"/>
          
          <input type="hidden" id="exam_passed_3" name="exam_passed_3" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_3"/>"/>
          <input type="hidden" id="stream_3" name="stream_3" value="<jsp:getProperty name="ApplicationFormBean" property="stream_3"/>"/>
          <input type="hidden" id="edu_marks_3" name="edu_marks_3" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_3"/>"/>
           <input type="hidden" id="university_3" name="university_3" value="<jsp:getProperty name="ApplicationFormBean" property="university_3"/>"/>
          <input type="hidden" id="edu_rollno_3" name="edu_rollno_3" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_3"/>"/>
          <input type="hidden" id="edu_certno_3" name="edu_certno_3" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_3"/>"/>
          <input type="hidden" id="edu_date_issue_3" name="edu_date_issue_3" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_3"/>"/>
          <input type="hidden" id="edu_year_3" name="edu_year_3" value="<jsp:getProperty name="ApplicationFormBean" property="edu_year_3"/>"/>
          
          <input type="hidden" id="exam_passed_4" name="exam_passed_4" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_4"/>"/>
          <input type="hidden" id="stream_4" name="stream_4" value="<jsp:getProperty name="ApplicationFormBean" property="stream_4"/>"/>
          <input type="hidden" id="edu_marks_4" name="edu_marks_4" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_4"/>"/>
           <input type="hidden" id="university_4" name="university_4" value="<jsp:getProperty name="ApplicationFormBean" property="university_4"/>"/>
          <input type="hidden" id="edu_rollno_4" name="edu_rollno_4" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_4"/>"/>
          <input type="hidden" id="edu_certno_4" name="edu_certno_4" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_4"/>"/>
          <input type="hidden" id="edu_date_issue_4" name="edu_date_issue_4" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_4"/>"/>
          <input type="hidden" id="edu_year_4" name="edu_year_4" value="<jsp:getProperty name="ApplicationFormBean" property="edu_year_4"/>"/>
          
          <input type="hidden" id="exam_passed_plus2" name="exam_passed_plus2" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_plus2"/>"/>
          <input type="hidden" id="stream_plus2" name="stream_plus2" value="<jsp:getProperty name="ApplicationFormBean" property="stream_plus2"/>"/>
          <input type="hidden" id="edu_marks_plus2" name="edu_marks_plus2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_plus2"/>"/>
           <input type="hidden" id="university_plus2" name="university_plus2" value="<jsp:getProperty name="ApplicationFormBean" property="university_plus2"/>"/>
          <input type="hidden" id="edu_rollno_plus2" name="edu_rollno_plus2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_plus2"/>"/>
          <input type="hidden" id="edu_certno_plus2" name="edu_certno_plus2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_plus2"/>"/>
          <input type="hidden" id="edu_date_issue_plus2" name="edu_date_issue_plus2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_plus2"/>"/>
          <input type="hidden" id="edu_year_plus2" name="edu_year_plus2" value="<jsp:getProperty name="ApplicationFormBean" property="edu_year_plus2"/>"/>
          
           <input type="hidden" id="exam_passed_5" name="exam_passed_5" value="<jsp:getProperty name="ApplicationFormBean" property="exam_passed_5"/>"/>
          <input type="hidden" id="stream_5" name="stream_5" value="<jsp:getProperty name="ApplicationFormBean" property="stream_5"/>"/>
          <input type="hidden" id="edu_marks_5" name="edu_marks_5" value="<jsp:getProperty name="ApplicationFormBean" property="edu_marks_5"/>"/>
           <input type="hidden" id="university_5" name="university_5" value="<jsp:getProperty name="ApplicationFormBean" property="university_5"/>"/>
          <input type="hidden" id="edu_rollno_5" name="edu_rollno_5" value="<jsp:getProperty name="ApplicationFormBean" property="edu_rollno_5"/>"/>
          <input type="hidden" id="edu_certno_5" name="edu_certno_5" value="<jsp:getProperty name="ApplicationFormBean" property="edu_certno_5"/>"/>
          <input type="hidden" id="edu_date_issue_5" name="edu_date_issue_5" value="<jsp:getProperty name="ApplicationFormBean" property="edu_date_issue_5"/>"/>
          <input type="hidden" id="edu_year_5" name="edu_year_5" value="<jsp:getProperty name="ApplicationFormBean" property="edu_year_5"/>"/>
          
          
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
		
		
		
		
		
		<input type="hidden" name="skill_1" value="<jsp:getProperty name="ApplicationFormBean" property="skill_1"/>"/>
		<input type="hidden" name="skill_2" value="<jsp:getProperty name="ApplicationFormBean" property="skill_2"/>"/>
		<input type="hidden" name="skill_3" value="<jsp:getProperty name="ApplicationFormBean" property="skill_3"/>"/>
		<input type="hidden" name="skill_4" value="<jsp:getProperty name="ApplicationFormBean" property="skill_4"/>"/>
		<input type="hidden" name="skill_5" value="<jsp:getProperty name="ApplicationFormBean" property="skill_5"/>"/>
		<input type="hidden" name="skill_6" value="<jsp:getProperty name="ApplicationFormBean" property="skill_6"/>"/>
		<input type="hidden" name="skill_7" value="<jsp:getProperty name="ApplicationFormBean" property="skill_7"/>"/>
		<input type="hidden" name="skill_8" value="<jsp:getProperty name="ApplicationFormBean" property="skill_8"/>"/>
		<input type="hidden" name="skill_9" value="<jsp:getProperty name="ApplicationFormBean" property="skill_9"/>"/>
		<input type="hidden" name="skills_flag" value="<jsp:getProperty name="ApplicationFormBean" property="skills_flag"/>"/>
		
		
		<input type="hidden"  name="nursing_council" value="<jsp:getProperty name="ApplicationFormBean" property="nursing_council"/>"/>
		<input type="hidden"  name="draughtsmanship_exp" value="<jsp:getProperty name="ApplicationFormBean" property="draughtsmanship_exp"/>"/>
		<input type="hidden"  name="hospital_experience" value="<jsp:getProperty name="ApplicationFormBean" property="hospital_experience"/>"/>
		<input type="hidden"  name="tradesmen_certificate" value="<jsp:getProperty name="ApplicationFormBean" property="tradesmen_certificate"/>"/>
		<input type="hidden"  name="autocad_certificate" value="<jsp:getProperty name="ApplicationFormBean" property="autocad_certificate"/>"/>
		
		<input type="hidden"  name="nurse" value="<jsp:getProperty name="ApplicationFormBean" property="nurse"/>"/>
		<input type="hidden"  name="hospital" value="<jsp:getProperty name="ApplicationFormBean" property="hospital"/>"/>
		<input type="hidden"  name="trade" value="<jsp:getProperty name="ApplicationFormBean" property="trade"/>"/>
		<input type="hidden"  name="autocad" value="<jsp:getProperty name="ApplicationFormBean" property="autocad"/>"/>
		<input type="hidden"  name="draft" value="<jsp:getProperty name="ApplicationFormBean" property="draft"/>"/>
		

    <input type="hidden"  name="hcLabAsstCert" value="<jsp:getProperty name="ApplicationFormBean" property="hcLabAsstCert"/>"/>
    <input type="hidden"  name="hcLabAsstExp" value="<jsp:getProperty name="ApplicationFormBean" property="hcLabAsstExp"/>"/>
    <input type="hidden"  name="hcPhysioAsstCert" value="<jsp:getProperty name="ApplicationFormBean" property="hcPhysioAsstCert"/>"/>
    <input type="hidden"  name="hcPhysioAsstExp" value="<jsp:getProperty name="ApplicationFormBean" property="hcPhysioAsstExp"/>"/>
    <input type="hidden"  name="ctNursingCert" value="<jsp:getProperty name="ApplicationFormBean" property="ctNursingCert"/>"/>
    <input type="hidden"  name="ctNursingExp" value="<jsp:getProperty name="ApplicationFormBean" property="ctNursingExp"/>"/>

    <input type="hidden"  name="hcLabAsstCertValue" value="<jsp:getProperty name="ApplicationFormBean" property="hcLabAsstCertValue"/>"/>
    <input type="hidden"  name="hcLabAsstExpValue" value="<jsp:getProperty name="ApplicationFormBean" property="hcLabAsstExpValue"/>"/>
    <input type="hidden"  name="hcPhysioAsstCertValue" value="<jsp:getProperty name="ApplicationFormBean" property="hcPhysioAsstCertValue"/>"/>
    <input type="hidden"  name="hcPhysioAsstExpValue" value="<jsp:getProperty name="ApplicationFormBean" property="hcPhysioAsstExpValue"/>"/>
    <input type="hidden"  name="ctNursingCertValue" value="<jsp:getProperty name="ApplicationFormBean" property="ctNursingCertValue"/>"/>
    <input type="hidden"  name="ctNursingExpValue" value="<jsp:getProperty name="ApplicationFormBean" property="ctNursingExpValue"/>"/>


    
         </td>
          </tr>
          <tr>
            <td colspan="4" align="left" valign="middle">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4" align="left" valign="middle">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4" align="left" valign="middle"><table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#a0a0a0">
              <tr>
                <td ><div align="center" class="transpagestyle1">The Application Form submitted by you is <br />
                  PROVISIONALLY REGISTERED</div></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td colspan="4" align="left" valign="middle">&nbsp;</td>
          </tr>
          <tr>
            <td height="100" colspan="4" align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle1">Post Applied : <jsp:getProperty name="ApplicationFormBean" property="post_selected_name"/></div></td>
          </tr>
          <tr>
            <td height="90" colspan="4" align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle1">Please Note Down RegistrationID : <jsp:getProperty name="ApplicationFormBean" property="transactionid"/></div></td>
          </tr>
           <%if(applicationFormBean.isPayExempted()==false){ %>
           <tr>
              <td colspan="4" height="60"  align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle3">  Proceed to make Payment - Amount to be paid : <%=applicationFormBean.getFee_amount() %>.</div></td>
          </tr>
          <%} %>
          <tr>
            <td colspan="4" align="left" valign="middle" style="color:green; font-size:15px;"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
              <tr>
                <td><h2>DOCUMENTATION</h2></td>
              </tr>
              <tr>
                <td class="note">(Note: You have to produce original documents/certificates pertaining to age, education. Please make sure to Submit relevant Certificates at the time of Document Verification. Please refer Advertisement of Job Notification for the format of relevant Certificate) </td>
              </tr>
              <tr>
                <td  height="10" class="note"></td>
              </tr>
              <%if("General".equalsIgnoreCase(applicationFormBean.getCommunity())){}else{ %>
              <tr>
                <td class="note">(Note: You have Selected <%=applicationFormBean.getCommunity() %> Community, please make sure to Submit Community Certificate at the time of Document Verification. Please refer Advertisement of Job Notification for the format of relevant Certificate) </td>
              </tr>
              <tr>
                <td  height="10" class="note"></td>
              </tr>
              <%} %>
              <%if(applicationFormBean.isCategoty_belongs()){ %>
              <tr>
                <td class="note">(Note: You have Selected <%=applicationFormBean.getCategory() %> Category, please make sure to Submit Category Certificate at the time of Document Verification. Please refer Advertisement of Job Notification for the format of relevant Certificate) </td>
              </tr>
               <tr>
                <td height="10" class="note"></td>
              </tr>
              <%} %>
              
              <%if(applicationFormBean.isEx_serviceman()){ %>
              <tr>
                <td class="note">(Note: You have Selected Ex-serviceman is Yes , please make sure to Submit NOC/Discharge Certificate at the time of Document Verification. Please refer Advertisement of Job Notification for the format of relevant Certificate) </td>
              </tr>
               <tr>
                <td height="10" class="note"></td>
              </tr>
              <%} %>
              <%if(applicationFormBean.isGovt_service()){ %>
              <tr>
                <td class="note">(Note: You have Selected Government Service is Yes , please make sure to Submit relevant Certificate at the time of Document Verification. Please refer Advertisement of Job Notification for the format of relevant Certificate) </td>
              </tr>
               <tr>
                <td height="10" class="note"></td>
              </tr>
              <%} %>
              <%if(applicationFormBean.isEmployee_ssb()){ %>
              <tr>
                <td class="note">(Note: You have Selected Employed In SSB is Yes , please make sure to Submit relevant Certificate at the time of Document Verification. Please refer Advertisement of Job Notification for the format of relevant Certificate) </td>
              </tr>
               <tr>
                <td height="10" class="note"></td>
              </tr>
              <%} %>
              
            </table></td>
          </tr>
          <tr>
            <td colspan="4" align="left" valign="middle">
              <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
 <%if(applicationFormBean.isPayExempted()){ %>
  <tr>
    <td><div class="buttonWrapper" style="margin:20px 0px 0px 0px;"> 
                        <input type="button" class="nextbutton appFormBtmRight" value="Print Acknowledgemnent" onClick="acknoweledgementView()" style="margin:0px 16px 10px 24px;width:290px;">
                        
                      </div></td>
  </tr>
  <%}else{ %>
  <tr>
    <td><div class="buttonWrapper" style="margin:20px 0px 0px 0px;"> 
     <input type="hidden" name="EncryptTrans" value="<%=request.getAttribute("EncryptTrans")%>">
									<input type="hidden" name="merchIdVal" value="1000420" />
			<input type="hidden" id="encRequest" name="encRequest" value="<%= request.getAttribute("encRequest") %>">
		<input type="hidden" name="access_code" id="access_code" value="<%= request.getAttribute("accessCode") %>">
								
                        <!-- <input type="button" class="nextbutton appFormBtmleft" value="Print Acknowledgemnent" onClick="acknoweledgementView()" style="margin:0px 16px 10px 24px;width:290px;"> -->
                        <!-- <input name="formBack0" type="button" class="nextbutton appFormBtmRight" value="Pay Online (Option-1)" alt="Next step" style="width:200px; margin:0px 20px 0px 0px;" onClick="hdfcPayment()"> -->
                        <input name="formBack0" type="button" class="nextbutton appFormBtmRight" value="Pay Online" alt="Next step" style="width:211px; margin:0px 20px 0px 0px;" onClick="sbiPayment()" >
                        
                        
                      </div></td>
  </tr>
  <%} %>
</table>

            </td>
          </tr>
        </table>
        </form>
      </div>
    </div>
    <!--Content div ends here-->

  </div>
  <!--Outter div ends here-->
</div>
<!--Wrapper div ends here-->
</div>
</div>
</div>

<jsp:include page="footer.jsp" flush="true" />

</body>
</html>
