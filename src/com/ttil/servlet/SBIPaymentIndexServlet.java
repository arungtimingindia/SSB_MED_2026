package com.ttil.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author Timing Technologies India Pvt Ltd
 * This is the testing class for SBI Payment gateway (Not using)
 */
public class SBIPaymentIndexServlet extends HttpServlet {

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
			rd=req.getRequestDispatcher("/pages/pay1.jsp");
			rd.forward(req, res);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
