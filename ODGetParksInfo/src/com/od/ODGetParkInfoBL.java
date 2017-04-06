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
import com.cis.testServiceTime;


public class ODGetParkInfoBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetParkInfoDAO parkInfoDAO=(ODGetParkInfoDAO)ctx.getBean("ParkInfoDAO");
	

	public CISResults getParksinfo(String metro,String localArea,String odRating) {
		// Capture service Start time
			  testServiceTime seriveTimeCheck=new testServiceTime();
			  Calendar current = Calendar.getInstance();
			  DateFormat formatterTime = new SimpleDateFormat(CISConstants.DATE_FORMAT);
			  TimeZone objTime = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
			  formatterTime.setTimeZone( objTime);
			  String serviceStartTime=formatterTime.format(current.getTime());
		 			
			 final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			 CISResults cisResult = parkInfoDAO.getParksinfo(metro,localArea,odRating);
			 logger.debug("OD GetParkInfoBL service" +cisResult);
			 
			// Capture Service End time
			  Calendar ServiceEnd= Calendar.getInstance();
		      DateFormat formatter1 = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		      TimeZone obj1 = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
		      formatter1.setTimeZone(obj1);
			  String serviceEndTime=formatter1.format(ServiceEnd.getTime());
			  seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  
			 return cisResult;
		}

	}
