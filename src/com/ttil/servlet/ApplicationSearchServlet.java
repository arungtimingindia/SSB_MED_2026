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

import nl.captcha.Captcha;

import com.ttil.bean.ApplicationFormBean;
import com.ttil.bean.ApplicationSearchBean;
import com.ttil.dao.ApplicationSearchDAO;
/**
 * @author Timing Technologies India Pvt Ltd
 * This class will authenticate user from the request received from login page
 * and redirects to applicationSearchPreview Class
 */
public class ApplicationSearchServlet extends HttpServlet {


	private static final long serialVersionUID = 4267945957957617573L;
	public void dopost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException
	{

		this.service(req, res);
	}

	public void service(HttpServletRequest request,HttpServletResponse res) throws ServletException,IOException
	{
		RequestDispatcher rd=null;
		try{
			//checking if session is null or not and is there a fresh new session ,then it proceeds further.
			HttpSession session = request.getSession();
			if (session!=null && session.isNew()){
				rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, res);
			}else{
				String requestFrom=request.getParameter("requestFrom");
				if(requestFrom!=null && ("search".equalsIgnoreCase(requestFrom) || "ApplicationHome".equalsIgnoreCase(requestFrom)))
				{
					Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
					request.setCharacterEncoding("UTF-8");
					String answer = request.getParameter("answer");
					if (captcha!=null && captcha.isCorrect(answer)) {
						//if("abcdef".equalsIgnoreCase(answer)){
						//LogsGeneration.generateAccessLog("ApplicationSearch", request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId());
						ApplicationSearchBean applicationSearchBean=new ApplicationSearchBean();
						applicationSearchBean.setTransactionid(request.getParameter("transactionid").trim());
						applicationSearchBean.setPassword(request.getParameter("password").trim());
						ApplicationSearchDAO applicationSearchDAO=new ApplicationSearchDAO();
						int trans_id=applicationSearchDAO.userAuthenticate(applicationSearchBean);
						if(trans_id>0)
						{
							ApplicationFormBean applicationFormBean=applicationSearchDAO.getData(trans_id,101+"");
							//ServletContext context =this.getServletConfig().getServletContext();
							//PostsBean postsBean=JsonReadExample.getPostDetails(context.getRealPath("//org_posts_json.txt"),applicationFormBean.getPost_id()+"");
							//session.setAttribute("postDetails", postsBean);
							session.setAttribute("ApplicationFormBean", applicationFormBean);
							session.setAttribute("requestFromSession", "applicationSearch");
							session.setAttribute("requestNo", "1");
							session.setAttribute("trans_id", trans_id);
							res.sendRedirect("applicationSearchPreview");
						}
						else{
							request.setAttribute("message", "Invalid Registration Id or Password.");
							if(requestFrom!=null && ("search".equalsIgnoreCase(requestFrom)))
								rd=request.getRequestDispatcher("/pages/search.jsp");
							else
								rd=request.getRequestDispatcher("/pages/rect_home.jsp");
							rd.forward(request, res);
						}
					}else{
						request.setAttribute("message", "Please enter correct text in box as shown");
						if(requestFrom!=null && ("search".equalsIgnoreCase(requestFrom)))
							rd=request.getRequestDispatcher("/pages/search.jsp");
						else
							rd=request.getRequestDispatcher("/pages/rect_home.jsp");
						rd.forward(request, res);
					}
				}else{
					rd=request.getRequestDispatcher("/sessionTimeoutPage.jsp");
					rd.forward(request, res);
				}
			}
		}
		catch(Exception ex)
		{
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			ex.printStackTrace();
			/*LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationSearch", exceptionAsString, null, request.getRemoteAddr(),request.getHeader("User-Agent"));
			throw new UserDefineException("ApplicationSearch", exceptionAsString);*/
		}
	}
}
