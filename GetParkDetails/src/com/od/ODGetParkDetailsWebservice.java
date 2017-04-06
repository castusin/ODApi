
package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODGetParkDetailsWebservice {
	static Logger logger = Logger.getLogger(ODGetParkDetailsWebservice.class);
	ODGetParkDetailsBL parkDetailsBL=new ODGetParkDetailsBL();

	public CISResults getParksDetails(String parkId) {
		 CISResults cisResult = parkDetailsBL.getParksDetails(parkId);	
		 logger.info("OD GetParkInfo WebService  " +cisResult );
		 return cisResult;
	}

}
