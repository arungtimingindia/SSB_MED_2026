<%@ page import="com.ttil.bean.ApplicationFormBean" %>
<%@ page import="com.ttil.bean.PostsBean" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="shortcut icon" href="images/favicon.jpg" />
<title>welcome to ssb online application</title>
</head>
<body>

<jsp:include page="header.jsp" flush="true" />
	<!--wrapper div starts here-->
	   <div class="container-fluid">
  <div class="row">    
    <div class="col-md-12"> 

      <div class="panel">
        	<div class="panel-body	registrationDetails">
        	
        	<div class="contentoutter">
					<div class="contentinner">
					
      <form name="applicationView" id="applicationView" method="post"	action="#">
			<jsp:useBean id="ApplicationFormBean" scope="request" class="com.ttil.bean.ApplicationFormBean" />
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="padding:30px 0px 0px 0px;">
		
		<% String responsePayment=request.getParameter("ResponsePayment"); %>
         <%  String BankRefNo=(String)request.getAttribute("bank_ref_no");
		String TransactionId=(String)request.getAttribute("order_id");
		String failure_message=(String)request.getAttribute("failure_message");
		String status_message=(String)request.getAttribute("status_message");
		String order_status=(String)request.getAttribute("order_status");
		if(BankRefNo==null || "null".equalsIgnoreCase(BankRefNo))
			BankRefNo="NA";
		if(TransactionId==null || "null".equalsIgnoreCase(TransactionId))
			TransactionId="NA";
		if(failure_message==null || "null".equalsIgnoreCase(failure_message))
			failure_message="NA";
		if(status_message==null || "null".equalsIgnoreCase(status_message))
			status_message="NA";
		if(order_status==null || "null".equalsIgnoreCase(order_status))
			order_status="NA";
		%>
          
          <tr>
            <td colspan="4" align="left" valign="middle"><table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#a0a0a0">
              <tr>
                <td ><div align="center" class="transpagestyleError1">Your Payment is Failed/Cancelled for The Application Form  </div></td>
              </tr>
               <tr>
                <td ><div align="center" class="transpagestyleError1">Your Payment Order Id: <%= TransactionId %> </div></td>
              </tr>
              <%--  <tr>
                <td ><div align="center" class="transpagestyleError1">Your Bank Reference Number: <%= BankRefNo %> </div></td>
              </tr> --%>
               <tr>
                <td ><div align="center" class="transpagestyleError1">Order Status: <%= order_status %> </div></td>
              </tr>
               <tr>
                <td ><div align="center" class="transpagestyleError1">Failure Message: <%= failure_message %> </div></td>
              </tr>
              <tr>
                <td ><div align="center" class="transpagestyleError1">Order Status Message: <%= status_message %> </div></td>
              </tr>
            </table></td>
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
