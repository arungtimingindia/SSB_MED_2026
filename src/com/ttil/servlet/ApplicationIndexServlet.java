package com.ttil.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttil.bean.OrganizationBean;
import com.ttil.bean.PostsBean;
import com.ttil.util.JsonReadExample;
/**
 * @author Timing Technologies India Pvt Ltd
 * This class defines The index page/notification page
 * redirects to home.jsp page
 */
public class ApplicationIndexServlet  extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;
	public void init() throws ServletException {
		//System.out.println("ApplicationIndexServlet init");
	}
	public void dopost(HttpServletRequest req,HttpServletResponse res)   throws ServletException,IOException {
		this.service(req, res);
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		RequestDispatcher rd=null;
		try{
			HttpSession session = req.getSession();
			session.removeAttribute("requestFromSession");
			session.removeAttribute("ApplicationFormBean");
			//ServletContext context =this.getServletConfig().getServletContext();
			//LinkedHashMap<Integer,OrganizationBean> hashmp=JsonReadExample.readOrganizationAndPosts(context.getRealPath("//org_posts_json.txt"));
			//req.setAttribute("organizations", hashmp);
			//LogsGeneration.generateAccessLog("INDEX", req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId());
			//session.removeAttribute("postDetails");
			rd=req.getRequestDispatcher("/pages/home.jsp");
			rd.forward(req, res);
		}
		catch(Exception ex)
		{
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			//LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationIndexServlet", exceptionAsString, null, req.getRemoteAddr(),req.getHeader("User-Agent"));
		}
	}

}
