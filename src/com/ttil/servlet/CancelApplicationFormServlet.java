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
import com.ttil.util.AsyncOTPRunner;

@WebServlet(asyncSupported=true)
public class CancelApplicationFormServlet extends HttpServlet {

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

				if(session.getAttribute("otp")!=null)
				{
					int otp=(Integer)session.getAttribute("otp");
					String enteredOtp=req.getParameter("enteredOtp");
					//int otp=123456;
					if(enteredOtp!=null && enteredOtp.equalsIgnoreCase(otp+""))
					{
						if(req.getParameter("qual_8_option_1")!=null) {
							applicationFormBean.setQualification1 (ESAPI.encoder().encodeForHTMLAttribute(req.getParameter("qual_8_option_1").trim()));
							applicationFormBean.setQualification1_text("Tenth or Matriculation Examination Pass with Science as main subject from a recognized Board or University");
						} else {
							applicationFormBean.setQualification1(null);
							applicationFormBean.setQualification1_text(null);
						}

						if(req.getParameter("qual_8_option_2")!=null) {
							applicationFormBean.setQualification2 (ESAPI.encoder().encodeForHTMLAttribute(req.getParameter("qual_8_option_2").trim()));
							applicationFormBean.setQualification2_text("One year experience in treatment of different species of animals, in a recognized Veterinary Hospital.");
						} else {
							applicationFormBean.setQualification2(null);
							applicationFormBean.setQualification2_text(null);
						}

						if("Yes".equalsIgnoreCase(applicationFormBean.getQualification1())){


							ApplicationFormDAO applicationFormDAO=new ApplicationFormDAO();
							String message=null;
							message=applicationFormDAO.changePost(applicationFormBean, req.getRemoteAddr());
							if("Success".equalsIgnoreCase(message)){
								applicationFormBean.setPost_selected_name("Constable (Veterinary)");
								applicationFormBean.setPost_applied("9");
								session.setAttribute("ApplicationFormBean", applicationFormBean);
								session.removeAttribute("otp");
								req.setAttribute("message","The Post modification requested by you is SUCCESSFULLY SUBMITTED");
								applicationFormBean.setMessage("The Post modification requested by you is SUCCESSFULLY SUBMITTED");
								AsyncContext asyncContext = req.startAsync(req, res);
								asyncContext.setTimeout(600000);
								rd=req.getRequestDispatcher("/pages/successCancellation.jsp");
								rd.forward(req, res);
								asyncContext.start(new AsyncOTPRunner(asyncContext,applicationFormBean.getMobileNumber(),"You have successfully changed the post to Constable (Veterinary) for Recruitment of 338/RC/SSB/Combined Advt./2020 with Reg Id: "+applicationFormBean.getTransactionid(),req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
								//asyncContext.start(new CreateCancelMailTemplateSB(asyncContext,applicationFormBean,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
							}else{
								req.setAttribute("message",message);
								applicationFormBean.setMessage1(message);
								rd=req.getRequestDispatcher("/pages/changePost.jsp");
								rd.forward(req, res);
							}
						}else{
							req.setAttribute("message","You are not eligible for Constable (Veterinary) as per your Qualifications.");
							applicationFormBean.setMessage1("You are not eligible for Constable (Veterinary) as per your Qualifications.");
							rd=req.getRequestDispatcher("/pages/changePost.jsp");
							rd.forward(req, res);
						}

					}else{
						//applicationFormBean.setMessage("Please type the exact characters as shown in the image.");
						applicationFormBean.setMessage("Please enter correct One-Time Password sent to your mobile");
						applicationFormBean.setMessage1("");
						rd=req.getRequestDispatcher("/pages/cancelApplicationForm.jsp");
						rd.forward(req, res);
					}

				}else{
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
			//ex.printStackTrace();
			//throw new UserDefineException();
		}
	}

}
