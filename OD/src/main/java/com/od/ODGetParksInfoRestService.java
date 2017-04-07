/**
 * 
 */
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

/**
 * @author Darshan
 *
 */
@RestController
public class ODGetParksInfoRestService {
	
	@RequestMapping(value="/getParksinfo",method=RequestMethod.GET,produces={"application/json"})
	 public String getParksinfo(HttpServletRequest request,@RequestParam ("metro") String metro, @RequestParam ("localArea") String localArea,@RequestParam ("odRating") String odRating){
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
		  CISResults cisResult=CommonCISValidation.ParksinfoValidation(metro,localArea,odRating,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			  ODGetParkInfoWebService parkInfoWebService = new ODGetParkInfoWebService();
		      cisResult = parkInfoWebService.getParksinfo(metro,localArea,odRating);
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
