package com.od;


import java.util.Date;

import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODGetParkInfoWebService {
	static Logger logger = Logger.getLogger(ODGetParkInfoWebService.class);
	ODGetParkInfoBL parkInfoBL=new ODGetParkInfoBL();

	/**
	 * @param metro
	 * @param localArea
	 * @param parkType
	 * @param checkOut 
	 * @param checkIn 
	 * @return  1 in case of error or 0 if successful
	 * @throws Throwable 
	 */
	public CISResults getParksinfo(String parkType,String metro,String localArea, String checkIn, String checkOut) throws Throwable {
		
		 CISResults cisResult = parkInfoBL.getParksinfo(parkType,metro,localArea,checkIn,checkOut);	
		 logger.info("OD GetParkInfo WebService  " +cisResult );
		 return cisResult;
	}

}
