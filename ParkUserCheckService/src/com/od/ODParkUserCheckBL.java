package com.od;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODParkUserCheckBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODParkUserCheckDAO parkUserCheckDAO=(ODParkUserCheckDAO)ctx.getBean("OParkUserCheck");

	
	public CISResults parkUserCheck(String emailId) throws Exception {
		
		// Capture service Start time
		CISResults cisResult=new CISResults();
		TimeCheck time=new TimeCheck();
		testServiceTime seriveTimeCheck=new testServiceTime();
		String serviceStartTime=time.getTimeZone();
		  
		final Logger logger = Logger.getLogger(ODGetCouponCodeBL.class);
		 
		 cisResult = parkUserCheckDAO.parkUserCheck(emailId);
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE))
         {
			 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			 
         }		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		logger.info("Database time for coupons code service:: " +result );
		  
		return cisResult;
	}


}