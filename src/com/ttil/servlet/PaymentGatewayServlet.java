package com.ttil.servlet;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccavenue.security.AesCryptUtil;
import com.ttil.bean.AppDataBean;
import com.ttil.dao.ApplicationFormDAO;

/**
 * @author Timing Technologies India Pvt Ltd
 * servlet implementation class payment gateway
 * This class send the request to HDFC Payment gateway with encrypted request
 */
@WebServlet("/PaymentGatewayServlet")
public class PaymentGatewayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PaymentGatewayServlet() {
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

		String req_transactionid=request.getParameter("transactionid");
		int transactionid=0;
		if(req_transactionid!=null)
			transactionid=Integer.parseInt(req_transactionid);
		//System.out.println("transactionid="+transactionid);
		//System.out.println("appDataBean.getTransactionid()="+appDataBean.getTransactionid());
		if(appDataBean!=null && appDataBean.getTransactionid()==transactionid){

			ApplicationFormDAO applicationFormDAO=new ApplicationFormDAO();
			int order_id=applicationFormDAO.createPaymentOrder(appDataBean, "HDFC", request.getRemoteAddr());
			//System.out.println("order_id="+order_id);
			if(order_id>0){

				/** Start HDFC Payment  Integration Kit**/
				String accessCode= "AVTQ76FC65AL90QTLA";		//Put in the Access Code in quotes provided by CCAVENUES.
				String workingKey = "08EC69461C2336D5BE9AEA36591A0E4F";    //Put in the 32 Bit Working Key provided by CCAVENUES.  
				String ccaRequest="", pname="", pvalue="";
				Random rand = new Random(); 
				int randNo=rand.nextInt(9000)+1000;
				SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");  
				Date date = new Date();  
				String tid=formatter.format(date)+randNo;
				//appDataBean.setFee_amount(1);
				//System.out.println("tid="+tid);
				/*ccaRequest = ccaRequest +"tid="+76013017+"&";*/
				ccaRequest = ccaRequest +"tid="+tid+"&";
				ccaRequest = ccaRequest +"merchant_id=168746&";
				ccaRequest = ccaRequest +"order_id="+order_id+"&";
				ccaRequest = ccaRequest +"currency=INR&";
				ccaRequest = ccaRequest +"amount="+appDataBean.getFee_amount()+"&";
				ccaRequest = ccaRequest +"redirect_url=https://applyssb.com/SSBOnline/paymentsuccess&";
				ccaRequest = ccaRequest +"cancel_url=https://applyssb.com/SSBOnline/paymentfail&";
				ccaRequest = ccaRequest +"language=EN&";
				ccaRequest = ccaRequest +"merchant_param1="+appDataBean.getTransactionid()+"&";
				//System.out.println("ccaRequest="+ccaRequest);
				//promo_code=&billing_state=MH&delivery_name=Sam&order_id=1000001&billing_email=testing@domain.com&customer_identifier=&delivery_state=Maharashtra&currency=INR&delivery_tel=0221234321&billing_country=India&amount=1.00&delivery_country=India&billing_tel=0229874789&delivery_city=Mumbai&tid=&merchant_id=168746&redirect_url=https://applyssb.com/HDFCTestKit/ccavResponseHandler.jsp&cancel_url=https://applyssb.com/HDFCTestKit/ccavResponseHandler.jsp&billing_name=Peter&delivery_address=Vile Parle&delivery_zip=400038&billing_zip=400054&billing_city=Mumbai&merchant_param1=additional Info.&language=EN&merchant_param5=additional Info.&merchant_param4=additional Info.&merchant_param3=additional Info.&merchant_param2=additional Info.&billing_address=Santacruz&
				AesCryptUtil aesUtil=new AesCryptUtil(workingKey);
				String encRequest = aesUtil.encrypt(ccaRequest);
				request.setAttribute("encRequest", encRequest);
				request.setAttribute("accessCode", accessCode);
				rd=request.getRequestDispatcher("/pages/pay.jsp");
				//rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, response);
			}else{
				rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, response);
			}
		}else{
			rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
			rd.forward(request, response);
		}
	}

}
