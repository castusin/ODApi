package com.od;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

@RestController
public class ODGetCitiesRestService {

	
	
	@RequestMapping(value="/viewCities",method=RequestMethod.GET,produces={"application/json"})
	
		public String viewCities(HttpServletRequest request,ODGetCitiesModel viewCities){	 
		 Logger logger = Logger.getLogger(ODGetCitiesRestService.class);
		
		// Capture service Start time
		  TimeCheck time=new TimeCheck();
		 testServiceTime sessionTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
 
		 
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 CISResults cisResult=CommonCISValidation.viewCitiesValidation(request,viewCities);
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
		 ODGetCitiesWebservice viewCitiesWebservice= new ODGetCitiesWebservice();
		 cisResult = viewCitiesWebservice.viewCities(viewCities);
		 }
		// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		 logger.info("Total service time for view cities service in milli seconds :: " +result );
		  return returnJsonData(cisResult);
	 }
	 	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
