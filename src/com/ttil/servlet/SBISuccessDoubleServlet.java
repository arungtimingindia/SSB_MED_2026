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
 */
@WebServlet(asyncSupported=true)
public class SBISuccessDoubleServlet extends HttpServlet {

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
			String responseParameter=req.getParameter("encStatusData");
			String key="ckaqU2OBuU/ArZKLvyBAKQ==";
			String DecryptTrans="";
			try
			{
				System.out.println("Double Verification Encrypted="+responseParameter);
				if(responseParameter!=null){
					DecryptTrans=AES128Bit.decrypt(responseParameter, key);
					if(DecryptTrans!=null){}
					System.out.println("Double Verification Decrypted="+DecryptTrans);
					req.setAttribute("ResponsePayment", DecryptTrans);
					rd=req.getRequestDispatcher("/pages/sbisuccess.jsp");
					rd.forward(req, res);
				}
			}
			catch(Exception e){e.printStackTrace();}

			//1111013|4914128952901|SUCCESS|2|INR|NB|Other|Y|SBIT|000071581|2017-10-03 16:51:16|IN|SBIN4914128952901|1000344|0.00^0.00|||||||||
			//2222298|6622453407001|SUCCESS|100|INR|NB|Other|Y|SBIT|000071581|2017-09-27 17:14:37|IN|SBIN6622453407001|1000344|0.00^0.00|||||||||

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
