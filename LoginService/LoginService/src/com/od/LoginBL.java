package com.od;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
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

	
	public CISResults login(String username, String password) throws Throwable {
		
		ODParkRegistrationModel loginUser = new ODParkRegistrationModel();
		// Capture service Start time
		TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 String createDate=time.getTimeZone();
		 
		 
		  //password encryption
         String passwordToHash = password;
         String generatedPassword = null;
         try {
             // Create MessageDigest instance for MD5
             MessageDigest md = MessageDigest.getInstance("MD5");
             //Add password bytes to digest
             md.update(passwordToHash.getBytes());
             //Get the hash's bytes 
             byte[] bytes = md.digest();
             //This bytes[] has bytes in decimal format;
             //Convert it to hexadecimal format
             StringBuilder sb = new StringBuilder();
             for(int i=0; i< bytes.length ;i++)
             {
                 sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
             }
             //Get complete hashed password in hex format
             generatedPassword = sb.toString();
         } 
         catch (NoSuchAlgorithmException e) 
         {
             e.printStackTrace();
         }
		 
		 
		final Logger logger = Logger.getLogger(LoginBL.class);
		CISResults cisResult = loginDAO.getPassword(username);
		
		 ODParkRegistrationModel  loginuser=(ODParkRegistrationModel)cisResult.getResultObject();
         String userPassword=loginuser.getPassword();
         if(userPassword.equalsIgnoreCase(generatedPassword)){
        	 cisResult = loginDAO.Updatelogin(createDate,username);
        	 cisResult = loginDAO.login(username,generatedPassword);
		
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