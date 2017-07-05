package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODPaymentSuccessWebservice {
	static Logger logger = Logger.getLogger(ODGetParkInfoWebService.class);
	ODPaymentSuccessBL successBL=new ODPaymentSuccessBL();

	/**
	 * @param status 
	 * @param cod 
	 * @param metro
	 * @param localArea
	 * @param parkType
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults paymentSuccess(String transactionId, String status, String cod) {
		
		 CISResults cisResult = successBL.paymentSuccess(transactionId,status,cod);	
		 logger.info("OD GetParkInfo WebService  " +cisResult );
		 return cisResult;
	}

}
