package com.od;

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

	
	
	}
