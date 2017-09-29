
package com.od;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.SMSCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class ManualRequestOTPBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ManualRequestOTPDAO manualotp=(ManualRequestOTPDAO)ctx.getBean("ManualRequest");
	
	public CISResults manualrequestOTP(String phoneNumber) throws Throwable  {
		
		SMSCommunication smsCommunicaiton=new SMSCommunication();
		CISResults cisResults=new CISResults();
		final Logger logger = Logger.getLogger(ManualRequestOTPBL.class);
		 cisResults = manualotp.checkEmail(phoneNumber);
		  // Capture service Start time
		  TimeCheck time=new TimeCheck();
		  testServiceTime seriveTimeCheck=new testServiceTime();
		  String serviceStartTime=time.getTimeZone();
		 if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE))
	       {
				cisResults=smsCommunicaiton.sendSMS(phoneNumber);
	       }else{
	        	 cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
		    	 cisResults.setErrorMessage("User already exists, please login");
		       }
		
		   
			// Capture Service End time
			  String serviceEndTime=time.getTimeZone();
			  seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  logger.info("Database time for request otp service:: " +cisResults );
			
		return cisResults;
		
	}

}
