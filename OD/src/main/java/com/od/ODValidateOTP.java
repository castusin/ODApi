package com.od;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;
@RestController
public class ODValidateOTP {

	@RequestMapping(value="/validateOTPService",method=RequestMethod.GET,produces={"application/json"})

	 public String validateOTP(HttpServletRequest request,@RequestParam ("phoneNumber") String phoneNumber,@RequestParam ("otp") String otp){
		 Logger logger = Logger.getLogger(ODValidateOTP.class);
		 String postData = "phoneNumber=" +phoneNumber + "&otp=" + otp ;
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		
		 //CISResults cisResult=CommonCISValidation.validateOTPValidation(phoneNumber,emailId,otp,request);
		// if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 // {
		 ValidateOTPWebservice verifyOTPWebService= new ValidateOTPWebservice();
		 CISResults cisResult  = verifyOTPWebService.validateOTP(phoneNumber,otp);
		  logger.info(" DigitalHealthCare:Validate OTP :"+postData);
		//  }
		  return returnJsonData(cisResult);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
