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

import com.ttil.bean.AppDataBean;
import com.ttil.bean.ApplicationFormBean;
import com.ttil.dao.ApplicationFormDAO;
import com.ttil.util.AsyncOTPRunner;
import com.ttil.util.CreateRegMailTemplateSB;
import com.ttil.util.StringUtils;

import java.util.Random;
import com.ttil.util.CreateOTPMailTemplateSB;

/**
 * @author Timing Technologies India Pvt Ltd
 *         In ApplicationSave Servlet after checking Data in DB will return flag
 *         if it returns any flag less than 0 then redirects to Preview page
 *         other wise Data will save into database and
 *         SMS will be sent asynchronously and Redirects to UploadPhotoSignature
 *         Page
 */
@WebServlet(asyncSupported = true)
public class ApplicationAfterSaveServlet extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;

	public void dopost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		this.service(req, res);
	}

	public void service(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;
		ApplicationFormBean applicationFormBean = null;
		// PostsBean postBean=null;
		try {
			// checking if session is null or not and is there a fresh new session ,then it
			// proceeds further.
			HttpSession session = request.getSession();
			if (session != null && session.isNew()) {
				rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, res);
			} else {
				String requestFrom = (String) session.getAttribute("requestFromSession");
				if (requestFrom != null && "applicationSave".equalsIgnoreCase(requestFrom)) // Checking weather request
																							// is correct or not
				{
					applicationFormBean = (ApplicationFormBean) session.getAttribute("ApplicationFormBean");
					// postBean=(PostsBean)session.getAttribute("postDetails");
					if (applicationFormBean != null && applicationFormBean.getMobileNumber() != null) // Checking Bean
																										// object
					{
						int transaction_id = applicationFormBean.getTransactionid();
						if (transaction_id < 0) {
							if (transaction_id == -4) {
								applicationFormBean.setMessage("It seems Database Server is busy , please try again.");
							} else {
								if (transaction_id == -3) {
									applicationFormBean.setMessage(
											"Mobile number & Email address already registered for this Advertisement");
								}
								if (transaction_id == -1) {
									applicationFormBean
											.setMessage("Mobile number already registered for this Advertisement");
								}
								if (transaction_id == -2) {
									applicationFormBean
											.setMessage("Email address already registered for this Advertisement");
								}
								if (transaction_id == -5) {
									applicationFormBean.setMessage1(
											"Your details (Name, Fathername, Mothername,DOB, Identity Type, Identity Number ) already registered for this Advertisement");
								}
							}
							applicationFormBean.setNoOfRequests(applicationFormBean.getNoOfRequests() + 1);
							rd = request.getRequestDispatcher("/pages/confirmdetails.jsp");
							rd.forward(request, res);
						} else {
							ApplicationFormDAO applicationFormDAO = new ApplicationFormDAO();
							/** This method will save the form data into the database **/
							int final_transaction_id = applicationFormDAO.updateData(applicationFormBean,
									request.getRemoteAddr(), 1, 1, request.getHeader("User-Agent"));
							applicationFormBean.setTransactionid(final_transaction_id);
							// System.out.println("final_transaction_id="+final_transaction_id);
							if (final_transaction_id > 0) {
								session.removeAttribute("requestFromSession");
								request.setAttribute("final_transaction_id", final_transaction_id);
								applicationFormBean.setApplication_status("FINISHED");
								request.setAttribute("ApplicationFormBean", applicationFormBean);
								// session.removeAttribute("ApplicationFormBean");
								session.removeAttribute("postDetails");
								session.removeAttribute("requestFromSession");
								// session.setAttribute("requestFromSession", "applicationAfterSave");
								/*
								 * request.setAttribute("postDetails", postBean);
								 * 
								 * session.removeAttribute("ApplicationFormBean");
								 * session.removeAttribute("postDetails");
								 * session.removeAttribute("requestFromSession");
								 */
								// session.invalidate();
								// LogsGeneration.generateFormSuccessLog(applicationFormBean.getTransactionid(),
								// applicationFormBean.getMobileNumber(),request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId());
								// rd=request.getRequestDispatcher("/pages/transaction.jsp");
								
								AppDataBean appDataBean=new AppDataBean();
								appDataBean.setTransactionid(applicationFormBean.getTransactionid());
								appDataBean.setEdit(true);
								appDataBean.setFee_amount(applicationFormBean.getTotalFeeAmount());
								session.setAttribute("AppDataBean", appDataBean);

								Random rand = new Random(); 
								int otpnumber=rand.nextInt(900000)+100000;
//								otpnumber=123456;
								session.setAttribute("otp", otpnumber);
								
								AsyncContext asyncContext = request.startAsync(request, res);
								asyncContext.setTimeout(600000);
								rd = request.getRequestDispatcher("/pages/verifyMobile.jsp");

								rd.forward(request, res);
								// System.out.println("Sending SMs");
								
								asyncContext.start(new AsyncOTPRunner(asyncContext,applicationFormBean.getMobileNumber(),"Your one time password is "+otpnumber+". Please do not share this password with anyone-RECTDV",request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId()));
								asyncContext.start(new CreateOTPMailTemplateSB(asyncContext,applicationFormBean,request.getRemoteAddr(),request.getHeader("User-Agent"),otpnumber+""));
								
								String postShortName = StringUtils.getPostShortName(
										ESAPI.encoder().canonicalize(applicationFormBean.getPost_selected_name()));
//								if (applicationFormBean.isPayExempted()) {
//									asyncContext.start(new AsyncOTPRunner(asyncContext,
//											applicationFormBean.getMobileNumber(),
//											"You Successfully Applied for Recruitment of " + postShortName + " under "
//													+ applicationFormBean.getCommunity() + " Cat. with Reg Id:"
//													+ applicationFormBean.getTransactionid() + " and password:"
//													+ ESAPI.encoder().canonicalize(applicationFormBean.getPassword())
//													+ ", please upload photo and sign- SSB",
//											request.getRemoteAddr(), request.getHeader("User-Agent"), session.getId()));
//									// asyncContext.start(new
//									// CreateRegMailTemplateSB(asyncContext,applicationFormBean,request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId()));
//								} else {
//									asyncContext.start(new AsyncOTPRunner(asyncContext,
//											applicationFormBean.getMobileNumber(),
//											"You Successfully Applied for Recruitment of " + postShortName + " under "
//													+ applicationFormBean.getCommunity() + " Cat. with Reg Id:"
//													+ applicationFormBean.getTransactionid() + " and password:"
//													+ ESAPI.encoder().canonicalize(applicationFormBean.getPassword())
//													+ ", please pay fee- SSB",
//											request.getRemoteAddr(), request.getHeader("User-Agent"), session.getId()));
//									// asyncContext.start(new
//									// CreateRegMailTemplateSB(asyncContext,applicationFormBean,request.getRemoteAddr(),request.getHeader("User-Agent"),session.getId()));
//
//								}

							} else if (final_transaction_id == -4) {
								applicationFormBean.setNoOfRequests(applicationFormBean.getNoOfRequests() + 1);
								request.setAttribute("message", "It seems Database Server is busy , please try again.");
								rd = request.getRequestDispatcher("/pages/confirmdetails.jsp");
								rd.forward(request, res);
							} else {
								applicationFormBean.setNoOfRequests(applicationFormBean.getNoOfRequests() + 1);
								request.setAttribute("message", "Application Details not saved, please try again");
								rd = request.getRequestDispatcher("/pages/confirmdetails.jsp");
								rd.forward(request, res);
							}
						}
					} else {
						rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
						rd.forward(request, res);
					}
				} else {
					rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
					rd.forward(request, res);
				}
			}
		} catch (Exception ex) {
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*
			 * if(applicationFormBean!=null)
			 * LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationAfterSave",
			 * exceptionAsString, applicationFormBean.getMobileNumber(),
			 * request.getRemoteAddr(),request.getHeader("User-Agent"));
			 * else
			 * LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationAfterSave",
			 * exceptionAsString, null,
			 * request.getRemoteAddr(),request.getHeader("User-Agent"));
			 * throw new UserDefineException("ApplicationAfterSave", exceptionAsString);
			 */
		}
	}

}
