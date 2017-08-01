package com.od;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

@RestController
public class ODGetStateCitiesRestService {

	
	
	@RequestMapping(value="/viewStateCities",method=RequestMethod.GET,produces={"application/json"})
	
		public String viewStateCities(HttpServletRequest request,@RequestParam ("stateId") String stateId){	 
		 Logger logger = Logger.getLogger(ODGetStateCitiesRestService.class);
		
		// Capture service Start time
		  TimeCheck time=new TimeCheck();
		 testServiceTime sessionTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
 
		 
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 CISResults cisResult=CommonCISValidation.viewStateCitiesValidation(request,stateId);
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
			 ODGetStateCitiesWebservice getStateCitiesWebservice= new ODGetStateCitiesWebservice();
		 cisResult = getStateCitiesWebservice.viewStateCities(stateId);
		 }
		// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		 logger.info("Total service time for view state cities service in milli seconds :: " +result );
		  return returnJsonData(cisResult);
	 }
	 	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
