package com.ttil.servlet;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toml.dp.util.AES128Bit;
import com.ttil.bean.AppDataBean;
import com.ttil.dao.ApplicationFormDAO;

/**
 * Servlet implementation class PaymentGatewayServlet
 * This class send the request to SBI Payment gateway with encrypted request
 */
@WebServlet("/SBIPaymentGatewayServlet")
public class SBIPaymentGatewayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SBIPaymentGatewayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.service(request, response);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		RequestDispatcher rd=null;
		AppDataBean appDataBean =(AppDataBean)session.getAttribute("AppDataBean");
		try{
			String req_transactionid=request.getParameter("transactionid");
			int transactionid=0;
			if(req_transactionid!=null)
				transactionid=Integer.parseInt(req_transactionid);
			if(appDataBean!=null && appDataBean.getTransactionid()==transactionid){

				ApplicationFormDAO applicationFormDAO=new ApplicationFormDAO();
				//int responseId=applicationFormDAO.checkDuplicateRecord(applicationFormBean);
				int responseId=0;
				if(responseId>=0){
					int order_id=applicationFormDAO.createPaymentOrder(appDataBean, "SBI", request.getRemoteAddr());
					if(order_id>0){
						// SBI key
						String key="ckaqU2OBuU/ArZKLvyBAKQ=="; // key provided by sbi

						String EncryptTrans="";
						String requestParameter="1000420|DOM|IN|INR|"+appDataBean.getFee_amount()+"|"+transactionid+"|https://applyssb.com/SSB_SI/sbisuccess|https://applyssb.com/SSB_SI/sbifail|SBIEPAY|"+order_id+"|"+transactionid+"|NB|ONLINE|ONLINE";
						//String requestParameter="1000420|DOM|IN|INR|"+appDataBean.getFee_amount()+"|"+transactionid+"|http://54.151.253.85:86/SSB_Online_V1/sbisuccess|http://54.151.253.85:86/SSB_Online_V1/sbifail|SBIEPAY|"+order_id+"|"+transactionid+"|NB|ONLINE|ONLINE";
						//System.out.println(requestParameter);
						EncryptTrans=AES128Bit.encrypt(requestParameter, key); // encrtpting the request with the sbi key
						EncryptTrans=EncryptTrans.replaceAll("\n", "");
						request.setAttribute("EncryptTrans", EncryptTrans);

						rd=request.getRequestDispatcher("/pages/sbipay.jsp");
						rd.forward(request, response);
					}else{
						request.setAttribute("message", "Your details (Name, Fathername, Mothername,DOB or mobilenumber or emailaddress) already submitted for this Advertisement, you can not submit again");
						rd = request.getRequestDispatcher("/double_candidate.jsp");
						rd.forward(request, response);
					}
				}else{
					rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
					rd.forward(request, response);
				}
			}else{
				rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
