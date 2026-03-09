<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>payment</title>
</head>
<body >
	<%-- <form name="ecom" method="post"
		action="https://test.sbiepay.com/secure/AggregatorHostedListener">
		<input type="hidden" name="EncryptTrans" value="<%=request.getAttribute("EncryptTrans")%>">
		<input type="hidden" name="merchIdVal" value="1000420" />
		 <input type="submit" name="pay" value="pay">
	</form> --%>
	
	<form id="nonseamless" method="post" name="redirect" action="https://secure.ccavenue.com/transaction/transaction.do?command=initiateTransaction"> 
		<input type="hidden" id="encRequest" name="encRequest" value="<%= request.getAttribute("encRequest") %>">
		<input type="hidden" name="access_code" id="access_code" value="<%= request.getAttribute("accessCode") %>">
		<script language='javascript'>document.redirect.submit();</script>
	</form>
</body>
</html>