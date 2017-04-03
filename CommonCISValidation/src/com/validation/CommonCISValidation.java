package com.validation;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.od.ODGetParkInfoModel;


public class CommonCISValidation {
	
	
	public CISResults  ParksinfoValidation(String metro,String localArea,String odRating,HttpServletRequest request) {
		
		CISResults cisResult=new CISResults();
		ArrayList<String> registrationValues= new ArrayList<String>();
		/*registrationValues.add(registration.getAppId());
		registrationValues.add(registration.getUserId());
		registrationValues.add(registration.getAccountType());
		registrationValues.add(registration.getFirstName());
		registrationValues.add(registration.getLastName());
		registrationValues.add(registration.getPhoneNumber());*/
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        
		//Validate Headers AUTHROIZATION
	    if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	    {
	    	cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	    }else
	    {
	    	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	    }
	    
	    
	 // Validate Null Values in Profile Data
	    if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
	    
		 for (String checkvalues : registrationValues) {
	            if  (checkvalues==null || checkvalues.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          } 
		 }     
	    
		 //Validate Email Format validation
		 
	    /*if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  { 
			 String emailCheck = CISConstants.EMAIL_REGEX;
		    // Boolean checkValue = parksInfo.getEmailId().matches(emailCheck);
			// if(Boolean.FALSE.equals(checkValue))
			  {
				 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			  }
		   } */
		 cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		 return cisResult;
	}
	
}
