package com.validation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.od.ODCreateUserModel;
import com.od.ODGetCitiesModel;
import com.od.ODParkRegistrationModel;


public class CommonCISValidation {
	
	
	public CISResults  ParksinfoValidation(String metro,int localId,HttpServletRequest request) {
		
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
public CISResults  ParksDetailsValidation(String parkId,HttpServletRequest request) {
		
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
public CISResults getCouponcodeValidation(HttpServletRequest request,
		String parkId, String checkIn, String couponCode) {
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

public CISResults  CreateUserValidation(HttpServletRequest request,ODCreateUserModel createUser) {
	
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
public CISResults viewCitiesValidation(HttpServletRequest request,
		ODGetCitiesModel viewCities) {
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
public CISResults getParksLocalAreaDataValidation(HttpServletRequest request,
		String cityId) {
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
public CISResults getParksDetailsValidation(HttpServletRequest request,
		String parkId, String checkIn, String checkOut) {
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
public CISResults paymentSuccessValidation(HttpServletRequest request,
		String transactionId, String status, String cod) {
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
public CISResults parkRegestrationValidation(HttpServletRequest request,
		ODParkRegistrationModel parkregisteration) {
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
public CISResults viewStateCitiesValidation(HttpServletRequest request,
		String stateId) {

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
public CISResults forgotPasswordValidation(HttpServletRequest request,
		 String userName) {


	CISResults CISResults=new CISResults();

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
    
    
 
	 return CISResults;
}
public CISResults updatePasswordValidation(HttpServletRequest request,
		String userName,String otp, String password) {


	CISResults CISResults=new CISResults();

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
    
    
 
	 return CISResults;
}
public CISResults getCategoriesValidation(HttpServletRequest request,
		int cityId, String parkType) {
	CISResults CISResults=new CISResults();

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
    
    
 
	 return CISResults;
}

}
