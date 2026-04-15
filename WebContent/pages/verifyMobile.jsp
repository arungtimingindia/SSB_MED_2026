<%@ page import="com.ttil.bean.ApplicationFormBean"%>
<%@ page import="java.util.List"%>
<%@ page import="org.owasp.html.Sanitizers"%>
<%@ page import="org.owasp.html.PolicyFactory"%>
<%@ page import="org.owasp.esapi.ESAPI" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page pageEncoding="utf-8" %>
 <link rel="shortcut icon" href="images/favicon.png" />
 <script type="text/javascript" src="js/jquery.min.js"></script>
<title>SSB</title>
<style type="text/css">

</style>

 

<script>
	function acknoweledgementView() {
		document.applicationView.action="acknowledgement";
        document.applicationView.submit();
	}
	
	function goToInstructions() {
		document.location.href = "applicationAfterIndex";
	}
	
	function uploadPhoto() {
		var otp=document.applicationView.enteredOtp.value;
		if(otp=="" || otp.length!=6)
			alert("Please enter valid OTP");
		else{
			document.getElementById("requestFrom1").value = "OTPMobileVerification";
			document.applicationView.action="verifymobile";
	        document.applicationView.submit();
		}
		
		
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
     <form name="applicationView" id="applicationView" method="post"   	action="verifymobile">
     
     
      <jsp:useBean id="ApplicationFormBean" scope="session" class="com.ttil.bean.ApplicationFormBean" />
					<input type="hidden" name="requestFrom" value="OTPMobileVerification" />
					
					 
					<%
                      ApplicationFormBean applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
					/* String transactionid=(String)request.getParameter("transactionid"); */
					Integer transactionid=applicationFormBean.getTransactionid(); 
        			 %>
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="padding:30px 0px 0px 0px;">
          
            
         <!--  <tr>
            <td colspan="4" align="center" valign="middle" class="bdr"><h2>Page 1 of 9</h2></td>
          </tr> -->
           <tr>
            <td colspan="4" align="center" valign="middle" class="bdr"><h2  style="text-align:center;">Verify Mobile &amp; Email(OTP) </h2></td>
          </tr>
          <tr>
            <td colspan="4" align="center" valign="middle">
              <input type="hidden" name="requestFrom1" id="requestFrom1" />
              <input type="hidden" name="transactionid" value="<%=transactionid %>" />
            
            <table width="95%" border="0" align="center" cellpadding="5" cellspacing="0" >
            

				          <tr>
				            <td colspan="2" height="80"  align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle2">REGISTRATION NUMBER: <%=applicationFormBean.getTransactionid() %></div></td>
				          </tr>
				          
				         
					
						</table>
					</td>
			</tr>
						
			 <%
                     if(applicationFormBean.getMessage()!=null && !"".equalsIgnoreCase(applicationFormBean.getMessage()))
                     {
                     %>
						<tr>
							<td colspan="2"
								class="center rightbodernoneclass colorText text-center"><b><jsp:getProperty
										name="ApplicationFormBean" property="message" /></b></td>
						</tr>
						<%} %>								
             
			<tr>
				<td colspan="2"><table width="95%" border="0" align="center" cellpadding="5" cellspacing="0"> 
             
              <tr>
                <td width="39%"><label class="label1">Name : </label></td>
                 <td width="61%"><label><jsp:getProperty name="ApplicationFormBean" property="first_name" /> <jsp:getProperty name="ApplicationFormBean" property="middle_name" /> <jsp:getProperty name="ApplicationFormBean" property="last_name" /> </label></td>
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
                <td><label class="label1">Mobile Number  : </label></td>
                <td><label>
                <%  String strPattern = "\\d(?=\\d{4})";
              String maskedMobile=  applicationFormBean.getMobileNumberBackup().replaceAll(strPattern, "*");
                %>
               <%= maskedMobile  %>
                <%-- <jsp:getProperty name="ApplicationFormBean" property="mobileNumber" /> --%></label></td>
              </tr>
            <tr>
                <td><label class="label1">Email address  : </label></td>
                  <%  String strPattern1 = "(?<=.{3}).(?=[^@]*?@)";
                  String maskedEmail="-NA-";
                  if(applicationFormBean.getEmailaddressBackup()!=null){
               maskedEmail=  applicationFormBean.getEmailaddressBackup().replaceAll(strPattern1, "*");
                  }
                %>
               
                <td><label><%= maskedEmail  %> </label></td>
              </tr>
              
               
              
             </table>
          
		</td>
		</tr>
          
          <tr>
            <td colspan="2" align="center" valign="middle">
            
            <table width="95%" border="0" align="center" cellpadding="5" cellspacing="0" >

				           <tr>
							   <td colspan="2" align="left" valign="middle">
							      <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
							   <%if(applicationFormBean.getApplication_status()!=null ) {%>
							 
							  <tr>
	            <td colspan="2" height="70"  align="left" valign="middle" class="bdr"><div align="center" class="transpagestyle3" style="color:red; font-size: 20px;"> 
	            Please enter the One Time Password sent to your registered mobile number and email id in the box below and click on "Verify".</div></td>
	          </tr>	
	           
	          <tr>
                   <!--  <td width="40%" align="right" valign="middle"><img alt="" id="captcha" src="simpleCaptcha.png" width="150" /></td> -->
                    <td  width="45%" align="right" valign="middle"><label class="label1">Enter One-Time Password : </label></td>
                    <td width="55%" align="left" valign="middle">
                    <input type="text" name="enteredOtp" maxlength="6"
							style="width: 100px;" autocomplete="off" oncut="return false;"
							oncopy="return false;" onpaste="return false;" class="text1" /></td>
                  </tr>	 
                  
						
							 
							  <tr>
							    <td colspan="2"><div class="buttonWrapper" style="margin:20px 0px 0px 0px;"> 
							            <input type="button" id="complexConfirm" class="nextbutton appFormBtmRight" value="Verify" onClick="uploadPhoto()" style="margin:0px 0px  0px 20px;width:220px; height:50px;">     
							          </div></td>
							  </tr>
							  <%} %>
                            </table>
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
<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
