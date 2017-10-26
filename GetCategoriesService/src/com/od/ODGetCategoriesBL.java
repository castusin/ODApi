package com.od;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODGetCategoriesBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetCategoriesDAO getCategoriesDAO=(ODGetCategoriesDAO)ctx.getBean("GetCategories");

	public CISResults getCategories(int cityId,String parkType, String adults, String checkIn, String checkOut, String reservationDate){
		
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 CISResults cisResult = new CISResults();
		final Logger logger = Logger.getLogger(ODGetCitiesBL.class);
		 
		if(parkType.equalsIgnoreCase("")){
			
			
			cisResult = getCategoriesDAO.getAllParkinfo(cityId,reservationDate);
		     
		}else{
		
		    cisResult = getCategoriesDAO.getCategories(cityId,parkType,adults,checkIn,checkOut,reservationDate);
		
		}
		
		logger.info("viewCities BL  service" +cisResult );
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for view cities service:: " +result );
		  
		return cisResult;
	}


}