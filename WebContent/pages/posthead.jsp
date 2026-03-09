<%@ page import="com.ttil.bean.PostsBean" %>  
  <%
    	PostsBean postsBean=(PostsBean)session.getAttribute("postDetails");
    %>
<tr>
            <td colspan="4" align="left" valign="middle"><div class="headborder">
            <input type="hidden" name="max_age" value="<%=postsBean.getMax_age()%>"/>
            GOVERNMENT OF INDIA, MINISTRY OF HOME AFFAIRS (SASHASTRA SEEMA BAL) 
                <%if(postsBean!=null){
                	%>
				APPLICATION FORM FOR THE POST OF <%=postsBean.getPost_name() %> 
				<%} %>
                </div></td>
          </tr>
          <tr>
            <td width="3%" height="37" align="left" valign="middle">&nbsp;</td>
            <td width="37%" align="left" valign="middle"><label><span class="style1">Opening date : <%=postsBean.getPost_start_date() %></span></label></td>
            <td width="47%" align="right" valign="middle"><label><span class="style1">Closing date : <%=postsBean.getPost_end_date() %> </span></label></td>
            <td width="3%" align="right" valign="middle">&nbsp;</td>
          </tr>