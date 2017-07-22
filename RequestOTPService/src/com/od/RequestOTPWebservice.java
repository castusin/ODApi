package com.od;


import org.apache.log4j.Logger;



import com.cis.CISResults;

public class RequestOTPWebservice {
	
	static Logger logger = Logger.getLogger(RequestOTPWebservice.class);
	RequestOTPBL otpBL=new RequestOTPBL();

	public CISResults requestOTP(String phoneNumber) throws Throwable {
		CISResults cisResult = null;
		
			 cisResult = otpBL.requestOTP(phoneNumber);
			// logger.info(" DigitalHealthCare:Webservice Request OTP :"+cisResult);
		

		return cisResult;
	}


}
