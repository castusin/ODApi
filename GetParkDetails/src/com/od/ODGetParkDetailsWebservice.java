
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
	 * @param reservationDate 
	 * @return  1 in case of error or 0 if successful
	 * @throws Exception 
	 */
	public CISResults getParksDetails(String parkId,String parkType, String checkIn, String checkOut, String reservationDate) throws Exception {
		 CISResults cisResult = parkDetailsBL.getParksDetails(parkId,parkType,checkIn,checkOut,reservationDate);	
		 logger.info("OD GetParkDetails WebService  " +cisResult );
		 return cisResult;
	}

}
