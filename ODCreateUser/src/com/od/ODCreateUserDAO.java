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
		
			 String serviceEndTime=time.getTimeZone();
			 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 
			 logger.info("user table query time:: " +cisResults);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
		
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
		
	}



	public CISResults createUserHeader(String userId, String reservationId,
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
			getJdbcTemplate().update(ODCreateUserQuery.SQL_USERTABLE_HEADER,userId,reservationId,reservedDate,createDate);
			
			cisResults.setResultObject(reservationId);
			
			String serviceEndTime=time.getTimeZone();
			 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("user table3 query time:: " +cisResults);
		 
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
		
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
		
	}

	

	public CISResults createUserDetails(String reservationId, int parkId,
			String title, float price,
			String typeCode, int quantity, String type, Date fromDate, Date toDate, float totalPrice,
			String status, String createDate) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(ODCreateUserQuery.SQL_USERTABLE_DETAILS,reservationId,parkId,title,price,typeCode,quantity,type,fromDate,toDate,totalPrice,status,createDate);
			
			String serviceEndTime=time.getTimeZone();
			 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("user table2 query time:: " +cisResults);

		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
		
	}


	public CISResults getAvailablility(int parkId) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{parkId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List res = getJdbcTemplate().query(ODCreateUserQuery.SQL_GETAVAILABILITY,inputs,new GetAvailabilityMapper());
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get park details service:: " +result );
			cisResults.setResultObject(res);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return cisResults;  
	}
}