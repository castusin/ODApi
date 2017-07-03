package com.od;

import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.io.InputStreamReader;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class ODCreateUserDAO extends JdbcDaoSupport{

	public CISResults createUser(String userId, String firstName, String lastName,String emailId,
			String phone1, String phone2, String address1,
			String address2, String city, String state,  int pincode, String createDate) {
		Logger logger = Logger.getLogger(ODCreateUserDAO.class);
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(ODCreateUserQuery.SQL_USERTABLE,userId,firstName,lastName,emailId,phone1,phone2,address1,address2,city,state,pincode,createDate);
			//cisResults.setResponseCode(CISConstants.YES); 
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

/*	public CISResults createUser2(int reservationId, int parkId,
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
			//cisResults.setResponseCode(CISConstants.YES);  
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
		
	}*/

	public CISResults createUser3(String userId, String reservationId,
			Date reservedDate, String createDate) {
		Logger logger = Logger.getLogger(ODCreateUserDAO.class);
		CISResults cisResults=new CISResults();
		ODCreateUserModel createUser = new ODCreateUserModel();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(ODCreateUserQuery.SQL_USERTABLE3,userId,reservationId,reservedDate,createDate);
			//createUser.setReservationId(reservationId);
			cisResults.setResultObject(reservationId);
			//cisResults.setResponseCode(CISConstants.YES); 
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

	/*public CISResults createPackageDetails(int parkId, String facilitytitle,
			float facilityprice, String facilitycode, String roomtitle,
			float roomprice, int roomQuantity) {
		CISResults cisResults=new CISResults();
		//List<FacilityDetails> facilityDetails=null;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//Object[] inputs = new Object[]{parkId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(ODCreateUserQuery.SQL_CREATEPACKAGEDETAILS,parkId,facilitytitle,facilityprice,facilitycode,roomtitle,roomprice,roomQuantity);
		     
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get facility details service:: " +result );
			//cisResults.setResultObject(res);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return cisResults;  
	}*/
	/*public CISResults pay()throws NoSuchAlgorithmException, Throwable {
        
        byte[] dataBytes = new byte[1024];
        CISResults cisResult=new CISResults();
        String key="nScTz3tw" ;

	       float amount=100;
	       String productinfo="test";
	       String firstname="darshan";
	       String email="darshan1@gmail.com";
	       String salt="A64STBWqP9";
	       String surl="www.google.com";
	       String furl="www.gmail.com";
	       String service_provider="payu_paisa";
	       String phone="8686846199";
	       String txnid="e36afd8be1cd6bbaf1bd";
	       String hash= "nScTz3tw|e36afd8be1cd6bbaf1bd|100|test|darshan|darshan1@gmail.com|||||||||||A64STBWqP9";
      
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(hash.getBytes());
        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer hashCodeBuffer = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
        hashCodeBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
      
        String str = hashCodeBuffer.toString();
        System.out.println(str);
        
        
        
        String postData="";
        String retval = "";
 
    postData += "key=" + key + "&txnid="+txnid +"&amount=" +amount+ "&productinfo=" +          
              productinfo +"&firstname=" +firstname + "&email="+email+ "&phone="+phone+"&surl="+surl+ "&furl="+furl+"&hash="+str+"&service_provider="+service_provider;
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
      
    cisResult.setResultObject(retval);
       return cisResult;
      
 }*/

	public CISResults createUser2(String reservationId, int parkId,
			String title, float price,
			String typeCode, int quantity, String type, Date fromDate, Date toDate, float totalPrice,
			String status, String createDate) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
//reservationId,parkId,createUser.getUserType(),Facilitytitle,Facilityprice,Facilitycode,FacilityQuantity,Roomtitle,Roomprice,Roomcode,RoomQuantity,createUser.getFromDate(),createUser.getToDate(),createUser.getTotalPrice(),createUser.getStatus(),createDate);
			  			
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(ODCreateUserQuery.SQL_USERTABLE2,reservationId,parkId,title,price,typeCode,quantity,type,fromDate,toDate,totalPrice,status,createDate);
			//cisResults.setResponseCode(CISConstants.YES);  
			String serviceEndTime=time.getTimeZone();
			 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("user table2 query time:: " +cisResults);
//			/,,,Room_type_code,,,,,,,,,,User_type
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			//cisResults.setResponseCode(CISConstants.NO); 
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
		
	}


	/*public List<FacilityDetails> getFacilityDetails(int parkId) {
		
		CISResults cisResults=new CISResults();
		List<FacilityDetails> facilityDetails=null;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{parkId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			facilityDetails = getJdbcTemplate().query(ODCreateUserQuery.SQL_GETFACILITYDETAILS,inputs,new FacilityMapper());
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get facility details service:: " +result );
			//cisResults.setResultObject(res);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return facilityDetails;  
	}
*/
	/*public CISResults createFacilityDetails(int parkId,
			String facilityCode, float rate, int qty) {
		CISResults cisResults=new CISResults();
		//List<FacilityDetails> facilityDetails=null;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//Object[] inputs = new Object[]{parkId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(ODCreateUserQuery.SQL_CREATEFACILITYDETAILS,parkId,facilityCode,rate,qty);
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get facility details service:: " +result );
			//cisResults.setResultObject(res);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return cisResults;  
	}

	public CISResults createRoomDetails(int parkId, String roomtypeCode,
			float rate, int qty) {
		CISResults cisResults=new CISResults();
		//List<FacilityDetails> facilityDetails=null;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//Object[] inputs = new Object[]{parkId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(ODCreateUserQuery.SQL_CREATEROOMDETAILS,parkId,roomtypeCode,rate,qty);
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get facility details service:: " +result );
			//cisResults.setResultObject(res);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return cisResults;  
	}*/
}

//String data= "nScTz3tw|40359a951310ea72cbf1|100|ODinfo|uday|udaykatikala@gmail.com||||||||||A64STBWqP9";

//URL = "https://test.payu.in/_payment";