package com.od;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;


@RestController
public class ODSaveParksInfoRestService {

	@RequestMapping(value="/saveParkInfo",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	 public String saveParkInfo(HttpServletRequest request,@RequestBody ODGetParkInfoModel saveParkInfo){
		
		 Logger logger = Logger.getLogger(ODSaveParksInfoRestService.class);
		 /* String requestParameters = "appId=" + registration.appId + "&userId=" + registration.userId + "&firstName=" +           
				 registration.firstName +"&lastName=" +registration.lastName + "&phoneNumber="+registration.phoneNumber+ "&emailId="+registration.emailId+ "&photo="+registration.photo+ "&accountType="+registration.accountType+ "&gender="+registration.gender+ "&dob="+registration.dob+ "&date="+registration.date;
		  logger.info("Digital HealthCare SaveProfile Request Parameters :"+requestParameters);*/
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults cisResult=CommonCISValidation.SaveParkInfoValidation(saveParkInfo,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			  ODSaveParkInfoWebservice saveParkInfoWebservice = new ODSaveParkInfoWebservice();
		      cisResult = saveParkInfoWebservice.saveParkInfo(saveParkInfo);
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