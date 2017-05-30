
package com.od;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODGetParkDetailsBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetParkDetailsDAO parkDetailsDAO=(ODGetParkDetailsDAO)ctx.getBean("ParkDetailsDAO");
	
	/**
	 * @param parkId
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults getParksDetails(String parkId) {
		// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			
		 	CISResults cisResult=new CISResults();
		 	ODGetParkDetailsModel parkDetails=new ODGetParkDetailsModel();
		 	List<ODParkDetailsService> parkDetailslist = null;
			final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			
			cisResult = parkDetailsDAO.getParksDetails( parkId);
	
			parkDetailslist	 = parkDetailsDAO.getParksListDetails( parkId);
						
			//cisResult.setResultObject(parkDetailslist);
			cisResult.setParkDetails(parkDetailslist);
			 
			logger.debug("OD GetParkDetailsBL service" +cisResult);
			 
			String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Database time for get park details service:: " +result );
			
			  
			 return cisResult;
		}

	}
