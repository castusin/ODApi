
package com.od;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	/**
	 * @param parkId
	 * @return  1 in case of error or 0 if successful
	 * @throws Exception 
	 */
	public CISResults getParksDetails(String parkId,String checkIn, String checkOut) throws Exception {
		// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			
		 	CISResults cisResult=new CISResults();
		 	ODGetParkDetailsModel parkDetails=new ODGetParkDetailsModel();
		 	List<ODParkDetailsService> parkDetailslist = null;
			final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			
			
			
			SimpleDateFormat myFormat = new SimpleDateFormat(CISConstants.CHECKIN_DATE_FORMAT);
			Date date1 = myFormat.parse(checkIn);
		    Date date2 = myFormat.parse(checkOut);
		
			int count=0;
			long diff = date2.getTime() - date1.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000)+1;
			count = (int) diffDays;
			
			
			cisResult = parkDetailsDAO.getParksDetail(parkId);
			parkDetailslist = parkDetailsDAO.getParksDetails(checkIn,checkOut,parkId,count);
		    cisResult.setParkDetails(parkDetailslist);	
		
			logger.debug("OD GetParkDetailsBL service" +cisResult);
			 
			String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Database time for get park details service:: " +result );
			
			  
			 return cisResult;
		}

	}
