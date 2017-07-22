package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;
/**
 * Validates OTP 
 * @author Castus Info Solutions
 *
 */

public class ValidateOTPWebservice {

	static Logger logger = Logger.getLogger(ValidateOTPWebservice.class);
	ValidateOTPBL verifyOTPBL=new ValidateOTPBL();

	public CISResults validateOTP(String phoneNumber,String otp) {
		
		 CISResults otResult = verifyOTPBL.validateOTP(phoneNumber,otp);
		 logger.info(" DigitalHealthCare:Validate OTP :"+otResult);
		return otResult;
	}
}