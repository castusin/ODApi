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


public class ODGetCitiesBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetCitiesDAO viewCitiesServiceDAO=(ODGetCitiesDAO)ctx.getBean("viewCities");

	public CISResults viewCities(ODGetCitiesModel viewCities){
		
		// Capture service Start time
		TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		  
		final Logger logger = Logger.getLogger(ODGetCitiesBL.class);
		 
		CISResults cisResult = viewCitiesServiceDAO.viewCities(viewCities.getCityKey(),viewCities.getCityName());
		logger.info("viewCities BL  service" +cisResult );
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for view cities service:: " +result );
		  
		return cisResult;
	}


}