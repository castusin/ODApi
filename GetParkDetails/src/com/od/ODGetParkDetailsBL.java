
package com.od;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

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
		 	CISResults cisResult=new CISResults();
		 	List<ODParkDetailsService> parkDetailslist = null;
			final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			
			cisResult = parkDetailsDAO.getParksDetails( parkId);
	
<<<<<<< HEAD
			  cisResult = parkDetailsDAO.getParksListDetails( parkId);
			  
=======
			parkDetailslist	 = parkDetailsDAO.getParksListDetails( parkId);
			
			
			cisResult.setResultObject(parkDetailslist);
>>>>>>> origin/master
			 
			logger.debug("OD GetParkDetailsBL service" +cisResult);
			 
<<<<<<< HEAD
			 String serviceEndTime=time.getTimeZone();
			  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  logger.info("Database time for login service:: " +result );
=======
			String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Database time for get park details service:: " +result );
>>>>>>> origin/master
			
			  
			 return cisResult;
		}

	}
