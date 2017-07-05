
/**
 * 
 */
package com.od;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : Payment success
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */


@RestController
public class ODPaymentSuccess {
	

	
	/**
	 * @param request
	 * @param metro
	 * @param localArea
	 * @param parkType
	 * @return 1 in case of error or 200 if successful
	 */
	@RequestMapping(value="/paymentStatus",method=RequestMethod.GET,produces={"application/json"})
	 public String paymentSuccess(HttpServletRequest request,@RequestParam ("transactionId") String transactionId,@RequestParam ("status") String status,@RequestParam ("cod") String cod){
		
		 Logger logger = Logger.getLogger(ODGetParksInfoRestService.class);
		 
		// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
				  
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults cisResult=CommonCISValidation.paymentSuccessValidation(request,transactionId,status,cod);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
		  ODPaymentSuccessWebservice successWebservice = new ODPaymentSuccessWebservice();
		   cisResult = successWebservice.paymentSuccess(transactionId,status,cod);
		  }
		  
		// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Total service time for payment success service:: " +result );
		  
		  return returnJsonData(cisResult);
	}
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
