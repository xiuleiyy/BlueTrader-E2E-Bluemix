package com.ibm.icap.tradelite.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;


import com.ibm.icap.tradelite.direct.*;
import com.ibm.icap.tradelite.util.*;

/**
 * Application Lifecycle Listener implementation class TradeWebContextListener
 *
 */
//@WebListener
public class TradeWebContextListener implements ServletContextListener {


	//receieve trade web app startup/shutown events to start(initialized)/stop TradeDirect
	public void contextInitialized(ServletContextEvent event)
	{
		Log.trace("TradeWebContextListener contextInitialized -- initializing TradeDirect");
		TradeDirect.init();
	}
	public void contextDestroyed(ServletContextEvent event)
	{
		Log.trace("TradeWebContextListener  contextDestroy calling TradeDirect:destroy()");		
		TradeDirect.destroy();
	}

	
}
