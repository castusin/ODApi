package com.od;




import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ForgotPasswordWebservice {
	
	static Logger logger = Logger.getLogger(ForgotPasswordWebservice.class);
	
	ForgotPasswordBL forgotPasswordBL=new ForgotPasswordBL();

	public CISResults forgotPassword(String userName) throws Throwable {
		
		 CISResults cisResult = forgotPasswordBL.forgotPassword(userName);
		 logger.info(" OD:forgot password WebService :"+cisResult);
		return cisResult;
	}
}