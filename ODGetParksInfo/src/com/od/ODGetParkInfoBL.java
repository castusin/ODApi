package com.od;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;


public class ODGetParkInfoBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetParkInfoDAO parkInfoDAO=(ODGetParkInfoDAO)ctx.getBean("ParkInfoDAO");
	

	public CISResults getParksinfo(String metro,String localArea,String odRating) {
		 			
			 final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			 CISResults cisResult = parkInfoDAO.getParksinfo(metro,localArea,odRating);
			 logger.debug("OD GetParkInfoBL service" +cisResult);
			 return cisResult;
		}

	}
