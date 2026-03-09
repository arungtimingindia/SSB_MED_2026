package com.ttil.servlet;

import java.io.IOException;
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
 * This is Server to Server response Class
 * This Push Response class will called by SBI Payment gateway backend for Service to Service Response Saving. This will useful if any browser response is Failure
 * And will process the response  and store into database.
 *  SMS & email will send to the candidate if browser response not sent
 * Sample response : 2222298|6622453407001|SUCCESS|100|INR|NB|Other|Y|SBIT|000071581|2017-09-27 17:14:37|IN|SBIN6622453407001|1000420|0.00^0.00|||||||||
 */
@WebServlet(asyncSupported=true)
public class SBIPushResponseServlet extends HttpServlet {

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
			String key="ckaqU2OBuU/ArZKLvyBAKQ=="; // sbi key
			String DecryptTrans="";
			//System.out.println("Push response Response"+responseParameter);
			if(responseParameter!=null){
				DecryptTrans=AES128Bit.decrypt(responseParameter, key); // decrypting the response
				//System.out.println(DecryptTrans);
				if(DecryptTrans!=null){
					try
					{
						StringTokenizer st=new StringTokenizer(DecryptTrans,"|"); // Split the response with | symbol
						int res_order_id=Integer.parseInt(st.nextToken());
						String res_bank_ref_id=st.nextToken();
						String res_status=st.nextToken();
						String res_amount=st.nextToken();
						String currency=st.nextToken();
						String res_paymode=st.nextToken();
						int res_transactionid=Integer.parseInt(st.nextToken());
						//String other_details=st.nextToken();
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
						/** This method will get the payment status of earlier payments and  will check weather any  earlier payments successful or not. If not successful then save the payment details into database and sends the SMS & Email  and redirects to ApplicationStatus Page**/ 
						payment_status=applicationSearchDAO.getPaymentStatus(res_transactionid);
						if(payment_status!=null &&  "SUCCESS".equalsIgnoreCase(payment_status)){  

						}else{  // at the of live uncomment
							ApplicationFormBean	applicationFormBean=null;
							if(res_order_id>=40000003){

							}else{
								applicationFormBean=applicationSearchDAO.getData(res_transactionid,"Payment");
							}
							//LogsGeneration.generateAccessLog("SBI Payment Push Response",applicationFormBean.getMobileNumber(),applicationFormBean.getTransactionid(), req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId());
							PaymentBean paymentBean=new PaymentBean();

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
							paymentBean.setResponseType("Push Response");
							paymentBean.setCurrency(currency);
							paymentBean.setCountry(country);
							paymentBean.setTrans_fee(trans_fee);
							paymentBean.setMerchantId(merchantId);
							if(applicationFormBean!=null)
								applicationFormBean.setPayment_status(paymentBean.getRes_status());

							/** This method will save the payment data into the database **/
							if(res_order_id>=40000003){
								applicationFormDAO.saveSBIPaymentsData1(paymentBean,applicationFormBean,req.getRemoteAddr());
							}else{
								applicationFormDAO.saveSBIPaymentsData(paymentBean,applicationFormBean,req.getRemoteAddr());
								if(res_status!=null && "SUCCESS".equalsIgnoreCase(res_status)){
									AsyncContext asyncContext = req.startAsync(req, res);
									asyncContext.setTimeout(600000);
									String postShortName=StringUtils.getPostShortName(ESAPI.encoder().canonicalize(applicationFormBean.getPost_selected_name()));
									asyncContext.start(new AsyncOTPRunner(asyncContext,applicationFormBean.getMobileNumber(),"You have paid INR "+applicationFormBean.getFee_amount()+".00 for Recruitment of "+postShortName+" under "+applicationFormBean.getCommunity()+" Cat. with Reg Id:"+applicationFormBean.getTransactionid()+" - SSB" ,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
									//asyncContext.start(new CreatePaymentMailTemplateSB(asyncContext,applicationFormBean,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));

								}
							}


						}
					}
					catch(Exception e){e.printStackTrace();}
				}
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
