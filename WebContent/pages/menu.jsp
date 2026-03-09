<%@ page import="com.ttil.bean.PostsBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="shortcut icon" href="images/favicon.jpg" />
<title>Welcome to SSB online application</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
window.onpageshow = function (evt) {
	if (evt.persisted) noBack();
	};
	
	function goToHome()
	{
		var post = document.selectPost.post.value;
		if(post=="" || post=="0")
		{
		alert("Please select Any Post");
		return false;
		}else{
			return true;
		}
		return false;
	}
</script>

<script type="text/javascript">window.history.forward();function noBack(){
	window.history.forward();}
</script>

</head>
<body onLoad="noBack();" onUnload="" oncontextmenu="return true;">
<!--wrapper div starts here-->
<div class="wrapper">
  <!--Outter div starts here-->
  <div class="outter">
    
    <jsp:include page="header.jsp" flush="true" />
    
    <!--Content div starts here-->
    <div class="contentoutter">
      <div class="contentinner">
      <%
      	PostsBean postsBean=(PostsBean)session.getAttribute("postDetails");
      %>
            <input type="hidden" name="requestFrom" value="menu"/>
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="padding:30px 0px 0px 0px;">
          <tr>
            <td width="82%" align="left" valign="middle">
            <div class="headborder">GOVERNMENT OF INDIA, MINISTRY OF HOME AFFAIRS (SASHASTRA SEEMA BAL) 
				<%if(postsBean!=null){ %>
				APPLICATION FORM FOR THE POST OF <%=postsBean.getPost_name() %>
				<%} %>
</div>
               </td>
          </tr>
          <tr>
            <td align="center" valign="middle">
              <div class="secondpage">
               <div class="center1">
                <ol>
                  <li><a href="applicationInstructions">Fill Application Form</a></li>
                  <li><a href="searchApplication">Download Challan</a></li>
                  <!-- <li><a href="#">Update Challan Payment Details</a></li>  -->
                  <li><a href="#">View Application Status</a></li>
                </ol>
                </div>
              </div>
            </td>
          </tr>
        </table>
      </div>
    </div>
    <!--Content div ends here-->

<jsp:include page="../footer/footer.jsp" flush="true" />

  </div>
  <!--Outter div ends here-->
</div>
<!--Wrapper div ends here-->
</body>
</html>
