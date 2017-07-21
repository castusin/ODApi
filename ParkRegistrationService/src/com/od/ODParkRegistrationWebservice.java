
package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODParkRegistrationWebservice {
	
	static Logger logger = Logger.getLogger(ODParkRegistrationWebservice.class);
	ODParkRegistrationBL registrationBL=new ODParkRegistrationBL();

	
	public CISResults parkRegestration(ODParkRegistrationModel parkregisteration) throws Throwable {
		
		 CISResults cisResults = registrationBL.parkRegestration(parkregisteration);	
		 logger.info("park registration Webservice " +cisResults );
		 return cisResults;
	}

}
