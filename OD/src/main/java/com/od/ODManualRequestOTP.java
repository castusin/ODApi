package com.od;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;
@RestController
public class ODManualRequestOTP {

	@RequestMapping(value="/manualRequestOTPService",method=RequestMethod.GET,produces={"application/json"})

	 public String manualrequestOTP(@RequestParam String phoneNumber) throws Throwable{
		  Logger logger = Logger.getLogger(ODRequestOTP.class);
		  CISResults cisResult = new CISResults();
		  String requestOTPParameters = "phoneNumber=" +phoneNumber;
		  logger.info("Request OTP :"+requestOTPParameters);
		 
			 // Capture service Start time
		     TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
		  
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		//  CISResults cisResult=CommonCISValidation.requestOTPValidation(phoneNumber,emailId,request);
		 // if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		//  {
		    ManualRequestOTPWebservice manualotp= new ManualRequestOTPWebservice();
		    cisResult  = manualotp.manualrequestOTP(phoneNumber);    
		//  }
		  
		  
			// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
     	 logger.info("Total service time for request otp service in milli seconds:: " +result );

		  
		  return returnJsonData(cisResult);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
