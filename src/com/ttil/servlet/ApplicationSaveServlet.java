package com.ttil.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import com.ttil.bean.ApplicationFormBean;
import com.ttil.bean.PostsBean;
import com.ttil.dao.ApplicationFormDAO;
/**
 * @author Timing Technologies India Pvt Ltd
 * This class will validate the data submitted by candidate
 * And will check captcha entered is correct or not 
 * And check following cases
 * 1. DB Connection
 * 2. Duplicate records with Mobile Number or Email address or candidate details  
 * And redirects to ApplicationAfterSave Servlet there it will redirect to based on conditions
 */
public class ApplicationSaveServlet  extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;
	public void dopost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException
	{

		this.service(req, res);
	}

	public void service(HttpServletRequest request,HttpServletResponse res) throws ServletException,IOException
	{
		RequestDispatcher rd=null;
		int transaction_id=0;
		try{
			//checking if session is null or not and is there a fresh new session ,then it proceeds further.
			HttpSession session = request.getSession();
			if (session!=null && session.isNew()){
				rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, res);
			}else{
				String requestFrom=request.getParameter("requestFrom");
				if(requestFrom!=null && "apllicationpreview".equalsIgnoreCase(requestFrom))
				{
					ApplicationFormBean applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
					// to check weather bean is null or not
					if(applicationFormBean!=null)
					{
						Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
						request.setCharacterEncoding("UTF-8");
						String answer = request.getParameter("answer");
						if (captcha!=null && captcha.isCorrect(answer)) {
							//if("abcdef".equalsIgnoreCase(answer)){
							List<String> messageOb = new ArrayList<String>();
							ServerSideSanitizationValidation serverSideSanitizationValidation=new ServerSideSanitizationValidation();
							serverSideSanitizationValidation.checkValidation(applicationFormBean, messageOb);
//							if(applicationFormBean.getPassword()==null || "".equalsIgnoreCase(applicationFormBean.getPassword().trim())){
//								messageOb.add("Password is Empty, please set password");
//							}else if (!applicationFormBean.getPassword().equalsIgnoreCase(applicationFormBean.getConfirm_password())){
//								messageOb.add("Password is not same as Confirm Password");
//							}
							if(messageOb!=null && messageOb.size()>0)
							{
								request.setAttribute("messageOb", messageOb);
								applicationFormBean.setMessage("");
								applicationFormBean.setMessage1("");
								applicationFormBean.setNoOfRequests(applicationFormBean.getNoOfRequests()+1);
								rd=request.getRequestDispatcher("/pages/confirmdetails.jsp");
								rd.forward(request, res);
							}else{
								ApplicationFormDAO applicationFormDAO=new ApplicationFormDAO();
								PostsBean postsBean=(PostsBean)session.getAttribute("postDetails");
								transaction_id=applicationFormDAO.checkMobileAndEmail(applicationFormBean,postsBean);
								
								applicationFormBean.setTransactionid(transaction_id);
								applicationFormBean.setMessage("");
								applicationFormBean.setMessage1("");
								applicationFormBean.setNoOfRequests(applicationFormBean.getNoOfRequests()+1);
								session.setAttribute("ApplicationFormBean", applicationFormBean);
								session.setAttribute("requestFromSession", "applicationSave");
								res.sendRedirect("applicationAfterSave");
							}
						}
						else{
							applicationFormBean.setMessage("Please type the exact characters as shown in the image.");
							applicationFormBean.setMessage1("");
							applicationFormBean.setNoOfRequests(applicationFormBean.getNoOfRequests()+1);
							rd=request.getRequestDispatcher("/pages/confirmdetails.jsp");
							rd.forward(request, res);
						}
					}
					else{
						rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
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
			//LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationSave", exceptionAsString, null, request.getRemoteAddr(),request.getHeader("User-Agent"));
			//throw new UserDefineException("ApplicationSave", exceptionAsString);
		}
	}
}
