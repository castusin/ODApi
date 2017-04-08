
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
import com.google.gson.Gson;
import com.validation.CommonCISValidation;


@RestController
public class ODGetParksDetailsRestService {
	
	@RequestMapping(value="/getParksDetails",method=RequestMethod.GET,produces={"application/json"})
	 public String getParksDetails(HttpServletRequest request,@RequestParam ("parkId") String parkId){
		//Logger class
		 Logger logger = Logger.getLogger(ODGetParksInfoRestService.class);
		 
		 // Capture service Start time
		  testServiceTime sessionTimeCheck=new testServiceTime();
		  Calendar currentdate = Calendar.getInstance();
		  DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		  TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
		  formatter.setTimeZone(obj);
		  String serviceStartTime=formatter.format(currentdate.getTime());
				  
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults cisResult=CommonCISValidation.ParksDetailsValidation(parkId,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			  ODGetParkDetailsWebservice parkDetailsWebservice = new ODGetParkDetailsWebservice();
		      cisResult = parkDetailsWebservice.getParksDetails(parkId);
		      
		    }
		  
		// Capture Service End time
		  Calendar ServiceEnd= Calendar.getInstance();
	      DateFormat formatter1 = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone obj1 = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	      formatter1.setTimeZone(obj1);
		  String serviceEndTime=formatter1.format(ServiceEnd.getTime());
		  sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  
		  return returnJsonData(cisResult);
	}
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
