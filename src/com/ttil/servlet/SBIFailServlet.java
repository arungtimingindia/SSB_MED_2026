package com.ttil.servlet;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toml.dp.util.AES128Bit;
import com.ttil.bean.ApplicationFormBean;
import com.ttil.bean.PaymentBean;
import com.ttil.dao.ApplicationFormDAO;
import com.ttil.dao.ApplicationSearchDAO;
/**
 * @author Timing Technologies India Pvt Ltd
 * This is browser response Class
 * This class will called by SBI Payment gateway when the payment is failed or cancelled
 * And will process the response  and store into database.
 * Sample response : 2222298|6622453407001|FAIL|100|INR|NB|Other|Y|SBIT|000071581|2017-09-27 17:14:37|IN|SBIN6622453407001|1000420|0.00^0.00|||||||||
 */
@WebServlet(asyncSupported=true)
public class SBIFailServlet extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;

	public void dopost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException
	{

		this.service(req, res);
	}

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		RequestDispatcher rd=null;
		try{
			HttpSession session = req.getSession();
			String responseParameter=req.getParameter("encData"); // sbi payment response
			String key="ckaqU2OBuU/ArZKLvyBAKQ=="; // sbi key
			String DecryptTrans="";
			DecryptTrans=AES128Bit.decrypt(responseParameter, key); // decrypting the response
			req.setAttribute("ResponsePayment", DecryptTrans);
System.out.println(DecryptTrans);
			if(DecryptTrans!=null){
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
				ApplicationFormDAO applicationFormDAO=new ApplicationFormDAO();
				ApplicationSearchDAO applicationSearchDAO=new ApplicationSearchDAO();

				String payment_status=null;
				payment_status=applicationSearchDAO.getPaymentStatus(res_transactionid);

				ApplicationFormBean	applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
				/** If the response RegistrationId and Session object  registrationId is same, then it will do nothing other wise
				 * it will fetch full candidate details  
				 */
				if(applicationFormBean!=null && res_transactionid==applicationFormBean.getTransactionid())
				{
				}else{
					applicationFormBean=applicationSearchDAO.getData( res_transactionid,"Post");
					session.setAttribute("ApplicationFormBean", applicationFormBean);
				}
				 /** First will check weather any  earlier payments successful or not. If  successful then redirects to success page otherwise save the payment details into database and redirects to Failure page **/ 
				
				if(payment_status!=null &&  "SUCCESS".equalsIgnoreCase(payment_status)){  
					applicationFormBean.setPayment_status(payment_status);
					session.setAttribute("requestFromSession1", "SBIPayment");
					session.setAttribute("SBIPayTransactionId", applicationFormBean.getTransactionid());
					res.sendRedirect("paymentSuccess");
				}else{

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
					applicationFormBean.setPayment_status(paymentBean.getRes_status());
					
					/** This method will save the payment data into the database **/
					applicationFormDAO.saveSBIPaymentsData(paymentBean,applicationFormBean,req.getRemoteAddr());

					req.setAttribute("responseHS", "");
					req.setAttribute("bank_ref_no", "");
					req.setAttribute("order_id", res_order_id+"".toString());
					req.setAttribute("failure_message", res_reason);
					req.setAttribute("status_message", "");
					req.setAttribute("order_status", res_status);
					
					rd=req.getRequestDispatcher("/pages/sbifail.jsp");
					rd.forward(req, res);
				}
			}else{
				rd=req.getRequestDispatcher("/pages/sbifail.jsp");
				rd.forward(req, res);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
