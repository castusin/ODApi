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
 * Rest Controller : create user service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */


@RestController
public class ODCreateUserRestService {

	/**
	 * @param request
	 * @param createUser
	 * @return 1 in case of error or 0 if successful
	 */
	@RequestMapping(value="/createUser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	 public String createUser(@RequestBody ODCreateUserModel createUser){
		
		 Logger logger = Logger.getLogger(ODCreateUserRestService.class);
		
		 // Capture service Start time
			
	     TimeCheck time=new TimeCheck();
	     testServiceTime seriveTimeCheck=new testServiceTime();
	     String serviceStartTime=time.getTimeZone();
	     
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		//  CISResults cisResults=CommonCISValidation.CreateUserValidation(createUser);
		 // if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		   // {
			  ODCreateUserWebservice createUserWebservice = new ODCreateUserWebservice();
			  CISResults cisResults = createUserWebservice.createUser(createUser);
		   // }
		   // Capture Service End time

		    String serviceEndTime=time.getTimeZone();
		    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		    logger.info("Total service time for create user service:: " +result );

		  return returnJsonData(cisResults);
	}
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}