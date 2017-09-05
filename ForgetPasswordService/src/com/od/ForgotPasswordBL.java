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
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;


public class ForgotPasswordBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ForgotPasswordDAO forgotPasswordDAO=(ForgotPasswordDAO)ctx.getBean("ForgetPassword");

	public CISResults forgotPassword(String userName) throws Throwable {
		final Logger logger = Logger.getLogger(ForgotPasswordBL.class);
		 
	      String deleteInd=CISConstants.DELETE_IND;
	      CISResults cisResults=new CISResults();
	      SMSCommunication smsCommunicaiton=new SMSCommunication();
	      EmailCommunication emailCommunication=new EmailCommunication();
	      Calendar currentdate = Calendar.getInstance();
	      DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMATE);
	      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONEIND);
	      formatter.setTimeZone(obj);
	      
	      
	      Random random = new Random( System.currentTimeMillis() );
		  int otpNumber= ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
		  
		  cisResults = forgotPasswordDAO.checkNumber(userName);
		  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
			  ODCheckMail  user=(ODCheckMail)cisResults.getResultObject();
			  String userEmail=user.getEmailId();
			  String userPhone=user.getPhoneNumber();
          
			  if(userName.equalsIgnoreCase(userEmail)){
				  cisResults=emailCommunication.sendForgotMail(userName,otpNumber); 
				  cisResults = forgotPasswordDAO.forgotPassword(userPhone,otpNumber,formatter.format(currentdate.getTime()),deleteInd,userEmail);
				
			  }
		  
			  else if(userName.equalsIgnoreCase(userPhone))
			  {
			                   
			    cisResults=smsCommunicaiton.sendSMS(userName,otpNumber);
			    cisResults = forgotPasswordDAO.forgotPassword(userPhone,otpNumber,formatter.format(currentdate.getTime()),deleteInd,userEmail);
				
			  	cisResults.setResultObject(cisResults);
			  }
		  }
		  else{
         	 cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
	    	     cisResults.setErrorMessage("Incorrect credentials");
	       }
		  
		logger.info("OD:forgot password BL service" +cisResults );
		
	
	return cisResults;
	}

	
}