package com.od;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;
@RestController
public class ODLoginService {

	@RequestMapping(value="/loginService",method=RequestMethod.GET,produces={"application/json"})

	 public String login(HttpServletRequest request,@RequestParam ("phoneNumber") String phoneNumber,@RequestParam ("emailId") String emailId,@RequestParam ("password") String password) throws Throwable{
		 Logger logger = Logger.getLogger(ODLoginService.class);
		/* String loginServiceParameters = "userId=" +userId + "&accountType=" + accountType+"&password=" + password ;
		 logger.info(" DigitalHealthCare: loginService :"+loginServiceParameters);*/
		 
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime sessionTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 
		 
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 //CISResults cisResult=CommonCISValidation.loginValidation(userId,password,accountType,request);
		//  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 // {
		     LoginWebservice loginService= new LoginWebservice();
		     CISResults cisResult  = loginService.login(phoneNumber,emailId,password);
		 // }
		  
		  
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Total service time for login service in milli seconds :: " +result );
		 return returnJsonData(cisResult);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
