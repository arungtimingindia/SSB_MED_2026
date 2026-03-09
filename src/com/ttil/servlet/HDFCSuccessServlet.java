package com.ttil.servlet;

import java.io.IOException;
import java.util.Hashtable;
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

import com.ccavenue.security.AesCryptUtil;
import com.ttil.bean.ApplicationFormBean;
import com.ttil.bean.HDFCPaymentBean;
import com.ttil.dao.ApplicationFormDAO;
import com.ttil.dao.ApplicationSearchDAO;
import com.ttil.util.AsyncOTPRunner;
import com.ttil.util.CreatePaymentMailTemplateSB;

@WebServlet(asyncSupported=true)
public class HDFCSuccessServlet extends HttpServlet {

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
			/*String responseParameter=req.getParameter("encData");
			String key="ckaqU2OBuU/ArZKLvyBAKQ==";
			String DecryptTrans="";
			DecryptTrans=AES128Bit.decrypt(responseParameter, key);
			System.out.println(responseParameter);
			System.out.println(DecryptTrans);
			req.setAttribute("ResponsePayment", DecryptTrans);*/

			String workingKey = "08EC69461C2336D5BE9AEA36591A0E4F";		//32 Bit Alphanumeric Working Key should be entered here so that data can be decrypted.
			String encResp= req.getParameter("encResp");
			//Response=order_id=1000001&tracking_id=307003644241&bank_ref_no=8683992421280730&order_status=Success&failure_message=&payment_mode=Credit Card&card_name=MasterCard&status_code=null&status_message=CAPTURED&currency=INR&amount=1.0&billing_name=raju&billing_address=Santacruz&billing_city=Mumbai&billing_state=MH&billing_zip=400054&billing_country=India&billing_tel=0229874789&billing_email=testing@domain.com&delivery_name=null&delivery_address=null&delivery_city=null&delivery_state=null&delivery_zip=null&delivery_country=null&delivery_tel=null&merchant_param1=additional Info&merchant_param2=additional Info&merchant_param3=additional Info&merchant_param4=additional Info&merchant_param5=additional Info&vault=N&offer_type=null&offer_code=null&discount_value=0.0&mer_amount=1.0&eci_value=null&retry=N&response_code=0&billing_notes=&trans_date=14/03/2018 12:42:35&bin_country=UNITED STATES
			AesCryptUtil aesUtil=new AesCryptUtil(workingKey);
			String decResp = aesUtil.decrypt(encResp);
			//System.out.println("Success decResp="+decResp);
			StringTokenizer tokenizer = new StringTokenizer(decResp, "&");
			Hashtable hs=new Hashtable();
			String pair=null, pname=null, pvalue=null;
			String bank_ref_no=null,order_id="",failure_message="",order_status="",status_message="";
			String tracking_id=null;
			String payment_mode=null;
			String card_name=null;
			String status_code=null;
			String currency=null;
			String amount=null;
			String mer_amount=null;
			String response_code=null;
			String trans_date=null;
			String bin_country=null;
			String bank_response=null;
			String responseType=null;
			String merchant_param1=null;
			String merchant_param2=null;
			String vault=null;
			String retry=null;
			String billing_notes=null;
			bank_response=decResp;

			while (tokenizer.hasMoreTokens()) {
				pair = (String)tokenizer.nextToken();
				if(pair!=null) {
					StringTokenizer strTok=new StringTokenizer(pair, "=");
					pname=""; pvalue="";
					if(strTok.hasMoreTokens()) {
						pname=(String)strTok.nextToken();
						if(strTok.hasMoreTokens())
							pvalue=(String)strTok.nextToken();
						hs.put(pname, pvalue);
						if("bank_ref_no".equalsIgnoreCase(pname))
							bank_ref_no=pvalue;
						else if("order_id".equalsIgnoreCase(pname))
							order_id=pvalue;
						else if("order_status".equalsIgnoreCase(pname))
							order_status=pvalue;
						else if("failure_message".equalsIgnoreCase(pname))
							failure_message=pvalue;
						else if("status_message".equalsIgnoreCase(pname))
							status_message=pvalue;
						else if("tracking_id".equalsIgnoreCase(pname))
							tracking_id=pvalue;
						else if("payment_mode".equalsIgnoreCase(pname))
							payment_mode=pvalue;
						else if("card_name".equalsIgnoreCase(pname))
							card_name=pvalue;
						else if("status_code".equalsIgnoreCase(pname))
							status_code=pvalue;
						else if("currency".equalsIgnoreCase(pname))
							currency=pvalue;
						else if("amount".equalsIgnoreCase(pname))
							amount=pvalue;
						else if("mer_amount".equalsIgnoreCase(pname))
							mer_amount=pvalue;
						else if("response_code".equalsIgnoreCase(pname))
							response_code=pvalue;
						else if("trans_date".equalsIgnoreCase(pname))
							trans_date=pvalue;
						else if("bin_country".equalsIgnoreCase(pname))
							bin_country=pvalue;
						else if("vault".equalsIgnoreCase(pname))
							vault=pvalue;
						else if("merchant_param1".equalsIgnoreCase(pname))
							merchant_param1=pvalue;

					}
				}
			}
			int res_transactionid=Integer.parseInt(merchant_param1);
			String payment_status=null;
			ApplicationFormDAO applicationFormDAO=new ApplicationFormDAO();
			ApplicationSearchDAO applicationSearchDAO=new ApplicationSearchDAO();
			ApplicationFormBean applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
			if(applicationFormBean!=null && res_transactionid==applicationFormBean.getTransactionid())
			{
				payment_status=applicationSearchDAO.getPaymentStatus(res_transactionid);
			}else{
				applicationFormBean=applicationSearchDAO.getData( res_transactionid,"post");
				session.setAttribute("ApplicationFormBean", applicationFormBean);
				payment_status=applicationFormBean.getPayment_status();
			}
			
