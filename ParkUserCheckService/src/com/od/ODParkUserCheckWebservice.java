package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;

public class ODParkUserCheckWebservice {
	
	static Logger logger = Logger.getLogger(ODParkUserCheckWebservice.class);
	ODParkUserCheckBL parkUserCheckBL=new ODParkUserCheckBL();

	public CISResults parkUserCheck(String emailId) throws Exception {
		 CISResults cisResult = parkUserCheckBL.parkUserCheck(emailId);
		 logger.info("park user check WebService  " +cisResult );
		 return cisResult;
	}

}
