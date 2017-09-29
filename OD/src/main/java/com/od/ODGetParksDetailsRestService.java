
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
 * Rest Controller : Get park details
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */

@RestController
public class ODGetParksDetailsRestService {
	
	/**
	 * @param request
	 * @param parkId
	 * @return  1 in case of error or 200 if successful
	 * @throws Exception 
	 */
	@RequestMapping(value="/getParksDetails",method=RequestMethod.GET,produces={"application/json"})
	 public String getParksDetails(HttpServletRequest request,@RequestParam ("parkId") String parkId,@RequestParam ("parkType") String parkType,@RequestParam ("checkIn") String checkIn,@RequestParam ("checkOut") String checkOut,@RequestParam ("reservationDate") String reservationDate) throws Exception{
		//Logger class
		 Logger logger = Logger.getLogger(ODGetParksInfoRestService.class);
		 
		// Capture service Start time
			
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
				  
		    CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResult=CommonCISValidation.getParksDetailsValidation(request,parkId,checkIn,checkOut);
			if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			{
		    ODGetParkDetailsWebservice parkDetailsWebservice = new ODGetParkDetailsWebservice();
			 cisResult = parkDetailsWebservice.getParksDetails(parkId,parkType,checkIn,checkOut,reservationDate);
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
