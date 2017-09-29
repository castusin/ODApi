package com.od;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.SMSCommunication;

public class RequestOTPBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	RequestOTPDAO otpDAO=(RequestOTPDAO)ctx.getBean("Requestotp");
	
	public CISResults requestOTP(String phoneNumber) throws Throwable  {
		
		SMSCommunication smsCommunicaiton=new SMSCommunication();
		CISResults cisResults=new CISResults();
		
		 cisResults = otpDAO.checkEmail(phoneNumber);
		 if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	       {
				 cisResults=smsCommunicaiton.sendSMS(phoneNumber);
	       }else{
	        	 cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
		    	 cisResults.setErrorMessage("Incorrect credentials");
		       }
		 //String str=phoneNumber;
		// cisResults = otpDAO.checkEmail(phoneNumber);
		/* if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
         {
			   try {   
				   int number = Integer.parseInt(phoneNumber);
				   cisResults=smsCommunicaiton.sendSMS(number);
				} catch (NumberFormatException nfe) {
				  nfe.printStackTrace();
				}
			
         }else{
        	 cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
	    	 cisResults.setErrorMessage("Incorrect credentials");
	       }*/
			
			
	/*	      final Logger logger = Logger.getLogger(RequestOTPBL.class);
		      checkOTPTime otpTimeCheck=new checkOTPTime();
		   // Capture service Start time
			  TimeCheck time=new TimeCheck();
			  testServiceTime seriveTimeCheck=new testServiceTime();
			  String serviceStartTime=time.getTimeZone();
		      
		      String contact = phoneNumber;
		      String deleteInd=CISConstants.DELETE_IND;
			 
		      Calendar currentdate = Calendar.getInstance();
		      DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMATE);
		      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONEIND);
		      formatter.setTimeZone(obj);
		      
		      Random random = new Random( System.currentTimeMillis() );
			  int otpNumber= ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
			  
			  cisResults = otpDAO.checkEmail(phoneNumber);
			  
			  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE))
	             {
				   //cisResults=smsCommunicaiton.sendSMS(contact,otpNumber);
				   
				   
				  	cisResults = otpDAO.requestOTP(contact,otpNumber,formatter.format(currentdate.getTime()),deleteInd);
				  	//cisResults=smsCommunicaiton.sendSMS(contact,otpNumber);
				  	cisResults.setResultObject(cisResults);
	             }else{
	            	 cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
	  	    	     cisResults.setErrorMessage("user already exists, please login");
	  	       }
			  
			  
			  
			  
			  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE))
	             {
				  	cisResults = otpDAO.validateOTPTime(contact,deleteInd);
			 
				  	if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
				  	{
				  		ValidateOTP validate=(ValidateOTP)cisResults.getResultObject();
				  		otpNumber=Integer.parseInt(validate.getOtp());
				  		cisResults=smsCommunicaiton.sendSMS(contact,otpNumber);
				  	}
				  	else
				  	{
				  		cisResults = otpDAO.requestOTP(contact,otpNumber,formatter.format(currentdate.getTime()),deleteInd);
				  		cisResults=smsCommunicaiton.sendSMS(contact,otpNumber);
				  		cisResults.setResultObject(cisResults);
				 
				  	}
	             }else{
	            	 cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
	  	    	     cisResults.setErrorMessage("user already exists, please login");
	  	       }
			// Capture Service End time
			  String serviceEndTime=time.getTimeZone();
			  seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  logger.info("Database time for request otp service:: " +cisResults );
			*/
		return cisResults;
		
	}

}
