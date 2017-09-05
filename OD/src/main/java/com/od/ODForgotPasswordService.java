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
public class ODForgotPasswordService {

	 
	@RequestMapping(value="/forgotPassword",method=RequestMethod.GET,produces={"application/json"})

	 // public String forgotPassword(HttpServletRequest request,@RequestParam ("emailId") String emailId, @RequestParam ("phoneNumber") String phoneNumber) throws Throwable{
	public String forgotPassword(HttpServletRequest request,@RequestParam ("userName") String userName) throws Throwable{
			
		Logger logger = Logger.getLogger(ODForgotPasswordService.class);
		CommonCISValidation CommonCISValidation=new CommonCISValidation();
		
		CISResults cisResults=CommonCISValidation.forgotPasswordValidation(request,userName);
		if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
			ForgotPasswordWebservice forgotPasswordWebservice= new ForgotPasswordWebservice();
		  cisResults  = forgotPasswordWebservice.forgotPassword(userName);
		  logger.info(" OD:forgot password rest :"+cisResults);
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