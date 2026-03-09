<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>payment</title>
<script>
function onLoadSubmit() {
	document.sbi_payment.submit();
}
</script>
<style type="text/css">
#loading {
    position: absolute; width: 100%; height: 100%; background: url('images/wait.gif') no-repeat center center;
}
</style>
</head>
<body  onload="onLoadSubmit()">
	<form name="sbi_payment" id="sbi_payment" method="post"
		action="https://www.sbiepay.sbi/secure/AggregatorHostedListener">
		
		<input type="hidden" name="EncryptTrans" value="<%=request.getAttribute("EncryptTrans")%>">
		<input type="hidden" name="merchIdVal" value="1000420" />
		 <!-- <input type="submit" name="pay" value="pay"> -->
		 <div id="loading"></div>
	</form>
</body>
</html>