package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODGetParkInfoWebService {
	static Logger logger = Logger.getLogger(ODGetParkInfoWebService.class);
	ODGetParkInfoBL parkInfoBL=new ODGetParkInfoBL();

	public CISResults getParksinfo(String metro,String localArea,String parkType) {
		 CISResults cisResult = parkInfoBL.getParksinfo(metro,localArea,parkType);	
		 logger.info("OD GetParkInfo WebService  " +cisResult );
		 return cisResult;
	}

}
