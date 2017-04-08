
package com.od;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODGetParkDetailsBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetParkDetailsDAO parkDetailsDAO=(ODGetParkDetailsDAO)ctx.getBean("ParkDetailsDAO");
	

	public CISResults getParksDetails(String parkId) {
		// Capture service Start time
				TimeCheck time=new TimeCheck();
				 testServiceTime seriveTimeCheck=new testServiceTime();
				 String serviceStartTime=time.getTimeZone();
		 			
			 final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			 CISResults cisResult = parkDetailsDAO.getParksDetails( parkId);
			 
			 cisResult = parkDetailsDAO.getParksListDetails( parkId);
			 
			 logger.debug("OD GetParkInfoBL service" +cisResult);
			 
			 String serviceEndTime=time.getTimeZone();
			  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  logger.info("Database time for login service:: " +result );
			 // seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  
			 return cisResult;
		}

	}
