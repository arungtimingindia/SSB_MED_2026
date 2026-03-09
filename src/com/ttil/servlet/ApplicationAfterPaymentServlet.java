package com.ttil.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttil.bean.ApplicationFormBean;

/**
 * @author Timing Technologies India Pvt Ltd
 * This Class will after successful payment and redirected to application status Page
 */
public class ApplicationAfterPaymentServlet  extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;
	public void dopost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException
	{

		this.service(req, res);
	}

	public void service(HttpServletRequest request,HttpServletResponse res) throws ServletException,IOException
	{
		RequestDispatcher rd=null;
		ApplicationFormBean applicationFormBean=null;
		int sbiPayTransactionId=0;
		//PostsBean postBean=null;
		try{
			HttpSession session = request.getSession();
			if (session!=null && session.isNew()){
				rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, res);
			}else{
				
				String requestFrom=(String)session.getAttribute("requestFromSession1");
				////System.out.println("requestFrom="+requestFrom);
				if(requestFrom!=null && ("SBIPayment".equalsIgnoreCase(requestFrom) || "HDFCPayment".equalsIgnoreCase(requestFrom) ))
				{
					////System.out.println("in if requestFrom SBIPayment=");
					applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
					if(session.getAttribute("SBIPayTransactionId")==null)
						sbiPayTransactionId=0;
					else
						sbiPayTransactionId=(Integer)session.getAttribute("SBIPayTransactionId");
					
					////System.out.println("sbiPayTransactionId="+sbiPayTransactionId);
					////System.out.println("applicationFormBean.getTransactionid()="+applicationFormBean.getTransactionid());
					//postBean=(PostsBean)session.getAttribute("postDetails");
					//postBean=(PostsBean)session.getAttribute("postDetails");
					if(applicationFormBean!=null && applicationFormBean.getTransactionid()==sbiPayTransactionId)
					{ 
						////System.out.println("both are same="+sbiPayTransactionId);
						rd=request.getRequestDispatcher("/pages/applicationStatus.jsp");
						rd.forward(request, res);
					}else{
						rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
						rd.forward(request, res);
					}
				}else{
					rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
					rd.forward(request, res);
				}
			}
		}
		catch(Exception ex)
		{
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*if(applicationFormBean!=null)
				LogsGeneration.generateErrorLogs("RegistrationAfterPayment", exceptionAsString, applicationFormBean.getMobileNumber(),applicationFormBean.getTransactionid(), request.getRemoteAddr(),request.getHeader("User-Agent"));
			else
				LogsGeneration.generateErrorLogs("RegistrationAfterPayment", exceptionAsString, null,0, request.getRemoteAddr(),request.getHeader("User-Agent"));
			//throw new UserDefineException("ApplicationAfterSave", exceptionAsString);
	*/	}
	}


}

