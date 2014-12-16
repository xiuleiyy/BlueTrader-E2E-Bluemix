package com.ibm.icap.tradelite.web.prims;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletContext;

public class ReleaseObject extends Thread{
	
    private static ServletContext application = null;

    private static int time= 60;  // object saved for "time" secs
    
    	
	public ReleaseObject(ServletContext application) {
		ReleaseObject.application = application;

	}
	
	public void run(){
		
		HashMap<Date, byte[]> map=(HashMap<Date, byte[]>)application.getAttribute("staticMap");
		System.out.println("thread starts "+new Date());
		
		while(true){				
			
			if(map!=null){			
								
		        try {
		        	
		        	synchronized(map){       		
		        				        		
		        	Date current=new Date();
					Iterator iterator = map.keySet().iterator();   
					
			        while (iterator.hasNext()) {    
			        
			        Date before = (Date)iterator.next();                  
			        Date toDelete=new Date(before.getTime()+1000*time); // delete objected created "time" secs before
			       
			                           
			        if(current.after(toDelete)){
//			        	System.out.println("will remove data added on  "+ before +"at"+ new Date());
			        	  iterator.remove();
			        	 
			        	  }
			           }
			        System.gc();
					} 
		        	Thread.sleep(1000*time);
			        
		        }catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		        	        
		  }
			
		}
	}
}
        


