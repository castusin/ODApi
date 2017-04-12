
package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODGetParkDetailsWebservice {
	static Logger logger = Logger.getLogger(ODGetParkDetailsWebservice.class);
	ODGetParkDetailsBL parkDetailsBL=new ODGetParkDetailsBL();

	/**
	 * @param parkId
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults getParksDetails(String parkId) {
		 CISResults cisResult = parkDetailsBL.getParksDetails(parkId);	
		 logger.info("OD GetParkDetails WebService  " +cisResult );
		 return cisResult;
	}

}
