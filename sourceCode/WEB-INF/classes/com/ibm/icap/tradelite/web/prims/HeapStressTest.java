package com.ibm.icap.tradelite.web.prims;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

//import com.ibm.cloudoe.scaletest.ReleaseObject;
//import com.ibm.cloudoe.scaletest.ServletConfig;
//import com.ibm.cloudoe.scaletest.ServletContext;

/**
 * Servlet implementation class HeapStressTest
 */
/**
 * Visit the servlet from http://appname.domain/HeapStressTest,  the request will be repeatedly sent by Rational Performance Tester, every request will consume "size" heap memory.
 * When servlet is init,  it will start a thread to repeatedly clean up memory, only leave memory with in "time" secs.
 * Expected behavior is the heap grows with throughput grows, drops with throughput drops 
 */

public class HeapStressTest extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private static int size=1024*100; //100K per request;
	
	private static ServletContext application=null;
	private static HashMap<Date, byte[]> map=null;
		
	    
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
	public HeapStressTest() {
		
        super();
        // TODO Auto-generated constructor stub
    }
	
	public void init(ServletConfig config) throws ServletException{
		
		map= new HashMap<Date, byte[]>();
		application=config.getServletContext();
		application.setAttribute("staticMap", map);
									
		Thread thread=new Thread(new ReleaseObject(application));
		thread.start();
		System.out.println("release thread is started, it will release used memory every 1 min");
				
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		response.setStatus(200);
		PrintWriter writer = response.getWriter();
		writer.println("---------------------------------------------------------------------");
		writer.println("Heap Stress Test");
		writer.println("---------------------------------------------------------------------");	
		
//		String method = request.getParameter("method");
				
		System.out.println("Use memory" + size/1024 +"k per request");
		writer.println("Use memory" + size/1024 +"k per request");
		useMemory(request.getServletContext(),writer);
		
				
//		if (method.equals("use")) {
//			System.out.println("Use memory" + size/1024 +"k per request");
//			writer.println("Use memory" + size/1024 +"k per request");
//			useMemory(request.getServletContext(),writer);
//		} 
//		
//		if (method.equals("release")) {
//			Thread thread=new Thread(new ReleaseObject(request.getServletContext()));
//			thread.start();
//			System.out.println("release thread is started, it will release used memory every 1 min");
//			writer.println("release thread is started, it will release used memory every 1 min");
//		}
        writer.close();
           
	}
				
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	public  void useMemory(ServletContext application, PrintWriter writer){
					
		HashMap<Date, byte[]> map=(HashMap<Date, byte[]>)application.getAttribute("staticMap");
		
		
		if(map==null){
			map= new HashMap<Date, byte[]>();
			application.setAttribute("staticMap", map);
		}
		
		synchronized(map){		
		Date current=new Date();
		byte[] heap=new byte[size];
		map.put(current, heap);
		System.out.println("new data is put into map on  "+ current );
		writer.println("new data is put into map on  "+ current);
		}
		
	}
	

}
