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


public class ODGetParkInfoBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetParkInfoDAO parkInfoDAO=(ODGetParkInfoDAO)ctx.getBean("ParkInfoDAO");
	

	/**
	 * @param metro
	 * @param localArea
	 * @param parkType
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults getParksinfo(String parkType,String metro,String localArea) {
		// Capture service Start time
		
	    TimeCheck time=new TimeCheck();
		testServiceTime seriveTimeCheck=new testServiceTime();
		String serviceStartTime=time.getTimeZone();
		 			
			 final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			 CISResults cisResult = parkInfoDAO.getParksinfo(parkType,metro,localArea);
			 logger.debug("OD GetParkInfoBL service" +cisResult);
			 
			// Capture Service End time
			    String serviceEndTime=time.getTimeZone();
				long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
				logger.info("Database time for get park info service:: " +result );
			  
			 return cisResult;
		}

	}