			if(payment_status!=null &&  "SUCCESS".equalsIgnoreCase(payment_status)){
				/*rd=req.getRequestDispatcher("/pages/hdfcsuccess.jsp");
				req.setAttribute("order_id", order_id);
				req.setAttribute("order_status", "Success");
				rd.forward(req, res);*/
				applicationFormBean.setPayment_status(payment_status);
				session.setAttribute("requestFromSession1", "HDFCPayment");
				session.setAttribute("SBIPayTransactionId", applicationFormBean.getTransactionid());
				res.sendRedirect("paymentSuccess");
				
			}else{
				HDFCPaymentBean hdfcPaymentBean=new HDFCPaymentBean();
				hdfcPaymentBean.setAmount(amount);
				hdfcPaymentBean.setBank_ref_no(bank_ref_no);
				hdfcPaymentBean.setBank_response(bank_response);
				hdfcPaymentBean.setBin_country(bin_country);
				hdfcPaymentBean.setCard_name(card_name);
				hdfcPaymentBean.setCurrency(currency);
				hdfcPaymentBean.setFailure_message(failure_message);
				hdfcPaymentBean.setMer_amount(mer_amount);
				hdfcPaymentBean.setOrder_id(order_id);
				hdfcPaymentBean.setOrder_status(order_status);
				hdfcPaymentBean.setPayment_mode(payment_mode);
				hdfcPaymentBean.setResponse_code(response_code);
				hdfcPaymentBean.setStatus_code(status_code);
				hdfcPaymentBean.setStatus_message(status_message);
				hdfcPaymentBean.setTracking_id(tracking_id);
				hdfcPaymentBean.setTrans_date(trans_date);
				hdfcPaymentBean.setVault(vault);
				hdfcPaymentBean.setMerchant_param1(merchant_param1);
				
				applicationFormBean.setPayment_status(hdfcPaymentBean.getOrder_status());
				
				applicationFormDAO.savePaymentsData(hdfcPaymentBean, applicationFormBean, req.getRemoteAddr());
				
				req.setAttribute("responseHS", hs);
				req.setAttribute("bank_ref_no", bank_ref_no);
				req.setAttribute("order_id", order_id);
				req.setAttribute("failure_message", failure_message);
				req.setAttribute("status_message", status_message);
				req.setAttribute("order_status", order_status);
				
				if(order_status!=null && "Success".equalsIgnoreCase(order_status)){
					AsyncContext asyncContext = req.startAsync(req, res);
					asyncContext.setTimeout(600000);
					/*rd=req.getRequestDispatcher("/pages/hdfcsuccess.jsp");
					rd.forward(req, res);*/
					
					session.setAttribute("requestFromSession1", "SBIPayment");
					session.setAttribute("SBIPayTransactionId", applicationFormBean.getTransactionid());
					
					rd=req.getRequestDispatcher("/pages/applicationStatus.jsp");
					rd.forward(req, res);
					
					asyncContext.start(new AsyncOTPRunner(asyncContext,applicationFormBean.getMobileNumber(),"You have paid INR "+applicationFormBean.getFee_amount()+".00 for Recruitment of "+ESAPI.encoder().canonicalize(applicationFormBean.getPost_applied())+" EXAMINATION, 2018 with Reg Id:"+applicationFormBean.getTransactionid() ,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));
					////asyncContext.start(new CreatePaymentMailTemplateSB(asyncContext,applicationFormBean,req.getRemoteAddr(),req.getHeader("User-Agent"),session.getId()));

					//res.sendRedirect("paymentSuccess");
					
				}else{
					rd=req.getRequestDispatcher("/pages/hdfcfail.jsp");
					rd.forward(req, res);
				}
				
				
			}
			//2222298|6622453407001|SUCCESS|100|INR|NB|Other|Y|SBIT|000071581|2017-09-27 17:14:37|IN|SBIN6622453407001|1000420|0.00^0.00|||||||||

			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
