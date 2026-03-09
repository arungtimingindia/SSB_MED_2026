<%@ page import="com.ttil.bean.OrganizationBean" %>
<%@ page import="com.ttil.bean.PostsBean" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to SSB online application</title>
<!-- <link href="css/style.css" rel="stylesheet" type="text/css" /> -->
 <link rel="shortcut icon" type="image/ico" href="images/favicon.ico" />
<script type="text/javascript">
window.onpageshow = function (evt) {
	if (evt.persisted) noBack();
	};
	
	function goToHome(post_id)
	{
		document.selectPost.post.value=post_id;
			return true;
		
	}
</script>

<script type="text/javascript">window.history.forward();function noBack(){
	window.history.forward();}
</script>

</head>
<body onLoad="noBack();" onUnload="" oncontextmenu="return false;">
<!--wrapper div starts here-->
<div class="wrapper">
  <!--Outter div starts here-->
  <div class="outter">
    
    <jsp:include page="header.jsp" flush="true" />
    
    <!--Content div starts here-->
    <div class="contentoutter">
    <form name="selectPost" method="post" action="applicationAfterIndex">
      <div class="contentinner">
      <input type="hidden" name="post" id="post" value=""/>
        <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0" style="padding:30px 0px 0px 0px;">
          <%
          	LinkedHashMap<Integer,OrganizationBean> hashmp=(LinkedHashMap)request.getAttribute("organizations");
                               if(hashmp!=null){
          %>
          
             <%
                       	for(int i=1;i<=hashmp.size();i++){
                                                      		   OrganizationBean organizationBean= hashmp.get(i);
                                                      		   if(organizationBean!=null){
                                                      		   Vector<PostsBean> postsVector= organizationBean.getPosts();
                                                      		   if(postsVector!=null && postsVector.size()>0){
                       %>
        	   <tr>
                <td align="center" valign="middle" colspan="2">
        	  <h4>Click on the application links to Apply</h4>
        	  </td>
        	  </tr>
        	  <tr>
            <td  align="center" valign="middle" colspan="2">
				 <h2><%=organizationBean.getOrg_name()%> </h2>
			</td>
          </tr>
          <tr>
            <th width="60%" align="left" valign="middle" style="padding-top:20px;">Application For Post </th>
            <th width="40%" align="left" valign="middle" style="padding-top:20px;"> Closing Date</th>
          </tr>  
            
				  <%
              				  	for(PostsBean postsBean:postsVector){
              				  %>
				   <tr>
            <td width="60%" align="left" valign="middle" style="padding-top:20px; font-size:18px;">
				   <%--  <a onclick="return goToHome(<%=postsBean.getPost_id()%>)"> <%=postsBean.getPost_name() %></a> --%>
				     <a> <input type="submit" name="post_button" class="btnHome"  value="<%=postsBean.getPost_name() %>" onclick="goToHome(<%=postsBean.getPost_id()%>)"></input> </a>
				    <%-- <input type="submit" name="post_button" class="btnHome"  onclick="goToHome(<%=postsBean.getPost_id()%>)" value="<%=postsBean.getPost_name() %>"></input> --%>
				 </td>
				   <td width="40%" align="left" valign="middle" style="padding-top:20px; font-size:18px;">
				    <%=postsBean.getPost_end_date() %>
				 </td>
          </tr>	   
				 
        	  <% }}}} %>
				

               
          <%}else{%>
        	  <tr>
            <td height="20" align="left" valign="middle" colspan="2">No Posts available</td>
          </tr>
          <%}%>
        
        </table>
       <div class="border">
           <div class="marg1">
              <h2>In case of any doubt, call the below helpline numbers.</h2>
               <p class="center">Timings: weekdays from 10.00 AM - 5.00 PM.</p>
               <p class="center" style="margin:0px;">011-2720408</p>
               <p class="center" style="margin:0px;">011-2720409</p>
               <p class="center" style="margin:0px;">011-2720410</p>
               <p class="center" style="margin:0px;">011-2720411</p>
           </div>
        </div>
      </div>
      </form>
    </div>
    <!--Content div ends here-->

<jsp:include page="../footer/footer.jsp" flush="true" />

  </div>
  <!--Outter div ends here-->
</div>
<!--Wrapper div ends here-->
</body>
</html>
