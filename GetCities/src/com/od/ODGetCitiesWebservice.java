package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODGetCitiesWebservice {
	
	static Logger logger = Logger.getLogger(ODGetCitiesWebservice.class);
	
	ODGetCitiesBL viewCitiesServiceBL=new ODGetCitiesBL();

		public CISResults viewCities(ODGetCitiesModel viewCities) {
			
		 CISResults cisResult = viewCitiesServiceBL.viewCities(viewCities);
		 logger.info(" viewCities WebService :"+cisResult);
		return cisResult;
	}
}