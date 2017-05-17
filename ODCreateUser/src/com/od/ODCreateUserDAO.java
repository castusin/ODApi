package com.od;

import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.io.InputStreamReader;

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

	public CISResults pay()throws NoSuchAlgorithmException, Throwable {
		
		 byte[] dataBytes = new byte[1024];
		 CISResults cisResult=new CISResults(); 
		String key="nScTz3tw" ;

		float amount=100;
		String productinfo="ODinfo";
		String firstname="uday";
		String email="udaykatikala@gmail.com";
		String salt="A64STBWqP9";
		String surl="www.google.com";
		String phone="9440069067";
		String txnid="40359a951310ea72cbf1";
		String hash= "nScTz3tw|40359a951310ea72cbf1|100|ODinfo|uday|udaykatikala@gmail.com||||||||||A64STBWqP9";
		
		 MessageDigest md = MessageDigest.getInstance("SHA-512");
		 md.update(hash.getBytes());
		 byte byteData[] = md.digest();

		 //convert the byte to hex format method 1
		 StringBuffer hashCodeBuffer = new StringBuffer();
		 for (int i = 0; i < byteData.length; i++) {
		 hashCodeBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		 }
		/* Object _payment="key|amount|productinfo|firstname|email|payUdata|salt";
		 String URL = "https://test.payu.in/_payment";*/
		 
		 
		 String postData="";
         String retval = "";
       
         postData += "key=" + key + "&amount=" + amount + "&productinfo=" +           
        		 productinfo +"&firstname=" +firstname + "&email="+email+ "&hash="+hash+ "&surl="+surl+"&phone="+phone +"&txnid="+txnid +"&salt="+salt;
		 URL url = new URL("https://test.payu.in/_payment");
		 HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
         urlconnection.setRequestMethod("POST");
         urlconnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
         urlconnection.setDoOutput(true);
         OutputStreamWriter out = new            
         OutputStreamWriter(urlconnection.getOutputStream());
         out.write(postData);
         out.close();
         BufferedReader in = new BufferedReader( new  InputStreamReader(urlconnection.getInputStream()));
         String decodedString;
         while ((decodedString = in.readLine()) != null) {
               retval += decodedString;
         }
         in.close();
		 
         System.out.println("PAY U STATUS: "+retval);
		
		 
		return cisResult;
		
	}
		
}

//String data= "nScTz3tw|40359a951310ea72cbf1|100|ODinfo|uday|udaykatikala@gmail.com||||||||||A64STBWqP9";

//URL = "https://test.payu.in/_payment";