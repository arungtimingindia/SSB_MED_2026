package com.ttil.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttil.bean.PostsBean;
import com.ttil.util.JsonReadExample;

/**
 * @author Timing Technologies India Pvt Ltd
 * 
 * This class defines The Registration page /login page/Advertisement page
 * redirects to rect_home.jsp page or the Second page
 */
public class ApplicationAfterIndexServlet  extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;
	//private static final Logger log = Logger.getLogger(ApplicationHomeServlet.class);
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
			//checking if session is null or not and is there a fresh new session ,then it proceeds further.
			if (session!=null && session.isNew()){
				
				//forwarding the request to the jsp page with the with the existing request
				rd = req.getRequestDispatcher("/pages/rect_home.jsp");
				rd.forward(req, res);
			}else{
				/*String post=req.getParameter("post");
				if(post!=null)
				{
					ServletContext context =this.getServletConfig().getServletContext();
					PostsBean postsBean=JsonReadExample.getPostDetails(context.getRealPath("//org_posts_json.txt"),post);
					session.setAttribute("postDetails", postsBean);
					session.setAttribute("requestFromSession", "HOME");
					//res.sendRedirect("applicationHome");
					rd=req.getRequestDispatcher("/pages/menu.jsp");
					rd.forward(req, res);
				}else{
					rd=req.getRequestDispatcher("/pages/selectOrg.jsp");
					rd.forward(req, res);
				}*/
				rd=req.getRequestDispatcher("/pages/rect_home.jsp");
				rd.forward(req, res);
				
			}
		}
		catch(Exception ex)
		{
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			//LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationAfterIndexServlet", exceptionAsString, null, req.getRemoteAddr(),req.getHeader("User-Agent"));
			//throw new UserDefineException("ApplicationAfterIndexServlet",exceptionAsString);
		}
	}

}
