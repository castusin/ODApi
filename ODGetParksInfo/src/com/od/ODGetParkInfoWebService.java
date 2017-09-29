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
	 * @param reservationDate 
	 * @param adults 
	 * @return  1 in case of error or 0 if successful
	 * @throws Throwable 
	 */
	public CISResults getParksinfo(int localId,String parkType,String adults, String checkIn, String checkOut, String reservationDate) throws Throwable {
		
		 CISResults cisResult = parkInfoBL.getParksinfo(localId,parkType,adults,checkIn,checkOut,reservationDate);	
		 logger.info("OD GetParkInfo WebService  " +cisResult );
		 return cisResult;
	}

}
