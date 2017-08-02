
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
public class ODParkUserCheckService {

	@RequestMapping(value="/parkUserCheck",method=RequestMethod.GET,produces={"application/json"})

	 public String parkUserCheck(@RequestParam ("emailId") String emailId,@RequestParam ("socialId") String socialId) throws Throwable{
		  Logger logger = Logger.getLogger(ODParkUserCheckService.class);
		  String parkUserCheckParameters = "emailId=" +emailId;
		  logger.info("park user check :"+parkUserCheckParameters);
		 
			 // Capture service Start time
		     TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
		  
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		//  CISResults cisResult=CommonCISValidation.requestOTPValidation(phoneNumber,emailId,request);
		 // if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		//  {
		    ODParkUserCheckWebservice parkUserCheckWebservice= new ODParkUserCheckWebservice();
		    CISResults cisResult  = parkUserCheckWebservice.parkUserCheck(emailId,socialId);    
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
