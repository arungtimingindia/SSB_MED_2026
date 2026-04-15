package com.ttil.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttil.bean.AppDataBean;
import com.ttil.bean.ApplicationFormBean;
import com.ttil.dao.ApplicationFormDAO;
import com.ttil.util.AsyncOTPRunner;
import com.ttil.util.CreateOTPMailTemplateSB;

@WebServlet(asyncSupported=true)
public class ShowVerifyMobileEmailServlet extends HttpServlet {

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
		try{
			String req_transactionid=req.getParameter("transactionid");
			int transactionid=0;
			if(req_transactionid!=null)
				transactionid=Integer.parseInt(req_transactionid);

			ApplicationFormBean applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
			if( applicationFormBean!=null && applicationFormBean.getTransactionid()==transactionid){
				if( "apllicationpreview".equalsIgnoreCase(requestFrom) ) {
					if(applicationFormBean.isOtpValidated() ) {
						AppDataBean appDataBean=new AppDataBean();
//						appDataBean.setTransactionid(applicationFormBean.getTransactionid());
//						appDataBean.setFee_amount(applicationFormBean.getFee_amount());
//						session.setAttribute("AppDataBean", appDataBean);
						
						appDataBean.setTransactionid(applicationFormBean.getTransactionid());
						appDataBean.setEdit(true);
						appDataBean.setFee_amount(applicationFormBean.getTotalFeeAmount());
						session.setAttribute("AppDataBean", appDataBean);
						
						rd=req.getRequestDispatcher("/pages/applicationStatus.jsp");
						rd.forward(req, res);
					}else {
						System.out.println(session.getAttribute("otp"));
						if(session.getAttribute("otp")==null)
						{
							AsyncContext asyncContext = req.startAsync(req, res);
							asyncContext.setTimeout(600000);
							req.setAttribute("transactionid", transactionid);
							rd=req.getRequestDispatcher("/pages/verifyMobile.jsp");
							rd.forward(req, res);
							//int otp=123456;
							Random rand = new Random(); 
							int otpnumber=rand.nextInt(900000)+100000;
//							otpnumber=123456;
							session.setAttribute("otp", otpnumber);
							//applicationFormBean.setMobileNumber("8008889517");
							// Insert otp logs in db
							ApplicationFormDAO applicationFormDAO=new ApplicationFormDAO();
							//String smsText="Your one time password is "+otpnumber+".Please do not share this password with anyone-RRC CHENNAI";
							String smsText="Your one time password is "+otpnumber+". Please do not share this password with anyone-RECTDV";
//							applicationFormDAO.otplogs(applicationFormBean, req.getRemoteAddr(), smsText, otpnumber,"Verify Mobile OTP");
							asyncContext.start(new AsyncOTPRunner(asyncContext,applicationFormBean.getMobileNumber(),smsText,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
							asyncContext.start(new CreateOTPMailTemplateSB(asyncContext,applicationFormBean,req.getRemoteAddr(),req.getHeader("User-Agent"),otpnumber+""));
						}else{
							rd=req.getRequestDispatcher("/pages/verifyMobile.jsp");
							rd.forward(req, res);
						}
					}
				}else {
					rd=req.getRequestDispatcher("/sessionTimeoutPage.jsp");
					rd.forward(req, res);
				}
			}else{
				rd=req.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(req, res);
			}
		}
		catch(Exception ex)
		{
			//LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationInstructionsServlet", ex.getMessage(), null, req.getRemoteAddr());
			ex.printStackTrace();
			//throw new UserDefineException();
		}
	}

}