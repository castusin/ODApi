/**
 * 
 */
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

/**
 * @author Darshan
 *
 */
@RestController
public class ODGetParkLocalAreaRestService {

	@RequestMapping(value="/getParksLocalAreaData",method=RequestMethod.GET,produces={"application/json"})
	 public String getParksLocalAreaData(HttpServletRequest request,@RequestParam ("cityId") String cityId){
		//Logger class
		 Logger logger = Logger.getLogger(ODGetParksInfoRestService.class);
		 
		// Capture service Start time
			
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
				  
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults cisResult=CommonCISValidation.ParksLocalAreaData(cityId,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			  ODGetCityDetailsWebservice cityLeveDeails = new ODGetCityDetailsWebservice();
		      cisResult = cityLeveDeails.getCityDetails(cityId);
		      
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
