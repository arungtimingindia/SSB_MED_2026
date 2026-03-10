<%--This the Preview page after candidate fill their all forms --%>

<%@ page import="com.ttil.bean.ApplicationFormBean"%>
<%@ page import="java.util.List"%>
<%@ page import="org.owasp.html.Sanitizers"%>
<%@ page import="org.owasp.html.PolicyFactory"%>
<%@ page import="org.owasp.esapi.ESAPI" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="shortcut icon" href="images/favicon.jpg" />
<title>welcome to ssb online application</title>
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script> -->
<style type="text/css">

</style>
<script type="text/javascript">
	function validation() {
		 var agree_save = document.applicationView.agree_save.checked;
		 var agree_save1 = document.applicationView.agree_save1.checked;
		if (agree_save == true && agree_save1 == true) {
			var r=confirm("Have you verified the details?");
			if (r==true)
			  {
				var s=confirm("Are you sure, do you want to submit the details?");
				if (s==true)
				  {
					 return true;
				  }else{
					  return false; 
				  }
			  }
			else
			  {
				 alert("Kindly verify the details. Once submitted cannot be edited.");
				 return false; 
			  } 
		} else {
			alert("Please check declarations to continue");
			 return false;
		} 
		 return false;
	}
	
	/* $("#complexConfirm").confirm({
        title:"Cancel Confirmation",
        text: "Are you sure, Do you want to Cancel This  Pass Application ",
        confirm: function(button) {
          //  button.fadeOut(2000).fadeIn(2000);
           // alert("You just confirmed.");
        	$( "#passForm" ).submit();
        },
        cancel: function(button) {
           // button.fadeOut(2000).fadeIn(2000);
            //alert("You aborted the operation.");
        },
        confirmButton: "Yes",
        cancelButton: "No"
    }); */
	
	function validation1() {
			var r=confirm("Have you verified the details?");
			if (r==true)
			  {
				var s=confirm("Are you sure, do you want to submit the details?");
				if (s==true)
				  {
					 return true;
				  }else{
					  return false; 
				  }
			  }
			else
			  {
				 alert("Kindly verify the details. Once submitted cannot be edited.");
				 return false; 
			  } 
		 return false;
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
      <form name="applicationView" id="applicationView" method="post" action="applicationSave">
      <jsp:useBean id="ApplicationFormBean" scope="session"
					class="com.ttil.bean.ApplicationFormBean" />
					<input type="hidden" name="requestFrom" value="apllicationpreview" />
					<%
                      ApplicationFormBean applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
        			 %>
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="padding:30px 0px 0px 0px;">
          
            
          <tr>
            <td colspan="4" align="center" valign="middle" class="bdr"><h2>Preview &amp; Confirmation</h2></td>
          </tr>
          <tr>
            <td colspan="4" align="center" valign="middle"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0" class="marg">
              <%
                     if(applicationFormBean.getMessage()!=null && !"".equalsIgnoreCase(applicationFormBean.getMessage()))
                     {
                     %>
						<tr>
							<td colspan="2"
								class="center rightbodernoneclass colorText"><b><jsp:getProperty
										name="ApplicationFormBean" property="message" /></b></td>
						</tr>
						<%} %>

						<%
                     if(applicationFormBean.getMessage1()!=null && !"".equalsIgnoreCase(applicationFormBean.getMessage1()))
                     {
                     %>
						<tr>
							<td colspan="2" 
								class="center rightbodernoneclass colorText"><b><jsp:getProperty
										name="ApplicationFormBean" property="message1" /></b></td>
						</tr>
						<%} %>

						<%
				    List<String> messageOb = (List)request.getAttribute("messageOb");
					if(messageOb!=null && messageOb.size()>=1)
					{%>
						<tr>
							<td colspan="2" class="rightbodernoneclass colorText"><b>Please
									correct the below inputs to submit the details</b></td>
						</tr>
						<%
					for(int i=0;i<messageOb.size();i++)
					{	
				    %>
						<tr>
							<td colspan="2" class="rightbodernoneclass colorText"><b><%=messageOb.get(i)%></b></td>
						</tr>
						<%
						}}
						%>
						<tr>
							<td class="tdborderNone colorTextForTD" colspan="2"><b>Please
									verify the details of the application form filled in by you. </b></td>
						</tr>
						<tr>
							<td class="tdborderNone colorTextForTD" colspan="2"><b><i>Note:
										You can click the button named 'Edit Details' to edit the
										details filled in by you.</i></b></td>
						</tr>
						</table>
					</td>
			</tr>
						
											
             <tr>
				<td class="bdr"  colspan="2"><h4>Personal Details</h4></td>
			</tr>
			<tr>
				<td colspan="2"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0"> 
				
            <tr>
                <td width="39%"><label class="label1" style="font-size:20px">Post Applied For : </label></td>
                <td width="61%"><label style="font-size:20px"><jsp:getProperty name="ApplicationFormBean" property="post_selected_name" /></label></td>
              </tr>
              
              <tr>
                <td width="39%"><label class="label1">Name : </label></td>
                <td width="61%"><label><jsp:getProperty name="ApplicationFormBean" property="first_name" /> <jsp:getProperty name="ApplicationFormBean" property="middle_name" /> <jsp:getProperty name="ApplicationFormBean" property="last_name" /></label></td>
              </tr>
             <%--  <tr>
                <td><label class="label1">Middle Name : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="middle_name" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Surname : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="last_name" /></label></td>
              </tr> --%>
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
                <td><label class="label1">Whether affected in 1984 riots or communal riots of 2002 Gujarat   : </label></td>
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
              
             <%--  <tr>
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
              <%} %> --%>
              
            
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
                       <!-- <td><label class="label1">Award or Decoration</label></td> -->
                       <td><label class="label1">Reasons for release/Discharge</label></td>
                       <td><label class="label1">Education Qualification</label></td>
                      </tr>
                      <tr>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_enrollment_date" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_retirement_date" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_med_cat" /></label></td>
                        <%-- <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_awd_dec" /></label></td> --%>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_discharge_reason" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="exman_edu_qual" /></label></td>
                      </tr>  
                     </tbody>
                   </table>
                </td>
              </tr>
              <%} %>
              <tr>
                <td><label class="label1">Whether Departmental Candidates with three years continuous service in Central Government : </label></td>
                <td><label><% if(applicationFormBean.isEmployee_ssb()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%--  <tr>
                <td><label class="label1">Whether in Government Service : </label></td>
                <td><label><% if(applicationFormBean.isGovt_service()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr> --%>
              <% if(applicationFormBean.isEmployee_ssb()){ %> 
               <tr>
                <td colspan="2">
                   <table width="100%" cellspacing="0" cellpadding="5" border="0" align="center" class="border1">
                     <tbody>
                     <tr>
                       <td><label class="label1">Name of Organization</label></td>
                       <td><label class="label1">Date Since When</label></td>
                       <td><label class="label1">Post held</label></td>
                       <td><label class="label1">Issuing Authority (NOC)</label></td>
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
              
               <tr>
                <td><label class="label1">Whether in Government Service : </label></td>
                <td><label><% if(applicationFormBean.isGovt_service()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%--  <tr>
                <td><label class="label1">Whether in Government Service : </label></td>
                <td><label><% if(applicationFormBean.isGovt_service()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr> --%>
              <% if(applicationFormBean.isGovt_service()){ %> 
               <tr>
                <td colspan="2">
                   <table width="100%" cellspacing="0" cellpadding="5" border="0" align="center" class="border1">
                     <tbody>
                     <tr>
                       <td><label class="label1">Name of Organization</label></td>
                       <td><label class="label1">Date Since When</label></td>
                       <td><label class="label1">Post held</label></td>
                       <td><label class="label1">Issuing Authority (NOC)</label></td>
                      </tr>
                      <tr>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="present_employer2" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="emp_date_since2" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="post_held2" /></label></td>
                        <td><label><jsp:getProperty name="ApplicationFormBean" property="nocdesignation2" /></label></td>
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
                <td ><label class="label1">Identity Card Type : </label></td>
                <td><label><jsp:getProperty name="ApplicationFormBean" property="identity_type" /></label></td>
              </tr>
		      <tr>
                <td  width="39%"><label class="label1">Identity Card No : </label></td>
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
              
              
              <tr>
                <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                  
                 <tr>
                    <td width="10%" class="border1"><label class="label1">Exam Passed</label></td>
                    <td width="20%" class="border1"><label class="label1">School/ University/ Board/ Institute</label></td>
                    <td width="7%" class="border1"><label class="label1">Year of Exam</label></td>
                    <td width="10%" class="border1"><label class="label1">Roll No</label></td>
                    <td width="10%" class="border1"><label class="label1">Certificate No</label></td>
                    <td width="10%" class="border1"><label class="label1">Date Of Issued</label></td>
                    <td width="17%" class="border1"><label class="label1">Subject</label></td>
                    <td width="13%" class="border1"><label class="label1">Aggregate Percentage of Marks/ Grading</label></td>
                  </tr>
                  <% 
                  String exam_passed_1=applicationFormBean.getExam_passed_1();
                  String stream_1=applicationFormBean.getStream_1();
                  String university_1=applicationFormBean.getUniversity_1();
                  String edu_rollno_1=applicationFormBean.getEdu_rollno_1();
                  String edu_certno_1=applicationFormBean.getEdu_certno_1();
                  String edu_date_issue_1=applicationFormBean.getEdu_date_issue_1();
                  String edu_year_1=applicationFormBean.getEdu_year_1();
                  
                  String exam_passed_2=applicationFormBean.getExam_passed_2();
                  String stream_2=applicationFormBean.getStream_2();
                  String university_2=applicationFormBean.getUniversity_2();
                  String edu_rollno_2=applicationFormBean.getEdu_rollno_2();
                  String edu_certno_2=applicationFormBean.getEdu_certno_2();
                  String edu_date_issue_2=applicationFormBean.getEdu_date_issue_2();
                  String edu_year_2=applicationFormBean.getEdu_year_2();
                  
                  String edu_marks_1=applicationFormBean.getEdu_marks_1();
                  String edu_marks_2=applicationFormBean.getEdu_marks_2();
                  
                  String exam_passed_3=applicationFormBean.getExam_passed_3();
                  String stream_3=applicationFormBean.getStream_3();
                  String university_3=applicationFormBean.getUniversity_3();
                  String edu_rollno_3=applicationFormBean.getEdu_rollno_3();
                  String edu_certno_3=applicationFormBean.getEdu_certno_3();
                  String edu_date_issue_3=applicationFormBean.getEdu_date_issue_3();
                  String edu_year_3=applicationFormBean.getEdu_year_3();
                  String edu_marks_3=applicationFormBean.getEdu_marks_3();
                  
                  String exam_passed_4=applicationFormBean.getExam_passed_4();
                  String stream_4=applicationFormBean.getStream_4();
                  String university_4=applicationFormBean.getUniversity_4();
                  String edu_rollno_4=applicationFormBean.getEdu_rollno_4();
                  String edu_certno_4=applicationFormBean.getEdu_certno_4();
                  String edu_date_issue_4=applicationFormBean.getEdu_date_issue_4();
                  String edu_year_4=applicationFormBean.getEdu_year_4();
                  String edu_marks_4=applicationFormBean.getEdu_marks_4();
                  
                  String exam_passed_plus2=applicationFormBean.getExam_passed_plus2();
                  String stream_plus2=applicationFormBean.getStream_plus2();
                  String university_plus2=applicationFormBean.getUniversity_plus2();
                  String edu_rollno_plus2=applicationFormBean.getEdu_rollno_plus2();
                  String edu_certno_plus2=applicationFormBean.getEdu_certno_plus2();
                  String edu_date_issue_plus2=applicationFormBean.getEdu_date_issue_plus2();
                  String edu_year_plus2=applicationFormBean.getEdu_year_plus2();
                  String edu_marks_plus2=applicationFormBean.getEdu_marks_plus2();
                  
                  String exam_passed_5=applicationFormBean.getExam_passed_5();
                  String stream_5=applicationFormBean.getStream_5();
                  String university_5=applicationFormBean.getUniversity_5();
                  String edu_rollno_5=applicationFormBean.getEdu_rollno_5();
                  String edu_certno_5=applicationFormBean.getEdu_certno_5();
                  String edu_date_issue_5=applicationFormBean.getEdu_date_issue_5();
                  String edu_year_5=applicationFormBean.getEdu_year_5();
                  String edu_marks_5=applicationFormBean.getEdu_marks_5();
                 
                    
                  boolean edu_qual_1=true,edu_qual_2=true,edu_qual_3=true,edu_qual_4=true,edu_qual_plus2=true,edu_qual_5=true,edu_qual_7=true,edu_qual_8=true;
                  if(exam_passed_1==null || stream_1==null || university_1==null || edu_rollno_1==null || edu_certno_1==null || edu_date_issue_1==null || edu_marks_1==null || edu_year_1==null || 
                     	 "".equalsIgnoreCase(exam_passed_1) || "".equalsIgnoreCase(stream_1) || "".equalsIgnoreCase(university_1) || "".equalsIgnoreCase(edu_rollno_1) || "".equalsIgnoreCase(edu_certno_1) || "".equalsIgnoreCase(edu_date_issue_1) || "".equalsIgnoreCase(edu_marks_1)  || "".equalsIgnoreCase(edu_year_1)
                     	  || "null".equalsIgnoreCase(exam_passed_1) || "null".equalsIgnoreCase(stream_1) || "null".equalsIgnoreCase(university_1) || "null".equalsIgnoreCase(edu_rollno_1) || "null".equalsIgnoreCase(edu_certno_1) || "null".equalsIgnoreCase(edu_date_issue_1) || "null".equalsIgnoreCase(edu_marks_1)  || "null".equalsIgnoreCase(edu_year_1)){
                     	 edu_qual_1=false;
                      }
                      if(exam_passed_2==null || stream_2==null || university_2==null || edu_rollno_2==null || edu_certno_2==null || edu_date_issue_2==null || edu_marks_2==null || edu_year_2==null ||
                     		 "".equalsIgnoreCase(exam_passed_2) || "".equalsIgnoreCase(stream_2) || "".equalsIgnoreCase(university_2) || "".equalsIgnoreCase(edu_rollno_2) || "".equalsIgnoreCase(edu_certno_2) || "".equalsIgnoreCase(edu_date_issue_2) || "".equalsIgnoreCase(edu_marks_2)  || "".equalsIgnoreCase(edu_year_2)
                     		 || "null".equalsIgnoreCase(exam_passed_2) || "null".equalsIgnoreCase(stream_2) || "null".equalsIgnoreCase(university_2) || "null".equalsIgnoreCase(edu_rollno_2) || "null".equalsIgnoreCase(edu_certno_2) || "null".equalsIgnoreCase(edu_date_issue_2) || "null".equalsIgnoreCase(edu_marks_2) || "null".equalsIgnoreCase(edu_year_2)){
                     	 edu_qual_2=false;
                      }
                      
                      if(exam_passed_3==null || stream_3==null || university_3==null || edu_rollno_3==null || edu_certno_3==null || edu_date_issue_3==null || edu_marks_3==null || edu_year_3==null ||
                      		 "".equalsIgnoreCase(exam_passed_3) || "".equalsIgnoreCase(stream_3) || "".equalsIgnoreCase(university_3) || "".equalsIgnoreCase(edu_rollno_3) || "".equalsIgnoreCase(edu_certno_3) || "".equalsIgnoreCase(edu_date_issue_3) || "".equalsIgnoreCase(edu_marks_3)  || "".equalsIgnoreCase(edu_year_3)
                      		 || "null".equalsIgnoreCase(exam_passed_3) || "null".equalsIgnoreCase(stream_3) || "null".equalsIgnoreCase(university_3) || "null".equalsIgnoreCase(edu_rollno_3) || "null".equalsIgnoreCase(edu_certno_3) || "null".equalsIgnoreCase(edu_date_issue_3) || "null".equalsIgnoreCase(edu_marks_3) || "null".equalsIgnoreCase(edu_year_3)){
                      	 edu_qual_3=false;
                       }
                      
                      if(exam_passed_4==null || stream_4==null || university_4==null || edu_rollno_4==null || edu_certno_4==null || edu_date_issue_4==null || edu_marks_4==null || edu_year_4==null ||
                      		 "".equalsIgnoreCase(exam_passed_4) || "".equalsIgnoreCase(stream_4) || "".equalsIgnoreCase(university_4) || "".equalsIgnoreCase(edu_rollno_4) || "".equalsIgnoreCase(edu_certno_4) || "".equalsIgnoreCase(edu_date_issue_4) || "".equalsIgnoreCase(edu_marks_4)  || "".equalsIgnoreCase(edu_year_4)
                      		 || "null".equalsIgnoreCase(exam_passed_4) || "null".equalsIgnoreCase(stream_4) || "null".equalsIgnoreCase(university_4) || "null".equalsIgnoreCase(edu_rollno_4) || "null".equalsIgnoreCase(edu_certno_4) || "null".equalsIgnoreCase(edu_date_issue_4) || "null".equalsIgnoreCase(edu_marks_4) || "null".equalsIgnoreCase(edu_year_4)){
                      	 edu_qual_4=false;
                       }
                      
                      if(exam_passed_5==null || stream_5==null || university_5==null || edu_rollno_5==null || edu_certno_5==null || edu_date_issue_5==null || edu_marks_5==null || edu_year_5==null ||
                        		 "".equalsIgnoreCase(exam_passed_5) || "".equalsIgnoreCase(stream_5) || "".equalsIgnoreCase(university_5) || "".equalsIgnoreCase(edu_rollno_5) || "".equalsIgnoreCase(edu_certno_5) || "".equalsIgnoreCase(edu_date_issue_5) || "".equalsIgnoreCase(edu_marks_5)  || "".equalsIgnoreCase(edu_year_5)
                        		 || "null".equalsIgnoreCase(exam_passed_5) || "null".equalsIgnoreCase(stream_5) || "null".equalsIgnoreCase(university_5) || "null".equalsIgnoreCase(edu_rollno_5) || "null".equalsIgnoreCase(edu_certno_5) || "null".equalsIgnoreCase(edu_date_issue_5) || "null".equalsIgnoreCase(edu_marks_5) || "null".equalsIgnoreCase(edu_year_5)){
                        	 edu_qual_5=false;
                         }
                      
                      if(exam_passed_plus2==null || stream_plus2==null || university_plus2==null || edu_rollno_plus2==null || edu_certno_plus2==null || edu_date_issue_plus2==null || edu_marks_plus2==null || edu_year_plus2==null ||
                       		 "".equalsIgnoreCase(exam_passed_plus2) || "".equalsIgnoreCase(stream_plus2) || "".equalsIgnoreCase(university_plus2) || "".equalsIgnoreCase(edu_rollno_plus2) || "".equalsIgnoreCase(edu_certno_plus2) || "".equalsIgnoreCase(edu_date_issue_plus2) || "".equalsIgnoreCase(edu_marks_plus2)  || "".equalsIgnoreCase(edu_year_plus2)
                       		 || "null".equalsIgnoreCase(exam_passed_plus2) || "null".equalsIgnoreCase(stream_plus2) || "null".equalsIgnoreCase(university_plus2) || "null".equalsIgnoreCase(edu_rollno_plus2) || "null".equalsIgnoreCase(edu_certno_plus2) || "null".equalsIgnoreCase(edu_date_issue_plus2) || "null".equalsIgnoreCase(edu_marks_plus2) || "null".equalsIgnoreCase(edu_year_plus2)){
                       	 edu_qual_plus2=false;
                        }
                   
                     %>
                    <%if(edu_qual_1){ %>
                  <tr>
                   <td class="border1"><label class="label2"><%=exam_passed_1 %></label></td>
                    <td class="border1"><label class="label2"><%=university_1 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_year_1 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_rollno_1 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_certno_1 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_date_issue_1 %></label></td>
                     <td class="border1"><label class="label2"><%=stream_1 %></label></td>
                      <td class="border1"><label class="label2"><%=edu_marks_1 %></label></td>
                  </tr>
                   <%}if(edu_qual_plus2){  %>
                  <tr>
                    <td class="border1"><label class="label2"><%=exam_passed_plus2 %></label></td>
                    <td class="border1"><label class="label2"><%=university_plus2 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_year_plus2 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_rollno_plus2 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_certno_plus2 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_date_issue_plus2 %></label></td>
                     <td class="border1"><label class="label2"><%=stream_plus2 %></label></td>
                     <td class="border1"><label class="label2"><%=edu_marks_plus2 %></label></td>
                  </tr>
                  <%}if(edu_qual_2){  %>
                  <tr>
                    <td class="border1"><label class="label2"><%=exam_passed_2 %></label></td>
                    <td class="border1"><label class="label2"><%=university_2 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_year_2 %></label></td>
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
                    <td class="border1"><label class="label2"><%=edu_year_3 %></label></td>
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
                    <td class="border1"><label class="label2"><%=edu_year_4 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_rollno_4 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_certno_4 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_date_issue_4 %></label></td>
                     <td class="border1"><label class="label2"><%=stream_4 %></label></td>
                     <td class="border1"><label class="label2"><%=edu_marks_4 %></label></td>
                  </tr>
                  <%}if(edu_qual_5){  %>
                  <tr>
                    <td class="border1"><label class="label2"><%=exam_passed_5 %></label></td>
                    <td class="border1"><label class="label2"><%=university_5 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_year_5 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_rollno_5 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_certno_5 %></label></td>
                    <td class="border1"><label class="label2"><%=edu_date_issue_5 %></label></td>
                     <td class="border1"><label class="label2"><%=stream_5 %></label></td>
                     <td class="border1"><label class="label2"><%=edu_marks_5 %></label></td>
                  </tr>
                  <%}  %>
                </table></td>
              </tr>
              
              <% if(applicationFormBean.isSkills_flag()){ %>
              <tr>
                <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                 
                  <tr>
				<td class="bdr" colspan="2"><h4>Other Skills</h4></td>
			</tr> 
                 <tr>
                    <td width="11%" class="border1"><label class="label1">Skill-1</label></td>
                    <td width="11%" class="border1"><label class="label1">Skill-2</label></td>
                    <td width="11%" class="border1"><label class="label1">Skill-3</label></td>
                    <td width="11%" class="border1"><label class="label1">Skill-4</label></td>
                    <td width="11%" class="border1"><label class="label1">Skill-5</label></td>
                    <td width="11%" class="border1"><label class="label1">Skill-6</label></td>
                    <td width="11%" class="border1"><label class="label1">Skill-7</label></td>
                    <td width="11%" class="border1"><label class="label1">Skill-8</label></td>
                    <td width="11%" class="border1"><label class="label1">Skill-9</label></td>
                  </tr>
                  
                  <tr>
                    <td class="border1"><label class="label2"><%=applicationFormBean.getSkill_1() %></label></td>
                    <td class="border1"><label class="label2"><%=applicationFormBean.getSkill_2() %></label></td>
                    <td class="border1"><label class="label2"><%=applicationFormBean.getSkill_3() %></label></td>
                    <td class="border1"><label class="label2"><%=applicationFormBean.getSkill_4() %></label></td>
                    <td class="border1"><label class="label2"><%=applicationFormBean.getSkill_5() %></label></td>
                    <td class="border1"><label class="label2"><%=applicationFormBean.getSkill_6() %></label></td>
                    <td class="border1"><label class="label2"><%=applicationFormBean.getSkill_7() %></label></td>
                    <td class="border1"><label class="label2"><%=applicationFormBean.getSkill_8() %></label></td>
                    <td class="border1"><label class="label2"><%=applicationFormBean.getSkill_9() %></label></td>
                  </tr>
                
                 </table>
                </td>
              </tr>
              <%} %>    
           </table>
           </td>
           </tr>
              
           <tr>
				<td class="bdr" colspan="2"><h4>ESSENTIAL EDUCATIONAL &amp; PROFESSIONAL QUALIFICATIONS</h4></td>
			</tr>
			<tr>
				<td colspan="2"><table width="75%" border="0" align="left" cellpadding="5" cellspacing="0">   

            <% if(applicationFormBean.getHcLabAsstCertValue()==null)  {%>
               <tr>
                <td><label class="label1">Whether have Certificate course of a duration of minimum one year in Laboratory Assistant Course from a recognized institution</label></td>
                <td><label><% if(applicationFormBean.isHcLabAsstCert()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                 
              </tr>
              
               <%} %>
              
               <% if(applicationFormBean.getHcLabAsstExpValue()==null)  {%>
              
              <tr>
                <td><label class="label1">Whether have Working experience of duration of minimum One year as Lab Assistant in Laboratory Diagnostic Centre or hospital or institution lab recognized by the Central Government or State Government </label></td>
                <td><label><% if(applicationFormBean.isHcLabAsstExp()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                 
              </tr>
               <%} %>
               
                 <% if(applicationFormBean.getHcPhysioAsstCertValue()==null)  {%>
               <tr>
                <td><label class="label1">Whether have  Certificate course of duration of minimum one year in Physiotherapy from a recognized institute </label></td>
                <td><label><% if(applicationFormBean.isHcPhysioAsstCert()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                 
              </tr>
              
               <%} %>
               
                <% if(applicationFormBean.getHcPhysioAsstExpValue()==null)  {%>
              
              <tr>
                <td><label class="label1">Whether have Experience of duration of minimum one year as Physiotherapy Assistant from a Physiotherapy Centre or minimum hundred bedded hospital or institute recognised by the Central Government or State Government </label></td>
                <td><label><% if(applicationFormBean.isHcPhysioAsstExp()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                 
              </tr>
               <%} %>
               
               
                 <% if(applicationFormBean.getCtNursingCertValue()==null)  {%>
               <tr>
                <td><label class="label1"> Whether have  First Aid certificate course from St. John’s Ambulance Organization or Red Cross Society of India </label></td>
                <td><label><% if(applicationFormBean.isCtNursingCert()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                 
              </tr>
              
               <%} %>
               
                 <% if(applicationFormBean.getCtNursingExpValue()==null)  {%>
               <tr>
                <td><label class="label1"> Whether have Experience of duration of minimum one year as Nursing Assistant in a minimum fifty bedded Hospital or Institution recognised by the Central Government or State Governments. </label></td>
                <td><label><% if(applicationFormBean.isCtNursingExp()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                 
              </tr>
              
               <%} %>

               
              
              
              


			 <% if(applicationFormBean.getNurse()==null)  {%>
               <tr>
                <td><label class="label1">Whether Registered with Central nursing council or State nursing council as a General Nurse and Mid-wife :</label></td>
                <td><label><% if(applicationFormBean.isNursing_council()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%} %>
              
               <% if(applicationFormBean.getHospital()==null)  {%>
               <tr>
                <td><label class="label1">Whether has Two years Experience in a recognised Hospital :</label></td>
                <td><label><% if(applicationFormBean.isHospital_experience()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%} %>
              
               <% if(applicationFormBean.getTrade()==null)  {%>
               <tr>
                <td><label class="label1">Whether has Two years National Tradesmen certificate issued by a recognised Industrial Training Institute or equivalent recognised institution :</label></td>
                <td><label><% if(applicationFormBean.isTradesmen_certificate()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%} %>
              
              <% if(applicationFormBean.getAutocad()==null)  {%>
               <tr>
                <td><label class="label1">Whether has One year certificate course or one year experience in AUTOCAD from a Government Institution or a recognised institution :</label></td>
                <td><label><% if(applicationFormBean.isAutocad_certificate()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%} %>
            
           
            
            <% if(applicationFormBean.getDraft()==null)  {%>
               <tr>
                <td><label class="label1">Whether has one year experience in Draughtsmanship from a recognised Architect Consultancy Firm of Category 'B' and 'C' :</label></td>
                <td><label><% if(applicationFormBean.isDraughtsmanship_exp()){ %> Yes <% }else{ %> No
								<%} %></label></td>
              </tr>
              <%} %>
              </table>
              </td>
              </tr>
			
			<tr>
				<td colspan="2"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
              
                  <% if(applicationFormBean.getQualification1_text()!=null){ %>
                  <tr>
                    <td  width="2%" align="center" valign="top"><label style="font-weight:bold;"> i) </label></td>
                    <td width="71%"><label class="label1"><%=applicationFormBean.getQualification1_text() %></label></td>
                    <td><label> <%=applicationFormBean.getQualification1() %> </label></td>
                  </tr>
                  <%} %>
                   <% if(applicationFormBean.getQualification2_text()!=null){ %>
                  <tr>
                    <td  width="2%" align="center" valign="top"><label style="font-weight:bold;"> ii) </label></td>
                    <td width="71%"><label class="label1"><%=applicationFormBean.getQualification2_text() %></label></td>
                    <td><label> <%=applicationFormBean.getQualification2() %> </label></td>
                  </tr>
                  <%} %>
                   <% if(applicationFormBean.getQualification3_text()!=null){ %>
                  <tr>
                    <td  width="2%" align="center" valign="top"><label style="font-weight:bold;"> iii) </label></td>
                    <td width="71%"><label class="label1"><%=applicationFormBean.getQualification3_text() %></label></td>
                    <td><label> <%=applicationFormBean.getQualification3() %> </label></td>
                  </tr>
                  <%} %>
                   <% if(applicationFormBean.getQualification4_text()!=null){ %>
                  <tr>
                    <td width="2%" align="center" valign="top"><label style="font-weight:bold;"> iv) </label></td>
                    <td width="71%"><label class="label1"><%=applicationFormBean.getQualification4_text() %></label></td>
                    <td><label> <%=applicationFormBean.getQualification4() %> </label></td>
                  </tr>
                  <%} %>
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
                    <td><label><% if(applicationFormBean.isDebarment()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                 </table>
                </td>
               </tr>     
             <% if(applicationFormBean.isDebarment()){ %> 
             <tr>
                <td width="20%"><label class="label1">Exam Organizer : </label></td>
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
                    <td><label><% if(applicationFormBean.isFir_cases()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="center" valign="top"><label style="font-weight:bold;"> b) </label></td>
                    <td><label class="label1">Whether any criminal complaint case or FIR or criminal case(s) is pending 
                      against you in Court of Law, <br/>or with police at the time of submitting the
                      application form?</label></td>
                    <td><label><% if(applicationFormBean.isFir_cases_pending()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="center" valign="top"><label style="font-weight:bold;"> c) </label></td>
                    <td><label class="label1">Have you ever been arrested/detained in any criminal case(s)?</label></td>
                    <td><label><% if(applicationFormBean.isArrested()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="center" valign="top"><label style="font-weight:bold;"> d) </label></td>
                    <td><label class="label1">Have you ever been tried &amp; convicted or acquitted by a Court of Law in any criminal case(s)?</label></td>
                    <td><label><% if(applicationFormBean.isCriminal_case_acquitted()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="center" valign="top"><label style="font-weight:bold;"> e) </label></td>
                    <td><label class="label1">Have you ever been tried &amp; convicted by the Court by filling any bond for good behaviour etc.?</label></td>
                    <td><label><% if(applicationFormBean.isGood_behavior_bond()){ %> Yes <% }else{ %> No
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
                <td width="20%"><label class="label1">FIR No. : </label></td>
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
              <tr>
				<td class="bdr"  colspan="2"><h4>Declaration by the Candidate</h4></td>
			</tr>
			
               <tr>
                <td colspan="2"><table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
                  <tr>
                   <td align="left" valign="top" ><input type="checkbox" name="agree_save1" id="agree_save1" /></td>
                    <td align="left" valign="top"><label>
                    I have applied only for this post (<jsp:getProperty name="ApplicationFormBean" property="post_selected_name" />)  
                    </label></td>
                  </tr>
                  <tr>
                   <td align="left" valign="top" ><input type="checkbox" name="agree_save" id="agree_save" /></td>
                    <td align="left" valign="top"><label>
                    I hereby declare that the information given above and in the enclosed documents is true to the best of my knowledge and belief and nothing has been concealed therein. I am well aware of the fact that if the information given by me is proved not true, I will have to face the consequences as per the Law.  Also, all the benefits availed by me shall be summarily withdrawn.  
                    </label></td>
                  </tr>
                   <!-- <tr>
	                <td align="center" valign="top" colspan="2"><input type="checkbox" name="agree_save" id="agree_save" /><label style="padding-left:15px;"><strong>I Agree</strong></label></td>
	              </tr> -->
               </table></td>
              </tr>
              <tr>
                <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="5" class="bdrBottom">
             <tr>
                    <td colspan="3" align="center" valign="middle"><label><strong>Type the exact characters as shown in the image.</strong></label></td>
                  </tr>
              <tr>
                    <td width="40%" align="right" valign="middle"><img alt="" id="captcha" src="simpleCaptcha.png" width="150" /></td>
                    <td width="10%" align="left" valign="middle">
                    <input type="text" name="answer" maxlength="6"
							style="width: 100px;" autocomplete="off" oncut="return false;"
							oncopy="return false;" onpaste="return false;" class="text1" /></td>
                    <td width="40%" align="left" valign="middle"><label>Letters are not case sensitive</label></td>
                  </tr>
                </table></td>
                </tr>  
              <%
					String scripText="window.history.go(-"+applicationFormBean.getNoOfRequests()+")";
         %>
              <tr>
                <td colspan="2"><div class="buttonWrapper" style="margin:20px 0px 20px 0px;"> 
                      <input type="button" class="nextbutton appFormBtmleft" value="Edit Details" onClick="<%=scripText%>" >
                      <span class="buttonWrapper" style="margin:20px 0px 0px 0px;">
                      <input name="Confirm" type="submit" class="nextbutton appFormBtmRight" value="Submit Application" alt="Next step" style="width:200px;" id="complexConfirm" onClick="return validation();"/>
                       </span></div></td>
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
