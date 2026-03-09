package com.ttil.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Timing Technologies India Pvt Ltd
 * 
 * This class defines or take the controls to the   NEW REGISTERATIONs Form Page.
 * redirects to applicationForm1.jsp page or the Third pageof Web application(1st page of  new registration)
 */

public class ApplicationFormServlet extends HttpServlet {

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
		String requestFrom=req.getParameter("requestFrom");
		//LogsGeneration.generateAccessLog("OpenApplicationForm", req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId());
		try{
			//checking if session is null or not and is there a fresh new session ,then it proceeds further.
			if (session!=null && session.isNew()){
				rd = req.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(req, res);
			}else{
				//if(requestFrom!=null && "instructions".equalsIgnoreCase(requestFrom))
				{
					rd = req.getRequestDispatcher("/sessionTimeoutPage.jsp");
					session.setAttribute("requestAppForm", "applicationForm");
					rd=req.getRequestDispatcher("/pages/applicationForm1.jsp");
					rd.forward(req, res);
				}/*else{
					rd=req.getRequestDispatcher("/sessionTimeoutPage.jsp");
					rd.forward(req, res);
				}*/
			}
		}
		catch(Exception ex)
		{
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			//LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationFormServlet", exceptionAsString, null, req.getRemoteAddr(),req.getHeader("User-Agent"));
			//throw new UserDefineException("ApplicationFormServlet", exceptionAsString);
		}
	}

}
