
package com.od;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import com.cis.testServiceTime;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;


@RestController
public class ODGetParksDetailsRestService {
	
	@RequestMapping(value="/getParksDetails",method=RequestMethod.GET,produces={"application/json"})
	 public String getParksDetails(HttpServletRequest request,@RequestParam ("parkId") String parkId){
		//Logger class
		 Logger logger = Logger.getLogger(ODGetParksInfoRestService.class);
		 
		// Capture service Start time
			
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
				  
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults cisResult=CommonCISValidation.ParksDetailsValidation(parkId,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			  ODGetParkDetailsWebservice parkDetailsWebservice = new ODGetParkDetailsWebservice();
		      cisResult = parkDetailsWebservice.getParksDetails(parkId);
		      
		    }
		  
		// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Total service time for get park details service:: " +result );
		  
		  return returnJsonData(cisResult);
	}
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
