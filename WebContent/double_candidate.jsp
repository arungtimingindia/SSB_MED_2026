<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>::  ::</title>
<!--[if lt IE 7]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE7.js"></script>
<![endif]-->
<!--[if lt IE 8]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE8.js"></script>
<![endif]-->
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>
<![endif]-->

<!--[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<link rel="shortcut icon" href="images/favicon.jpg" />



</head>

<body>

<jsp:include page="pages/header.jsp" flush="true" />
  
<div class="container" id="mainWrapper">
    <div style="width: 600px; float: left; margin: 50px 0px 0px 100px; border: 1px solid #e4e4e4; padding: 10px;">
    <% String message=null;
    message=(String)request.getAttribute("message");
    if(message!=null){%>
     <span class="errorpageText2"><%=message %></span>
       
    <%} %>
  </div>
  <div class="clear"></div>
  </div>
  
  <jsp:include page="pages/footer.jsp" flush="true" />


</body>
</html>
