
package com.od;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODParkRegistrationBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODParkRegistrationDAO registrationDAO=(ODParkRegistrationDAO)ctx.getBean("ParkRegistration");
	
	public CISResults parkRegestration(ODParkRegistrationModel parkregisteration) throws Throwable {
		
		 // Capture service Start time
			 EmailCommunication sendMail=new EmailCommunication();
			 SMSCommunication smsCommunicaiton=new SMSCommunication();
	         CISResults cisResults=new CISResults();
	         TimeCheck time=new TimeCheck();
	         testServiceTime seriveTimeCheck=new testServiceTime();
	         String serviceStartTime=time.getTimeZone();
	       
			 final Logger logger = Logger.getLogger(ODParkRegistrationBL.class);
			
			
			 String createDate=time.getTimeZone();
			 String user=parkregisteration.getUsername();
			 String contact=parkregisteration.getPhoneNumber();
			 String sessionId = UUID.randomUUID().toString();
	         String userId=DigestUtils.sha256Hex(sessionId);
	         String upToNCharacters = userId.substring(0, Math.min(userId.length(), 6));
	         userId=upToNCharacters;
	         //password encryption
	         String passwordToHash = parkregisteration.getPassword();
	         String generatedPassword = null;
	         String firstName=parkregisteration.getFirstName();
	         String lastName=parkregisteration.getLastName();
	         String emailId=parkregisteration.getUsername();
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
	         cisResults = registrationDAO.checkEmail(emailId,parkregisteration.getPhoneNumber());
	            
	         if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE))
             {
	         cisResults = registrationDAO.parkRegestration(userId,parkregisteration.getFirstName(),parkregisteration.getLastName(),parkregisteration.getUsername(),generatedPassword,parkregisteration.getPhoneNumber(),parkregisteration.getUserType(),parkregisteration.getGoogleFbId(),parkregisteration.getProfilePicUrl(),parkregisteration.getUserGender(),parkregisteration.getUserRole(),createDate,parkregisteration.getCreatedBy(),createDate,parkregisteration.getUpdatedBy(),createDate,createDate);
	        // cisResults.setResultObject(cisResults);
	         	if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	         	{
	         		String mail=sendMail.sendRegisterMail(firstName,lastName,emailId);
	         		String sms=smsCommunicaiton.sendRegisterSMS(contact,firstName);
	         	}
           
             }else{
	    	   cisResults.setErrorMessage("user already exists, please login");
	       }
			 String serviceEndTime=time.getTimeZone();
			 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Database time for park registration service:: " +result );
			// cisResults.setResultObject(cisResults);
			 return cisResults;
		}

	}
