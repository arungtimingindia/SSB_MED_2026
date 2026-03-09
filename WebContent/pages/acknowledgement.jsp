 <%--This page is to show the confiramation details After the Candidate Fill their Form  --%>>


<%@ page import="com.ttil.bean.AcknoweledgementBean"%>
<%@ page import="java.util.List"%>
<%@ page import="org.owasp.html.Sanitizers"%>
<%@ page import="org.owasp.html.PolicyFactory"%>
<%@ page import="org.owasp.esapi.ESAPI" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="shortcut icon" href="images/favicon.jpg" />
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <script src="js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" media="screen" />
 <link rel="stylesheet" href="css/styles.css">
 
<title>SSB Online</title>
<style type="text/css" media="print">
  @page { size: portrait;    }
</style>
<style type="text/css">
body{line-height: 0.8 !important;}
h1,h2,h3,h4,h5,h6 {
  margin-top:2px !important;
  margin-bottom:2px !important;
}
td 
{
  padding-top: 0px !important;
  padding-bottom: 0px !important;
}
/* form{
	background: url(images/logo_ssb.png);
	width: 100%;
}*/
@media print {
/*  body {transform: scale(1);}
    -webkit-transform: scale(0.5); 
             -moz-transform: scale(0.5);  
              -ms-transform: scale(0.5);  
               -o-transform: scale(0.5); */
               
form:before { content: url(images/ssb_400.png);
  position: absolute;
  opacity: 0.3;
 
  /* 
   width: 100%;
   height: 100%;
  */
  top:220px;
  left:150px;

  }

} 

.watermark{
    background:url("images/ssb_400.png") center center no-repeat;
  opacity: 0.3;
  position: absolute;
  width: 100%;
  height: 100%;
}
</style>

<style type="text/css">
  
 /*  @media print {    
    .watermark{
    background:url("images/ssb_watermark.png") center center no-repeat;opacity:0.6;
  opacity: 0.6;
  position: absolute;
  width: 100%;
  height: 100%;
} */
}
  
</style>


<script type="text/javascript">

function printpage()
{
window.print();
}
</script>

</head>
<body onload="printpage()" style="padding-top:0px;">

<%
	AcknoweledgementBean applicationFormBean=(AcknoweledgementBean)request.getAttribute("AcknoweledgementBean");
    			 %>


<div id="masthead">  
  <div class="container-fluid">
    <div class="row">
		<div class="col-md-2 col-sm-3 col-xs-3">
			<div class="well well-lg"> 
			  <div class="row">
				<div class="col-sm-12">
					<img src="images/main_ack_logo.png">
				
				</div>
			  </div>
			</div>
		</div>
		<div class="col-md-10 col-sm-9 col-xs-9">
			 <h1 style="margin-top: 14px; margin-left: -110px;">
           SASHASTRA SEEMA BAL RECRUITMENT
           </h1>
           <h2 style="margin-top: 11px; margin-left: -110px; font-size:14px;">
          RECRUITMENT OF 338/RC/SSB/Combined Advt./Sub-Inspectors/2023 FOR THE POST OF (<%=applicationFormBean.getPost_selected_name() %>) 
           </h2>
		</div>
    </div> 
  </div>
  
