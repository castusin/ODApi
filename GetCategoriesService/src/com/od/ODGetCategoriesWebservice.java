package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODGetCategoriesWebservice {
	
	static Logger logger = Logger.getLogger(ODGetCategoriesWebservice.class);
	
	ODGetCategoriesBL getCategoriesBL=new ODGetCategoriesBL();

		public CISResults getCategories(int cityId,String parkType, String adults, String checkIn, String checkOut, String reservationDate) {
			
		 CISResults cisResult = getCategoriesBL.getCategories(cityId,parkType,adults,checkIn,checkOut,reservationDate);
		 logger.info(" viewCities WebService :"+cisResult);
		return cisResult;
	}
}