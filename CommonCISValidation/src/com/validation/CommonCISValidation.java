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
	    
		 //Validate Email Format validation
		 
	    /*if(CISResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  { 
			 String emailCheck = CISConstants.EMAIL_REGEX;
		    // Boolean checkValue = parksInfo.getEmailId().matches(emailCheck);
			// if(Boolean.FALSE.equals(checkValue))
			  {
				 CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			  }
		   } */
		 CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
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
	    
		 //Validate Email Format validation
		 
	    /*if(CISResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  { 
			 String emailCheck = CISConstants.EMAIL_REGEX;
		    // Boolean checkValue = parksInfo.getEmailId().matches(emailCheck);
			// if(Boolean.FALSE.equals(checkValue))
			  {
				 CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			  }
		   } */
		 CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		 return CISResults;
	}
/*public CISResults  SaveParkInfoValidation(ODSaveParkInfoModel saveParkInfo,HttpServletRequest request) {
		
		CISResults CISResults=new CISResults();
		ArrayList<String> registrationValues= new ArrayList<String>();
		registrationValues.add(registration.getAppId());
		registrationValues.add(registration.getUserId());
		registrationValues.add(registration.getAccountType());
		registrationValues.add(registration.getFirstName());
		registrationValues.add(registration.getLastName());
		registrationValues.add(registration.getPhoneNumber());
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
		 
	    
	    
	    
	    
		 //Validate Email Format validation
		 
	    
	    if(CISResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  { 
			 String emailCheck = CISConstants.EMAIL_REGEX;
		     Boolean checkValue = registration.getEmailId().matches(emailCheck);
			 if(Boolean.FALSE.equals(checkValue))
			  {
				 CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			  }
		   } 
		 CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		 return CISResults;
	}
	*/
}
