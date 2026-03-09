package com.ttil.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author Timing Technologies India Pvt Ltd
 */
public class ForgotRegIdPageServlet extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;
	public void dopost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException
			{

		this.service(req, res);
			}

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		RequestDispatcher rd=null;
		HttpSession session = req.getSession();
		session.removeAttribute("ApplicationFormBean");
		//session.removeAttribute("requestFromSession");
		session.removeAttribute("requestAppForm");
		//session.removeAttribute("postDetails");
		//String requestFrom=req.getParameter("requestFrom");
		//String requestFrom=(String)session.getAttribute("requestFromSession");
		try{
			/*if(requestFrom!=null && "HOME".equalsIgnoreCase(requestFrom))
			{*/
				rd=req.getRequestDispatcher("/pages/forgotRegId.jsp");
				rd.forward(req, res);
			/*}else{
				rd=req.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(req, res);
			}*/
		}catch(Exception ex)
		{
			//LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationInstructionsServlet", ex.getMessage(), null, req.getRemoteAddr());
			//ex.printStackTrace();
			//throw new UserDefineException();
		}
	}

}
