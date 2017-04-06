package com.od;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.testServiceTime;
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
		  
		 // Capture service Start time
		  testServiceTime sessionTimeCheck=new testServiceTime();
		  Calendar currentdate = Calendar.getInstance();
		  DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		  TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
		  formatter.setTimeZone(obj);
		  String serviceStartTime=formatter.format(currentdate.getTime());
		 
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults cisResult=CommonCISValidation.SaveParkInfoValidation(saveParkInfo,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			  ODSaveParkInfoWebservice saveParkInfoWebservice = new ODSaveParkInfoWebservice();
		      cisResult = saveParkInfoWebservice.saveParkInfo(saveParkInfo);
		    }
		// Capture Service End time
		  Calendar ServiceEnd= Calendar.getInstance();
	      DateFormat formatter1 = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone obj1 = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	      formatter1.setTimeZone(obj1);
		  String serviceEndTime=formatter1.format(ServiceEnd.getTime());
		  sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		
		  
		  return returnJsonData(cisResult);
	}
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}