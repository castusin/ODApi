package com.od;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class ODCreateUserDAO extends JdbcDaoSupport{

	public CISResults createUser(int userId, String firstName, String lastName,
			int phoneNumber1, int phoneNumber2, String address1,
			String address2, String city, String state, int pincode, String createDate) {
		Logger logger = Logger.getLogger(ODCreateUserDAO.class);
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(ODCreateUserQuery.SQL_USERTABLE,userId,firstName,lastName,phoneNumber1,phoneNumber2,address1,address2,city,state,pincode,createDate);
			cisResults.setResponseCode(CISConstants.YES); 
			String serviceEndTime=time.getTimeZone();
			 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("user table query time:: " +cisResults);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			//cisResults.setResponseCode(CISConstants.NO);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
		
	}

	public CISResults createUser2(int reservationId, int parkId,
			String userType, String faciltiyTypecode, Date fromDate,
			Date toDate, int qty, float totalPrice, String status, String createDate) {
		Logger logger = Logger.getLogger(ODCreateUserDAO.class);
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(ODCreateUserQuery.SQL_USERTABLE2,reservationId,parkId,faciltiyTypecode,fromDate,toDate,qty,totalPrice,status,createDate,userType);
			cisResults.setResponseCode(CISConstants.YES);  
			String serviceEndTime=time.getTimeZone();
			 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("user table2 query time:: " +cisResults);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			//cisResults.setResponseCode(CISConstants.NO); 
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
		
	}

	public CISResults createUser3(int userId, int reservationId,
			Date reservedDate, String createDate) {
		Logger logger = Logger.getLogger(ODCreateUserDAO.class);
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(ODCreateUserQuery.SQL_USERTABLE3,userId,reservationId,reservedDate,createDate);
			cisResults.setResponseCode(CISConstants.YES); 
			String serviceEndTime=time.getTimeZone();
			 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("user table3 query time:: " +cisResults);
			 
			 
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			//cisResults.setResponseCode(CISConstants.NO); 
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
		
	}

	public String pay()throws NoSuchAlgorithmException {
		
		 byte[] dataBytes = new byte[1024];
		/*String key="nScTz3tw" ;

		float amount=100;
		String productinfo="ODinfo";
		String firstname="uday";
		String email="udaykatikala@gmail.com";
		String salt="A64STBWqP9";*/
		String payUdata= "nScTz3tw|40359a951310ea72cbf1|100|ODinfo|uday|udaykatikala@gmail.com||||||||||A64STBWqP9";
		
		 MessageDigest md = MessageDigest.getInstance("SHA-512");
		 md.update(payUdata.getBytes());
		 byte byteData[] = md.digest();

		 //convert the byte to hex format method 1
		 StringBuffer hashCodeBuffer = new StringBuffer();
		 for (int i = 0; i < byteData.length; i++) {
		 hashCodeBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		 }
		return hashCodeBuffer.toString();
		
	}
		/*public  String convertByteToHex(byte data[])
		{
		  StringBuffer hexData = new StringBuffer();
		  for (int byteIndex = 0; byteIndex < data.length; byteIndex++)
		      hexData.append(Integer.toString((data[byteIndex] & 0xff) + 0x100, 16).substring(1));
		  
		  return hexData.toString();
		}
	
		public  String hashText(String textToHash) throws Exception
		{
		  final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
		  sha512.update(textToHash.getBytes());
		  
		  return convertByteToHex(sha512.digest());
		}
		*/
		
		}

		/*public class SHA512 {
		public  void main(String args[]) throws Exception {
		    String password = "pass@word1";
		
			    if ((args.length == 1) && (args[0].length() > 0))
			    {
			    	password = args[0];
			    }
		      System.out.println("Password: " + password + " in SHA512 is:");
		      System.out.println(hashText(password));
		}
		
		public  String convertByteToHex(byte data[])
		{
		  StringBuffer hexData = new StringBuffer();
		  for (int byteIndex = 0; byteIndex < data.length; byteIndex++)
		      hexData.append(Integer.toString((data[byteIndex] & 0xff) + 0x100, 16).substring(1));
		  
		  return hexData.toString();
		}
		
		public  String hashText(String textToHash) throws Exception
		{
		  final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
		  sha512.update(textToHash.getBytes());
		  
		  return convertByteToHex(sha512.digest());
		}
		}






}*/

//String data= "nScTz3tw|40359a951310ea72cbf1|100|ODinfo|uday|udaykatikala@gmail.com||||||||||A64STBWqP9";

//URL = "https://test.payu.in/_payment";