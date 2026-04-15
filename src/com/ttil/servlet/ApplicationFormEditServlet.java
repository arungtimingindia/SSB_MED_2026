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
 * This class defines or take the controls to the   Edit Application Form Page.
 * redirects to applicationForm1_edit.jsp page or the Third pageof Web application(1st page of  new registration)
 */

public class ApplicationFormEditServlet extends HttpServlet {

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
		String requestFrom=req.getParameter("requestFrom");
		int app_request_id_session=(Integer)session.getAttribute("app_request_id_session");
		String final_transaction_id=(String)req.getParameter("final_transaction_id");
		//System.out.println("app_request_id_session="+app_request_id_session);
//		String app_request_id_req=(String)req.getParameter("app_request_id_req");
		//System.out.println("app_request_id_req="+app_request_id_req);
		//LogsGeneration.generateAccessLog("OpenApplicationForm", req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId());
		try{
			if(requestFrom !=null &&  requestFrom.equalsIgnoreCase("apllicationpreview") && app_request_id_session>0   ) {
				req.setAttribute("final_transaction_id", final_transaction_id);
				req.setAttribute("app_request_id_req", app_request_id_session);
				session.setAttribute("requestAppForm", "applicationForm");
				rd=req.getRequestDispatcher("/pages/applicationForm1_edit.jsp");
				rd.forward(req, res);
			}else {
				rd = req.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(req, res);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			//LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationFormServlet", exceptionAsString, null, req.getRemoteAddr(),req.getHeader("User-Agent"));
			//throw new UserDefineException("ApplicationFormServlet", exceptionAsString);
		}
	}

}