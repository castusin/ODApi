/**
 * 
 */
package com.od;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

/**
 * @author Darshan
 *
 */
public class ODGetCityDetailsBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetCityDetailsDAO cityInfoDAO=(ODGetCityDetailsDAO)ctx.getBean("cityInfoDAO");
	
	public CISResults getCityLevelinfo(String cityId) {
		// TODO Auto-generated method stub
		     final Logger logger = Logger.getLogger(ODGetCityDetailsBL.class);
			 CISResults cisResult = cityInfoDAO.getCityinfo(cityId);
			 logger.debug("OD GetCityParkInfoBL service" +cisResult);
			 logger.info("Database time for City Level park info service:: " +cisResult );
			  
			 return cisResult;
		
	}

}
