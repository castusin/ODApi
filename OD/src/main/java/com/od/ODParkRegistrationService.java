package com.od;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;
/**
 * Rest Controller : Park registration service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */


@RestController
public class ODParkRegistrationService {

	
	@RequestMapping(value="/parkRegestration",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	 public String parkRegestration(HttpServletRequest request,@RequestBody ODParkRegistrationModel parkregisteration) throws Throwable{
		
		 Logger logger = Logger.getLogger(ODParkRegistrationService.class);
		
		 // Capture service Start time
			
	     TimeCheck time=new TimeCheck();
	     testServiceTime seriveTimeCheck=new testServiceTime();
	     String serviceStartTime=time.getTimeZone();
	     
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 CISResults cisResult=CommonCISValidation.parkRegestrationValidation(request,parkregisteration);
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		{
			ODParkRegistrationWebservice registrationWebservice = new ODParkRegistrationWebservice();
		  cisResult = registrationWebservice.parkRegestration(parkregisteration);
		}
		   // Capture Service End time

		    String serviceEndTime=time.getTimeZone();
		    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		    logger.info("Total service time for park registration service:: " +result );

		  return returnJsonData(cisResult);
	}
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}