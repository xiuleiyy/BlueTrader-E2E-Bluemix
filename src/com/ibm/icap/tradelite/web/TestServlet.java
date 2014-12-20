package com.ibm.icap.tradelite.web;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;

import java.math.BigDecimal;

import com.ibm.icap.tradelite.*;
import com.ibm.icap.tradelite.direct.TradeDirect;
import com.ibm.icap.tradelite.util.*;

/**
 * Servlet implementation class TestServlet
 */
//@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	
   /**
	* Process incoming HTTP GET requests
	*
	* @param request Object that encapsulates the request to the servlet
	* @param response Object that encapsulates the response from the servlet
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		performTask(request,response);
	}

   /**
	* Process incoming HTTP POST requests
	*
	* @param request Object that encapsulates the request to the servlet
	* @param response Object that encapsulates the response from the servlet
	*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		performTask(request,response);
	}	

   /**
	* Main service method for TradeAppServlet
	*
	* @param request Object that encapsulates the request to the servlet
	* @param response Object that encapsulates the response from the servlet
	*/    	
	public void performTask(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
	{
		try {
			Log.debug("Enter TestServlet doGet");
			TradeConfig.runTimeMode = TradeConfig.DIRECT;
			for (int i=0; i<10; i++) 
			{
				new TradeDirect().createQuote("s:"+i, "Company " + i, new BigDecimal(i*1.1));
			}
			/*
			
			AccountDataBean accountData = new TradeAction().register("user1", "password", "fullname", "address", 
											"email", "creditCard", new BigDecimal(123.45), false);

			OrderDataBean orderData = new TradeAction().buy("user1", "s:1", 100.0);
			orderData = new TradeAction().buy("user1", "s:2", 200.0);
			Thread.sleep(5000);
			accountData = new TradeAction().getAccountData("user1");
			Collection holdingDataBeans = new TradeAction().getHoldings("user1");
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.write("<HEAD></HEAD><BODY><BR><BR>");
			out.write(accountData.toString());
			Log.printCollection("user1 Holdings", holdingDataBeans);
			ServletContext sc  = getServletContext();
			req.setAttribute("results", "Success");
			req.setAttribute("accountData", accountData);
			req.setAttribute("holdingDataBeans", holdingDataBeans);
			getServletContext().getRequestDispatcher("/tradehome.jsp").include(req, resp);
			out.write("<BR><BR>done.</BODY>");
			*/
		}
		catch (Exception e)
		{
			Log.error("TestServletException", e);
		}
	}
}
