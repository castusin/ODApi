/**
 * 
 */
package com.od;

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
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults cisResult=CommonCISValidation.ParksinfoValidation(metro,localArea,odRating,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			  ODGetParkInfoWebService parkInfoWebService = new ODGetParkInfoWebService();
		      cisResult = parkInfoWebService.getParksinfo(metro,localArea,odRating);
		    }
		
		  return returnJsonData(cisResult);
	}
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
