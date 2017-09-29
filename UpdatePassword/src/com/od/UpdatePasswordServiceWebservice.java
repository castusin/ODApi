package com.od;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class UpdatePasswordServiceWebservice {
	
	static Logger logger = Logger.getLogger(ForgotPasswordWebservice.class);
	
	UpdatePasswordServiceBL updatePasswordServiceBL=new UpdatePasswordServiceBL();

	public CISResults updatePassword(String userName,String otp,String password) throws Throwable {
		
		 CISResults cisResult = updatePasswordServiceBL.updatePassword(userName,otp,password);
		 logger.info(" OD: Update passwordWebService :"+cisResult);
		return cisResult;
	}
}