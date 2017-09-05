package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class UpdatePasswordServiceWebservice {
	
	static Logger logger = Logger.getLogger(ForgotPasswordWebservice.class);
	
	UpdatePasswordServiceBL updatePasswordServiceBL=new UpdatePasswordServiceBL();

	public CISResults updatePassword(String emailId,String otp,String password) {
		
		 CISResults cisResult = updatePasswordServiceBL.updatePassword(emailId,otp,password);
		 logger.info(" OD: Update passwordWebService :"+cisResult);
		return cisResult;
	}
}