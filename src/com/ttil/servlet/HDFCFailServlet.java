package com.ttil.servlet;

import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccavenue.security.AesCryptUtil;

public class HDFCFailServlet extends HttpServlet {

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
			String workingKey = "08EC69461C2336D5BE9AEA36591A0E4F";		//32 Bit Alphanumeric Working Key should be entered here so that data can be decrypted.
			String encResp= req.getParameter("encResp");
			//Response=order_id=1000001&tracking_id=307003644241&bank_ref_no=8683992421280730&order_status=Success&failure_message=&payment_mode=Credit Card&card_name=MasterCard&status_code=null&status_message=CAPTURED&currency=INR&amount=1.0&billing_name=raju&billing_address=Santacruz&billing_city=Mumbai&billing_state=MH&billing_zip=400054&billing_country=India&billing_tel=0229874789&billing_email=testing@domain.com&delivery_name=null&delivery_address=null&delivery_city=null&delivery_state=null&delivery_zip=null&delivery_country=null&delivery_tel=null&merchant_param1=additional Info&merchant_param2=additional Info&merchant_param3=additional Info&merchant_param4=additional Info&merchant_param5=additional Info&vault=N&offer_type=null&offer_code=null&discount_value=0.0&mer_amount=1.0&eci_value=null&retry=N&response_code=0&billing_notes=&trans_date=14/03/2018 12:42:35&bin_country=UNITED STATES
			AesCryptUtil aesUtil=new AesCryptUtil(workingKey);
			String decResp = aesUtil.decrypt(encResp);
			//System.out.println("Fail decResp="+decResp);
			StringTokenizer tokenizer = new StringTokenizer(decResp, "&");
			Hashtable hs=new Hashtable();
			String pair=null, pname=null, pvalue=null;
			String bank_ref_no=null,order_id="",failure_message="",status_message="",order_status="";
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
					}
				}
			}
			req.setAttribute("responseHS", hs);
			req.setAttribute("bank_ref_no", bank_ref_no);
			req.setAttribute("order_id", order_id);
			req.setAttribute("failure_message", failure_message);
			req.setAttribute("status_message", status_message);
			req.setAttribute("order_status", order_status);
			rd=req.getRequestDispatcher("/pages/hdfcfail.jsp");
			rd.forward(req, res);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
