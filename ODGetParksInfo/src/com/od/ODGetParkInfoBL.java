package com.od;


import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	 * @param checkOut 
	 * @param checkIn 
	 * @return  1 in case of error or 0 if successful
	 * @throws Throwable 
	 */
	public CISResults getParksinfo(String parkType,String localArea, String checkIn, String checkOut) throws Throwable {
		// Capture service Start time
		
			CISResults cisResult=new CISResults();
			TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			ODGetParkInfoModel getdetails=new ODGetParkInfoModel();		
		
			final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date1 = myFormat.parse(checkIn);
		    Date date2 = myFormat.parse(checkOut);
			//long count=((date2.getTime()-date1.getTime())/ (1000 * 60 * 60 * 24));
		  //  int days = Days.daysBetween(checkIn, checkOut).getDays();
			
			
			int count=0;
			long diff = date2.getTime() - date1.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000)+1;
			count = (int) diffDays;
			
			
			
			
			List<GetDatesModel> dateList=null;
		
			cisResult = parkInfoDAO.getParkinfo(parkType,localArea,checkIn,checkOut,count);
		    
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
		    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		    logger.info("Database time for get park info service:: " +result );
			  
		 return cisResult;
		}

	}
