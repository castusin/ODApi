package com.od;


import org.apache.log4j.Logger;



import com.cis.CISResults;

public class ManualRequestOTPWebservice {
	
	static Logger logger = Logger.getLogger(ManualRequestOTPWebservice.class);
	ManualRequestOTPBL manualotp=new ManualRequestOTPBL();

	public CISResults manualrequestOTP(String phoneNumber) throws Throwable {
		CISResults cisResult = new CISResults();
		
			 cisResult = manualotp.manualrequestOTP(phoneNumber);
			logger.info(" DigitalHealthCare:Webservice manual Request OTP :"+cisResult);
		

		return cisResult;
	}


}
