package com.ibm.icap.tradelite.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import javax.servlet.http.*;

import com.ibm.icap.tradelite.*;
import com.ibm.icap.tradelite.direct.TradeDirect;
import com.ibm.icap.tradelite.util.*;

/**
 * Servlet Filter implementation class OrdersAlertFilter
 */
//@WebFilter(servletNames = { "com.ibm.websphere.samples.trade.web.TradeAppServlet" })
public class OrdersAlertFilter implements Filter {

	/**
	 * Constructor for CompletedOrdersAlertFilter
	 */
	public OrdersAlertFilter() {
		super();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	private FilterConfig filterConfig = null;
	public void init(FilterConfig filterConfig) throws ServletException {
	      this.filterConfig = filterConfig;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(
		ServletRequest req,
		ServletResponse resp,
		FilterChain chain)
		throws IOException, ServletException {
		if (filterConfig == null)
			return;
		
		try
		{
			String action = req.getParameter("action");
			if ( action != null ) 
			{
				action = action.trim();
				if ( (action.length() > 0) && (!action.equals("logout")) )
				{
					String userID;
					if ( action.equals("login") )
						userID = req.getParameter("uid");
					else
						userID = (String) ((HttpServletRequest) req).getSession().getAttribute("uidBean");
					if ( (userID != null) && (userID.trim().length()>0) )
					{	
						TradeServices tAction=null;
						if(TradeConfig.getAccessMode() == TradeConfig.STANDARD)
							tAction = new TradeDirect();
															
						java.util.Collection closedOrders = tAction.getClosedOrders(userID);
						if ( (closedOrders!=null) && (closedOrders.size() > 0) )
							req.setAttribute("closedOrders", closedOrders);
						if (Log.doTrace()) Log.printCollection("OrderAlertFilter: userID="+userID+" closedOrders=", closedOrders);
					}
				}	
			}
		}
		catch (Exception e)
		{
			Log.error(e, "OrdersAlertFilter - Error checking for closedOrders");
		}

        ServletContext sc = filterConfig.getServletContext();
        //String xyz = (String) sc.getAttribute("hitCounter");
		chain.doFilter(req, resp/*wrapper*/);        

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.filterConfig = null;	
	}

}
