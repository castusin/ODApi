package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODGetParkInfoWebService {
	static Logger logger = Logger.getLogger(ODGetParkInfoWebService.class);
	ODGetParkInfoBL parkInfoBL=new ODGetParkInfoBL();

	/**
	 * @param metro
	 * @param localArea
	 * @param parkType
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults getParksinfo(String parkType,String metro,String localArea) {
		
		 CISResults cisResult = parkInfoBL.getParksinfo(parkType,metro,localArea);	
		 logger.info("OD GetParkInfo WebService  " +cisResult );
		 return cisResult;
	}

}
