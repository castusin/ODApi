package com.od;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;


public class UpdatePasswordServiceBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	
	UpdatePasswordServiceDAO updatePasswordServiceDAO=(UpdatePasswordServiceDAO)ctx.getBean("UpdatePassword");

	public CISResults updatePassword(String emailId,String otp,String password) {
		final Logger logger = Logger.getLogger(ForgotPasswordBL.class);
		// String passwordToHash = parkregisteration.getPassword();
         String generatedPassword = null;
		
		 try {
             // Create MessageDigest instance for MD5
             MessageDigest md = MessageDigest.getInstance("MD5");
             //Add password bytes to digest
             md.update(password.getBytes());
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
		 
		 CISResults cisResult = updatePasswordServiceDAO.validateOTP(emailId,otp);
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
		 cisResult = updatePasswordServiceDAO.updatePassword(emailId,generatedPassword);
		  }
		 else{
         	 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	    	     cisResult.setErrorMessage("Incorrect OTP");
	       }
		  
		 logger.info("OD: Update passwordBL  service" +cisResult );
		
		 return cisResult;
		
	}


}