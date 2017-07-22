package com.od;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class LoginDAO extends JdbcDaoSupport {
	
	
	public CISResults login(String phoneNumber,String emailId,String password) {
		
		Logger logger = Logger.getLogger(LoginDAO.class);
		
		CISResults cisResults=new CISResults();
		ODParkRegistrationModel loginModel;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{phoneNumber,emailId,password};
		try{	
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			loginModel=(ODParkRegistrationModel)getJdbcTemplate().queryForObject(LoginQuery.SQL_LOGIN,inputs,new ODParkRegistrationMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("login  query time:: " +result);
			/*if(loginModel!=null){
				cisResults.setResultObject(loginModel);
			}*/
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants. USER_LOGIN_STATUS);
		}

   		return cisResults;  
	}

	public CISResults getPassword(String phoneNumber) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		ODParkRegistrationModel loginModel;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{phoneNumber};
		try{	
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 loginModel=(ODParkRegistrationModel)getJdbcTemplate().queryForObject(LoginQuery.SQL_GETPASSWORD,inputs,new GetPasswordMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("login  query time:: " +result);
			if(loginModel!=null){
				cisResults.setResultObject(loginModel);
			}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants. USER_LOGIN_STATUS);
		}

   		return cisResults;  
	}


	/*public CISResults sessionEntry(String userId, String sessionId,String sessionTime,String deleteInd) {
		Logger logger = Logger.getLogger(LoginDAO.class);
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(SessionsQuery.SQL_CREATE_SESSION,userId,sessionId,sessionTime,deleteInd);
			String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("create session  query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}*/
	
	
	

	
}