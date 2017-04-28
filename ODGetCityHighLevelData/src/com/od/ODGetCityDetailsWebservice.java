/**
 * 
 */
package com.od;

import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author Darshan
 *
 */
public class ODGetCityDetailsWebservice {
	static Logger logger = Logger.getLogger(ODGetCityDetailsWebservice.class);
	ODGetCityDetailsBL cityInfoBL=new ODGetCityDetailsBL();


	public CISResults getCityDetails(String cityId) {
		// TODO Auto-generated method stub
		 CISResults cisResult = cityInfoBL.getCityLevelinfo(cityId);	
		 logger.info("OD Get City Info WebService  " +cisResult );
		 return cisResult;
	}

}
