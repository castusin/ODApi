package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODGetStateCitiesWebservice {
	
	static Logger logger = Logger.getLogger(ODGetStateCitiesWebservice.class);
	
	ODGetStateCitiesBL stateCitiesBL=new ODGetStateCitiesBL();

		public CISResults viewStateCities(String stateId) {
			
		 CISResults cisResult = stateCitiesBL.viewStateCities(stateId);
		 logger.info(" viewStateCities WebService :"+cisResult);
		return cisResult;
	}
}