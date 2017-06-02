package com.od;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
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
	public CISResults getParksinfo(String parkType,String metro,String localArea, String checkIn, String checkOut) throws Throwable {
		// Capture service Start time
		
		CISResults cisResult=new CISResults();
	    TimeCheck time=new TimeCheck();
		testServiceTime seriveTimeCheck=new testServiceTime();
		String serviceStartTime=time.getTimeZone();
		ODGetParkInfoModel getdetails=new ODGetParkInfoModel();		
		
		final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
		
		
		List<GetDatesModel> datesslist = null;
		List<Date> dates = new ArrayList<Date>();

		String str_date =checkIn;
		String end_date =checkOut;

		DateFormat formatter ; 

		formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date  startDate = (Date)formatter.parse(str_date); 
		Date  endDate = (Date)formatter.parse(end_date);
		long interval = 24*1000 * 60 * 60; // 1 hour in millis
		long endTime =endDate.getTime() ; // create your endtime here, possibly using Calendar or Date
		long curTime = startDate.getTime();
		while (curTime <= endTime) {
		    dates.add(new Date(curTime));
		    curTime += interval;
		}
		 String checkdates="";
				 
		for(int i=0;i<dates.size();i++){
		    Date lDate =(Date)dates.get(i);
		     checkdates = formatter.format(lDate);    
		    System.out.println(" Date is ..." + checkdates);
		   // cisResult = parkInfoDAO.getDates(checkdates);
		   
		    /*GetDatesModel  name=(GetDatesModel)cisResult.getResultObject();
			Date checkDate=name.getDate();*/
	   
		}  
		 cisResult = parkInfoDAO.getParksinfo(parkType,metro,localArea,checkdates);
		cisResult.setDateList(datesslist);
		/*String checkDate="";
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss"); 
	    DateTime dt = formatter.parseDateTime(checkDate);*/
		
			 
			// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		 logger.info("Database time for get park info service:: " +result );
			  
		 return cisResult;
		}

	}
