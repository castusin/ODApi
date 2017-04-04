package com.od;


import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;


public class ODSaveParkInfoBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODSaveParkInfoDAO saveParkInfoDAO=(ODSaveParkInfoDAO)ctx.getBean("SaveParkInfoDAO");
	
	 private static final AtomicInteger count = new AtomicInteger(100001); 
	  
	  
	public CISResults saveParkInfo(ODGetParkInfoModel saveParkInfo) {
		 			
			 final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			 int parkId = count.incrementAndGet();
			 CISResults cisResult = saveParkInfoDAO.saveParkInfo(saveParkInfo.getAppId(),saveParkInfo.getParktype(),saveParkInfo.getParkSubtype(),saveParkInfo.getMetro(),saveParkInfo.getLocalArea(),saveParkInfo.getStreetAddress(),saveParkInfo.getCity(),saveParkInfo.getState(),saveParkInfo.getPin(),saveParkInfo.getName(),saveParkInfo.getDescription(),saveParkInfo.getDetails(),parkId,saveParkInfo.getOdRating(),saveParkInfo.getSponsoredFeaturedFlag(),saveParkInfo.getOverviewText(),saveParkInfo.getFaq(),saveParkInfo.getLatitude(),saveParkInfo.getLongitude(),saveParkInfo.getTypeString(),saveParkInfo.getNatureString(),saveParkInfo.getSubCategoryString(),saveParkInfo.getDurationString(),saveParkInfo.getMaxPeople(),saveParkInfo.getDateAdded(),saveParkInfo.getPopularity(),saveParkInfo.getMinCost1(),saveParkInfo.getMinCost1People(),saveParkInfo.getMinCost2(),saveParkInfo.getMinCost2People(),saveParkInfo.getMinCost3(),saveParkInfo.getMinCost3People(),saveParkInfo.getSpecialOfferPercentage(),saveParkInfo.getSpecialRate(),saveParkInfo.getPhotoUrl());
			 logger.debug("save ParkInfoBL service" +cisResult);
			 return cisResult;
		}

	}
