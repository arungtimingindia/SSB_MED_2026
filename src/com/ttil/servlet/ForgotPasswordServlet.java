package com.ttil.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.owasp.esapi.ESAPI;

import nl.captcha.Captcha;

import com.ttil.bean.ApplicationFormBean;
import com.ttil.bean.ApplicationSearchBean;
import com.ttil.dao.ApplicationSearchDAO;
import com.ttil.util.AsyncOTPRunner;
import com.ttil.util.CreateForgotPasswordMailTemplateSB;
/**
 * @author Timing Technologies India Pvt Ltd
 */
@WebServlet(asyncSupported=true)
public class ForgotPasswordServlet extends HttpServlet {


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
				if(requestFrom!=null && ("ForgotPassword".equalsIgnoreCase(requestFrom) ))
				{
					Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
					request.setCharacterEncoding("UTF-8");
					String answer = request.getParameter("answer");
					if (captcha!=null && captcha.isCorrect(answer)) {
						//if("abcdef".equalsIgnoreCase(answer)){
						//LogsGeneration.generateAccessLog("ApplicationSearch", request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId());
						ApplicationSearchBean applicationSearchBean=new ApplicationSearchBean();
						applicationSearchBean.setTransactionid(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("transactionid").trim()));
						applicationSearchBean.setDob(ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("dob").trim()));
						ApplicationSearchDAO applicationSearchDAO=new ApplicationSearchDAO();
						ApplicationFormBean applicationFormBean=applicationSearchDAO.getPasswordDeatils(applicationSearchBean);
						if(applicationFormBean!=null)
						{
							//request.setAttribute("success_message", "Password has been emailed to your registered Email address &amp; Sent to your registered mobile number");
							//request.setAttribute("success_message", "Password has been Sent to your registered mobile number");
							
							request.setAttribute("success_message", "Registration Id : "+applicationFormBean.getTransactionid()+" and Password :"+applicationFormBean.getPassword()+"");
							//AsyncContext asyncContext = request.startAsync(request, res);
							//asyncContext.setTimeout(600000);
							rd=request.getRequestDispatcher("/pages/forgotpassword.jsp");
							rd.forward(request, res);
							//asyncContext.start(new AsyncOTPRunner(asyncContext,applicationFormBean.getMobileNumber(),"Your Reg Id:"+applicationFormBean.getTransactionid()+" and password:"+ESAPI.encoder().canonicalize(applicationFormBean.getPassword())+" for Recruitment of SSBRecruitment - SSB",request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId()));
							//asyncContext.start(new CreateForgotPasswordMailTemplateSB(asyncContext,applicationFormBean,request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId()));

						}
						else{
							request.setAttribute("message", "Invalid Registration Id or Date of birth.");
							rd=request.getRequestDispatcher("/pages/forgotpassword.jsp");
							rd.forward(request, res);
						}
					}else{
						request.setAttribute("message", "Please enter correct text in box as shown");
						rd=request.getRequestDispatcher("/pages/forgotpassword.jsp");
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
			ex.printStackTrace();
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			ex.printStackTrace();
			/*LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationSearch", exceptionAsString, null, request.getRemoteAddr(),request.getHeader("User-Agent"));
			throw new UserDefineException("ApplicationSearch", exceptionAsString);*/
		}
	}
}
