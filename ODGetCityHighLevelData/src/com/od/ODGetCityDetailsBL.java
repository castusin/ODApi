/**
 * 
 */
package com.od;

import java.util.List;

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
		
		     List<LocalAreaData> localarealist = null;
		     final Logger logger = Logger.getLogger(ODGetCityDetailsBL.class);
			 CISResults cisResult = cityInfoDAO.getCityinfo(cityId);
			 localarealist=cityInfoDAO.getLocalareainfo(cityId);
			 cisResult.setLocalareaList(localarealist);	
			 logger.debug("OD GetCityParkInfoBL service" +cisResult);
			 logger.info("Database time for City Level park info service:: " +cisResult );
			  
			 return cisResult;
		
	}

}
