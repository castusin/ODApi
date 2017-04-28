package com.validation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cis.CISConstants;
import com.cis.CISResults;


public class CommonCISValidation {
	
	
	public CISResults  ParksinfoValidation(String metro,String localArea,String parkType,HttpServletRequest request) {
		
		CISResults CISResults=new CISResults();
		ArrayList<String> registrationValues= new ArrayList<String>();
		/*registrationValues.add(registration.getAppId());
		registrationValues.add(registration.getUserId());
		registrationValues.add(registration.getAccountType());
		registrationValues.add(registration.getFirstName());
		registrationValues.add(registration.getLastName());
		registrationValues.add(registration.getPhoneNumber());*/
		CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        
		//Validate Headers AUTHROIZATION
	    if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	    {
	    	CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	    }else
	    {
	    	CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
	    }
	    
	    
	 // Validate Null Values in Profile Data
	    if(CISResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
	    
		 for (String checkvalues : registrationValues) {
	            if  (checkvalues==null || checkvalues.equals(""))
	            	CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          } 
		 }     
	    
		
		 return CISResults;
	}
public CISResults  ParksDetailsValidation(String parkId,HttpServletRequest request) {
		
		CISResults CISResults=new CISResults();
		ArrayList<String> registrationValues= new ArrayList<String>();
		/*registrationValues.add(registration.getAppId());
		registrationValues.add(registration.getUserId());
		registrationValues.add(registration.getAccountType());
		registrationValues.add(registration.getFirstName());
		registrationValues.add(registration.getLastName());
		registrationValues.add(registration.getPhoneNumber());*/
		CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        
		//Validate Headers AUTHROIZATION
	    if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	    {
	    	CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	    }else
	    {
	    	CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
	    }
	    
	    
	 // Validate Null Values in Profile Data
	    if(CISResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
	    
		 for (String checkvalues : registrationValues) {
	            if  (checkvalues==null || checkvalues.equals(""))
	            	CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          } 
		 }     
	    
		
		 return CISResults;
	}
public CISResults ParksLocalAreaData(String cityId, HttpServletRequest request) {
	// TODO Auto-generated method stub
	CISResults CISResults=new CISResults();
	ArrayList<String> registrationValues= new ArrayList<String>();
	CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
        
	//Validate Headers AUTHROIZATION
    if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
    {
    	CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
    }else
    {
    	CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
    }
    
    
 // Validate Null Values in Profile Data
    if(CISResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	 {
    
	 for (String checkvalues : registrationValues) {
            if  (checkvalues==null || checkvalues.equals(""))
            	CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
          } 
	 }  
	 return CISResults;
}
}
