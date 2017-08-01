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


public class ODGetStateCitiesBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetStateCitiesDAO stateCitiesDAO=(ODGetStateCitiesDAO)ctx.getBean("viewStateCities");

	public CISResults viewStateCities(String stateId){
		
		// Capture service Start time
		TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		  
		final Logger logger = Logger.getLogger(ODGetStateCitiesBL.class);
		 
		CISResults cisResult = stateCitiesDAO.viewStateCities(stateId);
		logger.info("viewStateCities BL  service" +cisResult );
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for view state cities service:: " +result );
		  
		return cisResult;
	}


}