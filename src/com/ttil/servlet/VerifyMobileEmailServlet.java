package com.ttil.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.owasp.esapi.ESAPI;

import com.ttil.bean.ApplicationFormBean;
import com.ttil.dao.ApplicationFormDAO;
import com.ttil.dao.ApplicationSearchDAO;
import com.ttil.util.AsyncOTPRunner;
import com.ttil.util.CreateRegMailTemplateSB;

@WebServlet(asyncSupported=true)
public class VerifyMobileEmailServlet extends HttpServlet {

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
		String requestFrom=req.getParameter("requestFrom1");
		try{
			String req_transactionid=req.getParameter("transactionid");
			int transactionid=0;
			if(req_transactionid!=null)
				transactionid=Integer.parseInt(req_transactionid);

			ApplicationFormBean applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
			if(applicationFormBean!=null && applicationFormBean.getTransactionid()==transactionid){
				if(applicationFormBean.isOtpValidated()) {
					req.setAttribute("final_transaction_id", transactionid);
					rd=req.getRequestDispatcher("/pages/applicationStatus.jsp");
					rd.forward(req, res);
				}
				else {
					if(session.getAttribute("otp")!=null)
					{
						int otp=(Integer)session.getAttribute("otp");
						String enteredOtp=req.getParameter("enteredOtp");
//						int otp=123456; 
						if(enteredOtp!=null && enteredOtp.equalsIgnoreCase(otp+""))
						{

								ApplicationFormDAO applicationFormDAO=new ApplicationFormDAO();
								String message=null;
								message=applicationFormDAO.verifyMobile(applicationFormBean, req.getRemoteAddr(),otp,"Email Verification");
								if("Success".equalsIgnoreCase(message)){
									applicationFormBean.setOtpValidated(true);
									session.setAttribute("ApplicationFormBean", applicationFormBean);
									session.removeAttribute("otp");
									
									ApplicationSearchDAO applicationSearchDAO=new ApplicationSearchDAO();
									//session.removeAttribute("requestFromSession");
									req.setAttribute("final_transaction_id", transactionid);
									 
									/** AppDataBean appDataBean=new AppDataBean();
									appDataBean.setTransactionid(applicationFormBean.getTransactionid());
									appDataBean.setFee_amount(applicationFormBean.getFee_amount());
									session.setAttribute("AppDataBean", appDataBean);
									**/
									
//									AsyncContext asyncContext = req.startAsync(req, res);
//									asyncContext.setTimeout(600000);
									rd=req.getRequestDispatcher("/pages/applicationStatus.jsp");
									rd.forward(req, res);
//									asyncContext.start(new AsyncOTPRunner(asyncContext,applicationFormBean.getMobileNumber(),"You have successfully registered for the post of UPPRPB SI with username:"+applicationFormBean.getTransactionid()+" and password:"+ESAPI.encoder().canonicalize(applicationFormBean.getDob())+"-ETRP",req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
//									asyncContext.start(new CreateRegMailTemplateSB(asyncContext,applicationFormBean,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
									
									
									//rd=req.getRequestDispatcher("/pages/applicationStatus.jsp");
									//rd.forward(req, res);
								}else{
									
									req.setAttribute("final_transaction_id", transactionid);
									req.setAttribute("message",message);
									applicationFormBean.setMessage(message);
									rd=req.getRequestDispatcher("/pages/verifyMobile.jsp");
									rd.forward(req, res);
								}
							 

						}else{
							req.setAttribute("final_transaction_id", transactionid);
							//applicationFormBean.setMessage("Please type the exact characters as shown in the image.");
							applicationFormBean.setMessage("Please enter correct One-Time Password sent to your emailaddress");
							applicationFormBean.setMessage1("");
							rd=req.getRequestDispatcher("/pages/verifyMobile.jsp");
							rd.forward(req, res);
						}

					}else{
						rd=req.getRequestDispatcher("/sessionTimeoutPage.jsp");
						rd.forward(req, res);
					}
				}
			}else{
				rd=req.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(req, res);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			//LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationInstructionsServlet", ex.getMessage(), null, req.getRemoteAddr());
			//ex.printStackTrace();
			//throw new UserDefineException();
		}
	}
	
}