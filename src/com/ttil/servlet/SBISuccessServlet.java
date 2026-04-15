package com.ttil.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.owasp.esapi.ESAPI;

import com.toml.dp.util.AES128Bit;
import com.ttil.bean.ApplicationFormBean;
import com.ttil.bean.PaymentBean;
import com.ttil.dao.ApplicationFormDAO;
import com.ttil.dao.ApplicationSearchDAO;
import com.ttil.util.AsyncOTPRunner;
import com.ttil.util.CreatePaymentMailTemplateSB;
import com.ttil.util.StringUtils;
/**
 * @author Timing Technologies India Pvt Ltd
 * This is browser response Class
 * This class will called by SBI Payment gateway when the payment is successful
 * And will process the response  and store into database.
 *  SMS & email will send to the candidate
 * Sample response : 2222298|6622453407001|SUCCESS|100|INR|NB|Other|Y|SBIT|000071581|2017-09-27 17:14:37|IN|SBIN6622453407001|1000420|0.00^0.00|||||||||
 */
@WebServlet(asyncSupported=true)
public class SBISuccessServlet extends HttpServlet {

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
		try{
			String responseParameter=req.getParameter("encData"); // sbi payment response
			String key="ckaqU2OBuU/ArZKLvyBAKQ==";  // sbi key
			String DecryptTrans="";
			DecryptTrans=AES128Bit.decrypt(responseParameter, key); // decrypting the response
			req.setAttribute("ResponsePayment", DecryptTrans);
			ApplicationFormBean	applicationFormBean=null;


			applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
			StringTokenizer st=new StringTokenizer(DecryptTrans,"|"); // Split the response with | symbol
			int res_order_id=Integer.parseInt(st.nextToken());
			String res_bank_ref_id=st.nextToken();
			String res_status=st.nextToken();
			String res_amount=st.nextToken();
			String currency=st.nextToken();
			String res_paymode=st.nextToken();
			//String other_details=st.nextToken();
			int res_transactionid=Integer.parseInt(st.nextToken());
			String res_reason=st.nextToken();
			String res_bankCode=st.nextToken();
			String res_bank_ref_no=st.nextToken();
			String res_trans_date_time=st.nextToken();
			String country=st.nextToken();
			String res_cin=st.nextToken();
			String merchantId=st.nextToken();
			String trans_fee=st.nextToken();

			String payment_status=null;
			ApplicationFormDAO applicationFormDAO=new ApplicationFormDAO();
			ApplicationSearchDAO applicationSearchDAO=new ApplicationSearchDAO();
			String payment_status_edit=null;
			/** If the response RegistrationId and Session object  registrationId is same, then it will get only payment status other wise
			 * it will fetch full candidate details for sending email & SMS 
			 */
			if(applicationFormBean!=null && res_transactionid==applicationFormBean.getTransactionid())
			{
				payment_status_edit=applicationSearchDAO.getPaymentStatusEdit(res_transactionid);
				payment_status=applicationSearchDAO.getPaymentStatus(res_transactionid);
			}else{
				applicationFormBean=applicationSearchDAO.getData( res_transactionid,"post");
				session.setAttribute("ApplicationFormBean", applicationFormBean);
				payment_status=applicationFormBean.getPayment_status();
				payment_status_edit=applicationFormBean.getPaymentStatusEdit();
			}
			
			boolean updatePayment=false;
			
			if (applicationFormBean.isEditCompleted()) {
				if(payment_status_edit!=null &&  "SUCCESS".equalsIgnoreCase(payment_status_edit)){
					applicationFormBean.setPaymentStatusEdit(payment_status_edit);
				} else {
					applicationFormBean.setPaymentStatusEdit(res_status);
					updatePayment=true;

				}
			} else {
				if (payment_status != null && "SUCCESS".equalsIgnoreCase(payment_status)) {
					applicationFormBean.setPayment_status(payment_status);
				} else {
					applicationFormBean.setPayment_status(res_status);
					updatePayment=true;
				}
			}
			
			if(updatePayment) {
				PaymentBean paymentBean=new PaymentBean();
				//LogsGeneration.generateAccessLog("SBI Payment Success",applicationFormBean.getMobileNumber(),applicationFormBean.getTransactionid(), req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId());
				paymentBean.setRes_transactionid(res_transactionid);
				paymentBean.setRes_orderid(res_order_id);
				paymentBean.setRes_amount(res_amount);
				paymentBean.setRes_bank_ref_id(res_bank_ref_id);
				paymentBean.setRes_bank_ref_no(res_bank_ref_no);
				paymentBean.setRes_bankCode(res_bankCode);
				paymentBean.setRes_cin(res_cin);
				paymentBean.setRes_paymode(res_paymode);
				paymentBean.setRes_reason(res_reason);
				paymentBean.setRes_status(res_status);
				paymentBean.setRes_trans_date_time(res_trans_date_time);
				paymentBean.setBank_response(DecryptTrans);
				paymentBean.setResponseType("Browser Response");
				paymentBean.setCurrency(currency);
				paymentBean.setCountry(country);
				//paymentBean.setOther_details(other_details);
				paymentBean.setTrans_fee(trans_fee);
				paymentBean.setMerchantId(merchantId);
				applicationFormDAO.saveSBIPaymentsData(paymentBean, applicationFormBean, req.getRemoteAddr());
				AsyncContext asyncContext = req.startAsync(req, res);
				asyncContext.setTimeout(600000);

				session.setAttribute("requestFromSession1", "SBIPayment");
				session.setAttribute("SBIPayTransactionId", applicationFormBean.getTransactionid());

				rd=req.getRequestDispatcher("/pages/applicationStatus.jsp");
				rd.forward(req, res);
				
	            /** Sending SMS & email **/
				String postShortName=StringUtils.getPostShortName(ESAPI.encoder().canonicalize(applicationFormBean.getPost_selected_name()));
				asyncContext.start(new AsyncOTPRunner(asyncContext,applicationFormBean.getMobileNumber(),"You have paid INR "+applicationFormBean.getFee_amount()+".00 for Recruitment of "+postShortName+" under "+applicationFormBean.getCommunity()+" Cat. with Reg Id:"+applicationFormBean.getTransactionid()+" - SSB" ,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
				//asyncContext.start(new CreatePaymentMailTemplateSB(asyncContext,applicationFormBean,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
			
			}
			else {
				session.setAttribute("requestFromSession1", "SBIPayment");
				session.setAttribute("SBIPayTransactionId", applicationFormBean.getTransactionid());
				res.sendRedirect("paymentSuccess");
			}

            /** First will check weather any  earlier payments successful or not. If not successful then save the payment details into database and sends the SMS & Email  and redirects to ApplicationStatus Page**/ 
//			if(payment_status!=null &&  "SUCCESS".equalsIgnoreCase(payment_status)){
//				applicationFormBean.setPayment_status(payment_status);
//				session.setAttribute("requestFromSession1", "SBIPayment");
//				session.setAttribute("SBIPayTransactionId", applicationFormBean.getTransactionid());
//				res.sendRedirect("paymentSuccess");
//			}else{
//				PaymentBean paymentBean=new PaymentBean();
//				//LogsGeneration.generateAccessLog("SBI Payment Success",applicationFormBean.getMobileNumber(),applicationFormBean.getTransactionid(), req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId());
//				paymentBean.setRes_transactionid(res_transactionid);
//				paymentBean.setRes_orderid(res_order_id);
//				paymentBean.setRes_amount(res_amount);
//				paymentBean.setRes_bank_ref_id(res_bank_ref_id);
//				paymentBean.setRes_bank_ref_no(res_bank_ref_no);
//				paymentBean.setRes_bankCode(res_bankCode);
//				paymentBean.setRes_cin(res_cin);
//				paymentBean.setRes_paymode(res_paymode);
//				paymentBean.setRes_reason(res_reason);
//				paymentBean.setRes_status(res_status);
//				paymentBean.setRes_trans_date_time(res_trans_date_time);
//				paymentBean.setBank_response(DecryptTrans);
//				paymentBean.setResponseType("Browser Response");
//				paymentBean.setCurrency(currency);
//				paymentBean.setCountry(country);
//				//paymentBean.setOther_details(other_details);
//				paymentBean.setTrans_fee(trans_fee);
//				paymentBean.setMerchantId(merchantId);
//				applicationFormBean.setPayment_status(paymentBean.getRes_status());
//
//
//				/** This method will save the payment data into the database **/
//				applicationFormDAO.saveSBIPaymentsData(paymentBean,applicationFormBean,req.getRemoteAddr());
//
//				AsyncContext asyncContext = req.startAsync(req, res);
//				asyncContext.setTimeout(600000);
//
//				session.setAttribute("requestFromSession1", "SBIPayment");
//				session.setAttribute("SBIPayTransactionId", applicationFormBean.getTransactionid());
//
//				rd=req.getRequestDispatcher("/pages/applicationStatus.jsp");
//				rd.forward(req, res);
//				
//                /** Sending SMS & email **/
//				String postShortName=StringUtils.getPostShortName(ESAPI.encoder().canonicalize(applicationFormBean.getPost_selected_name()));
//				asyncContext.start(new AsyncOTPRunner(asyncContext,applicationFormBean.getMobileNumber(),"You have paid INR "+applicationFormBean.getFee_amount()+".00 for Recruitment of "+postShortName+" under "+applicationFormBean.getCommunity()+" Cat. with Reg Id:"+applicationFormBean.getTransactionid()+" - SSB" ,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
//				//asyncContext.start(new CreatePaymentMailTemplateSB(asyncContext,applicationFormBean,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
//
//
//
//			}

		}
		catch(Exception ex){
			ex.printStackTrace();
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
		/*	if(applicationFormBean!=null)
				LogsGeneration.generateErrorLogs("SBI Payment Success", exceptionAsString, applicationFormBean.getMobileNumber(),applicationFormBean.getTransactionid(), req.getRemoteAddr(),req.getHeader("User-Agent"));
			else
				LogsGeneration.generateErrorLogs("SBI Payment Success", exceptionAsString, null,0, req.getRemoteAddr(),req.getHeader("User-Agent"));
		*/
		}
	}

}
