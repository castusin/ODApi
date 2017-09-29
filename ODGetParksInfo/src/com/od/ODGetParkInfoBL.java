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
	 * @param checkOut 
	 * @param checkIn 
	 * @param reservationDate 
	 * @param adults 
	 * @return  1 in case of error or 0 if successful
	 * @throws Throwable 
	 */
	public CISResults getParksinfo(int localId,String parkType,String adults, String checkIn, String checkOut, String reservationDate) throws Throwable {
		// Capture service Start time
		
			CISResults cisResult=new CISResults();
			TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			ODGetParkInfoModel getdetails=new ODGetParkInfoModel();		
		
			final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			
			/*SimpleDateFormat myFormat = new SimpleDateFormat(CISConstants.CHECKIN_DATE_FORMAT);
			Date date1 = myFormat.parse(checkIn);
		    Date date2 = myFormat.parse(checkOut);
			
			int count=0;
			long diff = date2.getTime() - date1.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000)+1;
			count = (int) diffDays;*/
			
			/*if(parkType.equalsIgnoreCase("")){
				
				cisResult = parkInfoDAO.getAllParkinfo(localId);
			}*/
			
			if(reservationDate.equalsIgnoreCase("")){
				
				
				cisResult = parkInfoDAO.getParkRoominfo(localId,parkType,adults,checkIn,checkOut,reservationDate);
			     
			}else if(parkType.equalsIgnoreCase("")){
				
				cisResult = parkInfoDAO.getAllParkinfo(localId);
			}
				else{
				cisResult = parkInfoDAO.getParkinfo(localId,parkType,adults,checkIn,checkOut,reservationDate);
			
				}
			
			
			
			
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
		    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		    logger.info("Database time for get park info service:: " +result );
			  
		 return cisResult;
		}

	}
