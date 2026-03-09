<%@ page import="com.ttil.bean.AcknoweledgementBean" %>  
  <%
  AcknoweledgementBean applicationFormBean=(AcknoweledgementBean)request.getAttribute("AcknoweledgementBean");
            %>
<tr>
            <td colspan="3" align="left" valign="middle">
	            <div class="headborderack">
	              <div class="logoleft"><img src="images/logo.png" alt="logo" title="logo"/></div> 
	              <div class="logoright">GOVERNMENT OF INDIA, MINISTRY OF HOME AFFAIRS (SASHASTRA SEEMA BAL) 
	                <%if(applicationFormBean!=null){ %>
					APPLICATION FORM FOR THE POST OF <%=applicationFormBean.getPost_name()%>
					<%} %>
	             </div>
	             </div>
             </td>
          </tr>
