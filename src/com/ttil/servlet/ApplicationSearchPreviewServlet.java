package com.ttil.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccavenue.security.AesCryptUtil;
import com.toml.dp.util.AES128Bit;
import com.ttil.bean.AppDataBean;
import com.ttil.bean.ApplicationFormBean;
import com.ttil.bean.ApplicationSearchBean;
import com.ttil.bean.PostsBean;
import com.ttil.dao.ApplicationSearchDAO;
/**
 * @author Timing Technologies India Pvt Ltd
 * This Class will redirects to applicationStatus page
 */
public class ApplicationSearchPreviewServlet  extends HttpServlet {

	private static final long serialVersionUID = 4267945957957617573L;
	public void dopost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException
	{

		this.service(req, res);
	}

	public void service(HttpServletRequest request,HttpServletResponse res) throws ServletException,IOException
	{
		RequestDispatcher rd=null;
		ApplicationFormBean applicationFormBean=null;
		try{
			HttpSession session = request.getSession();
			/*
			if (session!=null && session.isNew()){
				rd = request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, res);
			}else{*/
			String requestFromSession=(String)session.getAttribute("requestFromSession");
			String requestNo=(String)session.getAttribute("requestNo");
			if(requestFromSession!=null && "applicationSearch".equalsIgnoreCase(requestFromSession))
			{
				int trans_id=(Integer)session.getAttribute("trans_id");
				applicationFormBean=(ApplicationFormBean)session.getAttribute("ApplicationFormBean");
				if(applicationFormBean!=null && applicationFormBean.getTransactionid()==trans_id){
					if(requestNo==null || "".equalsIgnoreCase(requestNo)){
						ApplicationSearchDAO applicationSearchDAO=new ApplicationSearchDAO();
						applicationFormBean=applicationSearchDAO.getData(applicationFormBean.getTransactionid(),101+"");
						session.setAttribute("ApplicationFormBean", applicationFormBean);
					}
					session.removeAttribute("requestNo");
					request.setAttribute("ApplicationFormBean", applicationFormBean);
					
					AppDataBean appDataBean=new AppDataBean();
					appDataBean.setTransactionid(applicationFormBean.getTransactionid());
					appDataBean.setFee_amount(applicationFormBean.getFee_amount());
					session.setAttribute("AppDataBean", appDataBean);
					
				
					rd=request.getRequestDispatcher("/pages/applicationStatus.jsp");
					rd.forward(request, res);
				}else{
					rd=request.getRequestDispatcher("/sessionTimeoutPage.jsp");
					rd.forward(request, res);
				}


			}else{
				rd=request.getRequestDispatcher("/sessionTimeoutPage.jsp");
				rd.forward(request, res);
			}
			//}
		}
		catch(Exception ex)
		{
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			/*if(applicationFormBean!=null)
				LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationSearchPreview", exceptionAsString, applicationFormBean.getMobileNumber(), request.getRemoteAddr(),request.getHeader("User-Agent"));
			else
				LogsGeneration.generateErrorLogsWithMobileNumber("ApplicationSearchPreview", exceptionAsString, null, request.getRemoteAddr(),request.getHeader("User-Agent"));
			throw new UserDefineException("ApplicationSearchPreview", exceptionAsString);*/
		}
	}



}

