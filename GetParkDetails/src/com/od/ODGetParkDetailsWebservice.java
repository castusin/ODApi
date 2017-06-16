
package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;

public class ODGetParkDetailsWebservice {
	
	static Logger logger = Logger.getLogger(ODGetParkDetailsWebservice.class);
	ODGetParkDetailsBL parkDetailsBL=new ODGetParkDetailsBL();

	/**
	 * @param parkId
	 * @param checkOut 
	 * @param checkIn 
	 * @return  1 in case of error or 0 if successful
	 * @throws Exception 
	 */
	public CISResults getParksDetails(String parkId, String checkIn, String checkOut) throws Exception {
		 CISResults cisResult = parkDetailsBL.getParksDetails(parkId,checkIn,checkOut);	
		 logger.info("OD GetParkDetails WebService  " +cisResult );
		 return cisResult;
	}

}