</div>




	<!--wrapper div starts here-->
	   <div class="container-fluid">
  <div class="row">    
    <div class="col-md-12"> 

      <div class="panel">
        	<div class="panel-body	registrationDetails2" style="padding:0px;">
        	
        	<div class="contentoutter">
        	<div class="watermark"></div>
					<div class="contentinner">
					
       <form  action="#">
       <jsp:useBean id="AcknoweledgementBean" scope="request" class="com.ttil.bean.AcknoweledgementBean" />
					<input type="hidden" name="requestFrom" value="Acknoweledgement" />
					
	
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="padding:30px 0px 0px 0px;">
          <tr>
				<td class="bdr" colspan="2"><h5>Acknowledgement</h5></td>
			</tr>
		
											
            <!--  <tr>
				<td class="bdr"><h4>Personal Details</h4></td>
			</tr> -->
			
			<tr>
				<td width="90%"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0"> 
				
			  <tr>
                <td width="53.8%"><label class="label1">Registration Id : </label> 
                <label><jsp:getProperty name="AcknoweledgementBean" property="transactionid" /></label></td>
                <td><label class="label1">Date &amp; Time  : </label> 
                <label><jsp:getProperty name="AcknoweledgementBean" property="date_created" /></label></td>
              </tr>
              
              <tr>
                <td><label class="label1">Post Applied For : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="post_selected_name" /></label></td>
                <td><label class="label1">Applicant Name : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="first_name" /> 
                <jsp:getProperty name="AcknoweledgementBean" property="middle_name" /> 
                <jsp:getProperty name="AcknoweledgementBean" property="last_name" /></label></td>
              </tr>
            
              
               <tr>
                <td><label class="label1">Father's Name : </label><label><jsp:getProperty name="AcknoweledgementBean" property="father_name" /></label></td>
                <td><label class="label1">Mother's Name : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="mother_name" /></label></td>
              </tr>
              
              <tr>
                <td><label class="label1">Date of Birth : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="dob" /></label></td>
                <td> <label class="label1">Gender : </label><label><jsp:getProperty name="AcknoweledgementBean" property="sex" /></label></td>
              </tr>
               <%-- <tr>
                <td><label class="label1">Gender : </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="sex" /></label></td>
              </tr> --%>
              <tr>
                <td><label class="label1">Religion : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="religion" /></label></td>
                <td><label class="label1">Marital Status : </label><label><jsp:getProperty name="AcknoweledgementBean" property="marrital_status" /></label></td>
              </tr>
               <% if("Others".equalsIgnoreCase(applicationFormBean.getReligion())){%>
              <tr>
                <td><label class="label1">Other Religion : </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="other_religion" /></label></td>
              </tr>
              <%} %>
              
               <tr>
                <td><label class="label1">Nationality  : </label><label><jsp:getProperty name="AcknoweledgementBean" property="nationality" />
                <% if("Others".equalsIgnoreCase(applicationFormBean.getNationality())){%>
                (<jsp:getProperty name="AcknoweledgementBean" property="other_nationality" />)
                <%} %>
                </label></td>
                <td><label class="label1">Category : </label><label><jsp:getProperty name="AcknoweledgementBean" property="community" /></label></td>
              </tr>
              
              
               <tr>
                <td><label class="label1">Identity Card No : </label><label><jsp:getProperty name="AcknoweledgementBean" property="aadharNo" /> (<jsp:getProperty name="AcknoweledgementBean" property="identity_type" />)</label></td>
                <td><label class="label1">Identification Marks : </label><label><jsp:getProperty name="AcknoweledgementBean" property="identification_mark" /></label></td>
              </tr>
              
              <tr>
                <td><label class="label1">Mobile Number : </label><label><jsp:getProperty name="AcknoweledgementBean" property="mobileNumber" /></label></td>
                <td><label class="label1">Email Address : </label><label><jsp:getProperty name="AcknoweledgementBean" property="emailaddress" /></label></td>
              </tr>
            </table>
            </td>  
              <td>
                      <table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">				
              <tr> <td>
            <img id="" src="../ssb_uploads/candidateImages/SI/<jsp:getProperty name="AcknoweledgementBean" property="photoFileName" />" style="height:120px;width:160px;"> <br/> </td>
                  </tr>
                  </table>
                  </td>
           </tr>   
		
		<tr>
		   <td colspan="2"><table width="96%" border="0" align="center" cellpadding="5" cellspacing="0"> 
		     
		     <tr>
                <td width="47%"><label class="label1">Community belonging to any  : </label></td>
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
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="category" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="cat_cert_no" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="cat_date_Issue" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="cat_issue_authority" /></label></td>
                      </tr>  
                     </tbody>
                   </table>
                </td>
              </tr>
              <%} %>
               <tr>
                <td > <label class="label1">Whether domiciled ordinary in J&amp;K during 1980 to 1989  : </label></td>
                <td ><label><% if(applicationFormBean.isJk_domiciled()){ %> Yes <% }else{ %> No
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
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="jk_cert_no" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="jk_date_Issue" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="jk_issue_authority" /></label></td>
                      </tr>  
                     </tbody>
                   </table>
                </td>
              </tr>
              <%} %>
              
               <tr>
                <td><label class="label1">Whether affected in 1984 riots or communal riots of 2002 Gujarat  : </label></td>
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
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="riots_cert_no" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="riots_date_Issue" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="riots_issue_authority" /></label></td>
                      </tr>  
                     </tbody>
                   </table>
                </td>
              </tr>
              <%} %>
              
            <%--   <tr>
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
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="riots_guj_cert_no" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="riots_guj_date_Issue" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="riots_guj_issue_authority" /></label></td>
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
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="exman_enrollment_date" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="exman_retirement_date" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="exman_med_cat" /></label></td>
                        <%-- <td><label><jsp:getProperty name="AcknoweledgementBean" property="exman_awd_dec" /></label></td> --%>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="exman_discharge_reason" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="exman_edu_qual" /></label></td>
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
              <% if(applicationFormBean.isGovt_service() || applicationFormBean.isEmployee_ssb()){ %> 
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
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="present_employer" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="emp_date_since" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="post_held" /></label></td>
                        <td><label><jsp:getProperty name="AcknoweledgementBean" property="nocdesignation" /></label></td>
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
				<td class="bdr" colspan="2"><h4>Education Qualification Details</h4></td>
			</tr>
			
			<tr>
				<td colspan="2"><table width="96%" border="0" align="center" cellpadding="5" cellspacing="0" style="margin-top: 10px; margin-bottom: 10px;">
              
              
              <tr>
                <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                  
                 <tr>
                    <td width="10%" class="border1"><label class="label1">Exam Passed</label></td>
                    <td width="20%" class="border1"><label class="label1" style="line-height:13px;">School/ University/ Board/ Institute</label></td>
                    <td width="7%" class="border1"><label class="label1">Year of Exam</label></td>
                    <td width="10%" class="border1"><label class="label1">Roll No</label></td>
                    <td width="10%" class="border1"><label class="label1">Certificate No</label></td>
                    <td width="10%" class="border1"><label class="label1">Date Of Issued</label></td>
                    <td width="17%" class="border1"><label class="label1">Subject</label></td>
                    <td width="13%" class="border1"><label class="label1" style="line-height:13px;">Aggregate Percentage of Marks/ Grading</label></td>
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
                  
                  String exam_passed_5=applicationFormBean.getExam_passed_5();
                  String stream_5=applicationFormBean.getStream_5();
                  String university_5=applicationFormBean.getUniversity_5();
                  String edu_rollno_5=applicationFormBean.getEdu_rollno_5();
                  String edu_certno_5=applicationFormBean.getEdu_certno_5();
                  String edu_date_issue_5=applicationFormBean.getEdu_date_issue_5();
                  String edu_year_5=applicationFormBean.getEdu_year_5();
                  String edu_marks_5=applicationFormBean.getEdu_marks_5();
                  
                  String exam_passed_plus2=applicationFormBean.getExam_passed_plus2();
                  String stream_plus2=applicationFormBean.getStream_plus2();
                  String university_plus2=applicationFormBean.getUniversity_plus2();
                  String edu_rollno_plus2=applicationFormBean.getEdu_rollno_plus2();
                  String edu_certno_plus2=applicationFormBean.getEdu_certno_plus2();
                  String edu_date_issue_plus2=applicationFormBean.getEdu_date_issue_plus2();
                  String edu_year_plus2=applicationFormBean.getEdu_year_plus2();
                  String edu_marks_plus2=applicationFormBean.getEdu_marks_plus2();
                     
                    
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
                     if(exam_passed_3==null || stream_3==null || university_3==null || edu_rollno_3==null || edu_certno_3==null || edu_date_issue_3==null || edu_marks_3==null ||
                    		 "".equalsIgnoreCase(exam_passed_3) || "".equalsIgnoreCase(stream_3) || "".equalsIgnoreCase(university_3) || "".equalsIgnoreCase(edu_rollno_3) || "".equalsIgnoreCase(edu_certno_3) || "".equalsIgnoreCase(edu_date_issue_3) || "".equalsIgnoreCase(edu_marks_3)
                    		 || "null".equalsIgnoreCase(exam_passed_3) || "null".equalsIgnoreCase(stream_3) || "null".equalsIgnoreCase(university_3) || "null".equalsIgnoreCase(edu_rollno_3) || "null".equalsIgnoreCase(edu_certno_3) || "null".equalsIgnoreCase(edu_date_issue_3) || "null".equalsIgnoreCase(edu_marks_3)){
                    	 edu_qual_3=false;
                     }
                     if(exam_passed_4==null || stream_4==null || university_4==null || edu_rollno_4==null || edu_certno_4==null || edu_date_issue_4==null || edu_marks_4==null ||
                    		 "".equalsIgnoreCase(exam_passed_4) || "".equalsIgnoreCase(stream_4) || "".equalsIgnoreCase(university_4) || "".equalsIgnoreCase(edu_rollno_4) || "".equalsIgnoreCase(edu_certno_4) || "".equalsIgnoreCase(edu_date_issue_4) || "".equalsIgnoreCase(edu_marks_4)
                    		 || "null".equalsIgnoreCase(exam_passed_4) || "null".equalsIgnoreCase(stream_4) || "null".equalsIgnoreCase(university_4) || "null".equalsIgnoreCase(edu_rollno_4) || "null".equalsIgnoreCase(edu_certno_4) || "null".equalsIgnoreCase(edu_date_issue_4) || "null".equalsIgnoreCase(edu_marks_4)){
                    	 edu_qual_4=false;
                     }
                     if(exam_passed_5==null || stream_5==null || university_5==null || edu_rollno_5==null || edu_certno_5==null || edu_date_issue_5==null || edu_marks_5==null ||
                    		 "".equalsIgnoreCase(exam_passed_5) || "".equalsIgnoreCase(stream_5) || "".equalsIgnoreCase(university_5) || "".equalsIgnoreCase(edu_rollno_5) || "".equalsIgnoreCase(edu_certno_5) || "".equalsIgnoreCase(edu_date_issue_5) || "".equalsIgnoreCase(edu_marks_5)
                    		 || "null".equalsIgnoreCase(exam_passed_5) || "null".equalsIgnoreCase(stream_5) || "null".equalsIgnoreCase(university_5) || "null".equalsIgnoreCase(edu_rollno_5) || "null".equalsIgnoreCase(edu_certno_5) || "null".equalsIgnoreCase(edu_date_issue_5) || "null".equalsIgnoreCase(edu_marks_5)){
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
                  
                  <%}%>
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
			 <% if(applicationFormBean.getNurse()==null)  {%>
               <tr>
                <td><label class="label1">Whether registered with Central or State Nursing Council :</label></td>
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
				<td class="bdr"  colspan="2"><h4>Address Details</h4></td>
			</tr>
			<tr>
				<td colspan="2"><table width="96%" border="1" align="center" cellpadding="5" cellspacing="0" style="margin-top: 10px; margin-bottom: 10px;">
           
			  <tr>
					<td colspan="2"><h6 style="text-align:center;">Permanent Address </h6></td>
					<td colspan="2"><h6 style="text-align:center;">Correspondence Address </h6></td>
			 </tr>
              <tr>
                <td width="13%"><label class="label1">Village/Town </label></td>
                <td width="32%"><label><jsp:getProperty name="AcknoweledgementBean" property="village" /></label></td>
                <td width="13%"><label class="label1">Village/Town </label></td>
                <td width="32%"><label><jsp:getProperty name="AcknoweledgementBean" property="village1" /></label></td>
              </tr>
              <tr>
                <td ><label class="label1">Post Office </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="postoffice" /></label></td>
                 <td><label class="label1">Post Office </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="postoffice1" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Tehsil </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="tehsil" /></label></td>
                <td><label class="label1">Tehsil </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="tehsil1" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Police Station </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="policestation" /></label></td>
                 <td><label class="label1">Police Station </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="policestation1" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">District </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="district" /></label></td>
                <td><label class="label1">District </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="district1" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">State </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="state" /></label></td>
                 <td><label class="label1">State </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="state1" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Pin code </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="pincode" /></label></td>
                 <td><label class="label1">Pin code </label></td>
                <td><label><jsp:getProperty name="AcknoweledgementBean" property="pincode1" /></label></td>
              </tr>
              </table>
         </td>
         </tr>
         
            
            <tr>
				<td class="bdr" colspan="2"><h4>Declaration of Criminal Cases</h4></td>
			</tr>
			<tr>
				<td colspan="2"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">    
              
               <tr>
                <td colspan="2"><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
                 <tr>
                    <td width="82%" colspan="2"><label class="label1">Have you ever been debarred by UPSC, SSC or SPSC or any recruitment board from appearing in any exam?</label></td>
                    <td><label><% if(applicationFormBean.isDebarment()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                 </table>
                </td>
               </tr>     
             <% if(applicationFormBean.isDebarment()){ %> 
             <tr>
                <td colspan="2"><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0" class="border1">
             <tr>
                <td width="50%"><label class="label1">Exam Organizer : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="examorganizer" /></label></td>
                <td width="50%"><label class="label1">Exam Name : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="examname" /></label></td>
              </tr>
              <tr>
                <td width="50%"><label class="label1">Exam Date : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="examdate" /></label></td>
                <td width="50%"><label class="label1">Debarment End Date : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="debarenddate" /></label></td>
              </tr>
              <tr>
                <td colspan="2"><label class="label1">Reason : </label>
                <label>
                <% if("Others".equalsIgnoreCase(applicationFormBean.getDebar_reason())){ %> 
                <jsp:getProperty name="AcknoweledgementBean" property="other_reason" />
                <%}else{%>
                 <jsp:getProperty name="AcknoweledgementBean" property="debar_reason" />
               <% }%>
                </label></td>
              </tr>
              </table>
              </td>
              </tr>
              <%} %>
              <tr>
                <td colspan="2"><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
					<tr>
                    <td colspan="2"><label class="label1">Criminal Proceeding details, if any </label></td>
                  </tr>
                  										
                  <tr>
                  <td  width="2%" align="left" valign="top"><label style="font-weight:bold;"> a) </label></td>
                    <td width="80%"><label class="label1">Whether any FIR or criminal case(s) has ever been registered against you?</label></td>
                    <td><label><% if(applicationFormBean.isFir_cases()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="left" valign="top"><label style="font-weight:bold;"> b) </label></td>
                    <td><label class="label1" style="line-height:13px;">Whether any criminal complaint case or FIR or criminal case(s) is pending
                      against you in Court of Law, <br/> or with police at the time of submitting the
                      application form?</label></td>
                    <td><label><% if(applicationFormBean.isFir_cases_pending()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="left" valign="top"><label style="font-weight:bold;"> c) </label></td>
                    <td><label class="label1">Have you ever been arrested/detained in any criminal case(s)?</label></td>
                    <td><label><% if(applicationFormBean.isArrested()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="left" valign="top"><label style="font-weight:bold;"> d) </label></td>
                    <td><label class="label1">Have you ever been tried &amp; convicted or acquitted by a Court of Law in any criminal case(s)?</label></td>
                    <td><label><% if(applicationFormBean.isCriminal_case_acquitted()){ %> Yes <% }else{ %> No
								<%} %></label></td>
                  </tr>
                  <tr>
                  <td align="left" valign="top"><label style="font-weight:bold;"> e) </label></td>
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
                <td colspan="2"><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0" class="border1">
              <tr>
                <td width="50%"><label class="label1">FIR No. : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="firno" /></label></td>
                <td width="50%"><label class="label1">Date : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="firdate" /></label></td>
              </tr>
              <tr>
                <td><label class="label1">Under Section : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="firsection" /></label></td>
                <td><label class="label1">District : </label> <label><jsp:getProperty name="AcknoweledgementBean" property="firdistrict" /></label></td>
              </tr>
              <tr>
                <td colspan="2"><label class="label1">Present status of the case at the time of filling up this application form : </label>
                <label><jsp:getProperty name="AcknoweledgementBean" property="firstatus" /></label></td>
              </tr>
               </table></td>
                </tr>
               <tr>
                <td colspan="2"> 
                 <label class="label1"> Your application is provissionally accepted subject to outcome of CourtCase, in case you found convicted by court, your application will be rejected. </label>
                </td>
                </tr>
              <%} %>
            
              </table>
          </td>
          </tr>  
          <tr>
				<td colspan="2" class="bdr"><h4>Declaration by the Candidate</h4></td>
			</tr>
								
			<tr>
				<td align="left" valign="middle" class="bdr" colspan="2">
				<table width="95%" border="0" align="center" cellpadding="5" cellspacing="0">
						
				 <tr>
					<td align="left" valign="middle" colspan="2">	
								<label style="margin-top: 10px; line-height:13px;"> I hereby declare that the information given above is true to the best of my knowledge and belief and nothing has been concealed therein. I am well aware of the fact that if the information given by me is proved not true, I will have to face the consequences as per the Law. Also, all the benefits availed by me shall be summarily withdrawn. 
							    </label>
					 </td>
			     </tr>
			      <tr>
			      <td><label class="label1">Date   : </label> 
                <label><jsp:getProperty name="AcknoweledgementBean" property="date_created" /></label></td>
                
					<td align="right" valign="middle" >	
							 <img  align="right" id="ContentPlaceHolder1_ImgSignature" src="../ssb_uploads/candidateImages/SI/<jsp:getProperty name="AcknoweledgementBean" property="sigFileName" />" style="height:40px;width:160px; margin-bottom:10px;">
					 </td>
			     </tr>
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
</body>
</html>
