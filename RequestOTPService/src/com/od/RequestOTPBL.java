package com.od;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.SMSCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class RequestOTPBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	RequestOTPDAO otpDAO=(RequestOTPDAO)ctx.getBean("Requestotp");
	
	public CISResults requestOTP(String phoneNumber) throws Throwable  {
		SMSCommunication smsCommunicaiton=new SMSCommunication();
		CISResults cisResults=new CISResults();
		      final Logger logger = Logger.getLogger(RequestOTPBL.class);
		      checkOTPTime otpTimeCheck=new checkOTPTime();
		   // Capture service Start time
			  TimeCheck time=new TimeCheck();
				 testServiceTime seriveTimeCheck=new testServiceTime();
				 String serviceStartTime=time.getTimeZone();
		      
		      String contact = phoneNumber;
		      String deleteInd=CISConstants.DELETE_IND;
			 
		      Calendar currentdate = Calendar.getInstance();
		      DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONEIND);
		      formatter.setTimeZone(obj);
		      
		      Random random = new Random( System.currentTimeMillis() );
			  int otpNumber= ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
			  
			  
			 
		       /* cisResults = otpDAO.requestOTP(contact,otpNumber,formatter.format(currentdate.getTime()),deleteInd);
		        cisResults.setResultObject(cisResults);
		        cisResults=smsCommunicaiton.sendSMS(contact,otpNumber);*/
			  
			   cisResults = otpDAO.validateOTPTime(contact,deleteInd);
			 
			  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			  {
			     ValidateOTP validate=(ValidateOTP)cisResults.getResultObject();
			     otpNumber=Integer.parseInt(validate.getOtp());
			     cisResults=smsCommunicaiton.sendSMS(contact,otpNumber);
			  }
			  else
			  {
				  cisResults=smsCommunicaiton.sendSMS(contact,otpNumber);
				 
			        cisResults = otpDAO.requestOTP(contact,otpNumber,formatter.format(currentdate.getTime()),deleteInd);
			        cisResults.setResultObject(cisResults);
				 
			  }
	
			// Capture Service End time
			  String serviceEndTime=time.getTimeZone();
			  seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  logger.info("Database time for request otp service:: " +cisResults );
			
		return cisResults;
		
	}

}
