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
/**
 * @author Timing Technologies India Pvt Ltd
 * This class is for Double verification of payment request
 */
@WebServlet("/PaymentGatewayDoubleServlet")
public class PaymentGatewayDoubleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PaymentGatewayDoubleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.service(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.service(request, response);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String key="ckaqU2OBuU/ArZKLvyBAKQ==";
		RequestDispatcher rd=null;
		String transactionid=request.getParameter("transactionid");
		//System.out.println("transactionid in service payment check="+transactionid);
		
		try
		{
				int res_transactionid=Integer.parseInt(transactionid);
				String EncryptTrans="";
				String requestParameter="|1000420|"+res_transactionid+"|https://applyssb.com/SSB_SI/sbisuccessDouble";
				EncryptTrans=AES128Bit.encrypt(requestParameter, key);
				EncryptTrans=EncryptTrans.replaceAll("\n", "");
				request.setAttribute("EncryptTrans", EncryptTrans);
				rd=request.getRequestDispatcher("/pages/sbi_double_verification.jsp");
				rd.forward(request, response);
			

		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
