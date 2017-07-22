package com.od;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.SMSCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
/**
 * User Login Service. Validates password and generates session id
 * 
 * @author Castus Info Solutions
 *
 */

public class LoginBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	LoginDAO loginDAO=(LoginDAO)ctx.getBean("login");

	
	public CISResults login(String phoneNumber,String emailId, String password) throws Throwable {
		
		ODParkRegistrationModel loginUser = new ODParkRegistrationModel();
		// Capture service Start time
		TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		
		final Logger logger = Logger.getLogger(LoginBL.class);
		CISResults cisResult = loginDAO.getPassword(phoneNumber);
		
		 ODParkRegistrationModel  loginuser=(ODParkRegistrationModel)cisResult.getResultObject();
         String userPassword=loginuser.getPassword();
         if(userPassword.equalsIgnoreCase(password)){
		 cisResult = loginDAO.login(phoneNumber,emailId,password);
         }
         else{
        	 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
 			 cisResult.setErrorMessage(CISConstants. USER_LOGIN_STATUS);
         }
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for login service:: " +result );
		return cisResult;
	}
}