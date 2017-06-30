package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODPaymentSuccessWebservice {
	static Logger logger = Logger.getLogger(ODGetParkInfoWebService.class);
	ODPaymentSuccessBL successBL=new ODPaymentSuccessBL();

	/**
	 * @param status 
	 * @param metro
	 * @param localArea
	 * @param parkType
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults paymentSuccess(String transactionId, String status) {
		
		 CISResults cisResult = successBL.paymentSuccess(transactionId,status);	
		 logger.info("OD GetParkInfo WebService  " +cisResult );
		 return cisResult;
	}

}
