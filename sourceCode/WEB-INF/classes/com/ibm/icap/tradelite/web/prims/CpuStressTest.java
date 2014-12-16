package com.ibm.icap.tradelite.web.prims;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.lang.management.OperatingSystemMXBean;



/**
 * Servlet implementation class HelloWorld
 */

public class CpuStressTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int highestHeapUsage=0;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CpuStressTest() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		OperatingSystemMXBean osBean=ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
		
		MemoryMXBean mmBean = ManagementFactory.getMemoryMXBean();
		response.setContentType("text/plain");
		response.setStatus(200);
		PrintWriter writer = response.getWriter();
		//writer.println("Hello from "+System.getenv("VCAP_APP_HOST") + ":" + System.getenv("VCAP_APP_PORT"));
		//nthPrime(10000);
		nthPrime(1000);
		writer.println("---------------------------------------------------------------------");
		writer.println("CPU Stress Test");
		writer.println("---------------------------------------------------------------------");		
		writer.println("Available Processors	: "+osBean.getAvailableProcessors());
		writer.println("System Cpu Load		: "+Math.round(osBean.getSystemCpuLoad()*100)+"%");
		writer.println("Total Physical Memory	: "+Math.round((osBean.getTotalPhysicalMemory()/1024)/1024)+" (MB)");
		writer.println("Free Physical Memory	: "+Math.round((osBean.getFreePhysicalMemorySize()/1024)/1024)+" (MB)");
		MemoryUsage mu = mmBean.getHeapMemoryUsage();
		
		writer.println("Maximum heap		: "+Math.round((mu.getMax()/1024)/1024)+" (MB)");
		writer.println("Initial heap		: "+Math.round((mu.getInit()/1024)/1024)+" (MB)");
		int currentUsage=Math.round((mu.getUsed()/1024)/1024);		
		writer.println("Used heap		: "+currentUsage+" (MB)");
		if (currentUsage>highestHeapUsage) {
			highestHeapUsage=currentUsage;
		}
		writer.println("Highest heap		: "+highestHeapUsage+" (MB)");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void calculate(){		
//		double result=0;
//		Random random = new Random();
//		double x = random.nextDouble();
//		double y = random.nextDouble();
//		result = x * y;				
		//Math.tan(Math.atan(Math.tan(Math.atan(Math.tan(Math.atan(Math.tan(Math.atan(Math.tan(Math.atan(0.5))))))))));
		factorial(70);
	}
	
	public int nthPrime(int n) {
	    int candidate, count;
	    for(candidate = 2, count = 0; count < n; ++candidate) {
	        if (isPrime(candidate)) {
	            ++count;
	        }
	    }
	    // The candidate has been incremented once after the count reached n
	    return candidate-1;
	}
	
	private boolean isPrime(int n) {
	    for(int i = 2; i < n; ++i) {
	        if (n % i == 0) {
	            // We are naive, but not stupid, if
	            // the number has a divisor other
	            // than 1 or itself, we return immediately.
	            return false;
	        }
	    }
	    return true;
	}
	
	private int factorial ( int input )
	{
	  int x, fact = 1;
	  for ( x = input; x > 1; x--)
	     fact *= x;

	  return fact;

	}

}
