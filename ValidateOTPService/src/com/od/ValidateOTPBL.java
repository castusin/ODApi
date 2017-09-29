package com.od;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.SMSCommunication;
/**
 * Validates OTP 
 * @author Castus Info Solutions
 *
 */

public class ValidateOTPBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ValidateOTPDAO verifyOTPDAO=(ValidateOTPDAO)ctx.getBean("validateotp");

	/**
	 * @param phoneNumber
	 * @param emailId
	 * @param otp
	 * @return
	 * @throws Throwable 
	 * @throws JSONException 
	 */
	public CISResults validateOTP(String phoneNumber,String otp) throws JSONException, Throwable {
		final Logger logger = Logger.getLogger(ValidateOTPBL.class);
		checkOTPTime otpTimeCheck=new checkOTPTime();
		
		SMSCommunication smsCommunicaiton=new SMSCommunication();
		CISResults cisResult=new CISResults();
		cisResult=smsCommunicaiton.verifyOtp(phoneNumber,otp);
		if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
			cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			
		}else{
			cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResult.setErrorMessage("Invalid passcode");
		}
			
		
		/*String contact=phoneNumber;
		String deleteInd=CISConstants.DELETE_IND;
		 Calendar currentdate = Calendar.getInstance();
	      DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONEIND);
	      formatter.setTimeZone(obj);
	     
	    String OtpTimeGenerateTime;
		CISResults cisResult = verifyOTPDAO.validateOTP(contact,otp,deleteInd);
		logger.info("Validate OTP  BL service" +cisResult );
		if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
		 ValidateOTP validate=(ValidateOTP)cisResult.getResultObject();
		 OtpTimeGenerateTime=validate.getTimeStamp();
		  String currentDateTime = formatter.format(currentdate.getTime());
		  
		  cisResult=otpTimeCheck.getOTPTime(currentDateTime,OtpTimeGenerateTime);
		  
		}*/
		
		return cisResult;
	}


}