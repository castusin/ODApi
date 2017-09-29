package com.od;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

@RestController
public class ODUpdatePasswordRestService {

	 
	@RequestMapping(value="/updatePassword",method=RequestMethod.GET,produces={"application/json"})

	 public String updatePassword(HttpServletRequest request,@RequestParam ("userName") String userName,@RequestParam ("otp") String otp, @RequestParam ("password") String password) throws Throwable{
		 Logger logger = Logger.getLogger(ODUpdatePasswordRestService.class);
		 		
        CommonCISValidation CommonCISValidation=new CommonCISValidation();
		
		CISResults cisResults=CommonCISValidation.updatePasswordValidation(request,userName,otp,password);
		if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
			UpdatePasswordServiceWebservice updatePasswordService= new UpdatePasswordServiceWebservice();
		  cisResults  = updatePasswordService.updatePassword(userName,otp,password);
		  logger.info(" OD: Update password rest :"+cisResults);
		  }
		  return returnJsonData(cisResults);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}