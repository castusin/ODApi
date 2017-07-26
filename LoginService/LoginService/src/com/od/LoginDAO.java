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
	
	
	public CISResults login(String username,String password) {
		
		Logger logger = Logger.getLogger(LoginDAO.class);
		
		CISResults cisResults=new CISResults();
		ODParkRegistrationModel loginModel;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{username,username,password};
		try{	
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 loginModel=(ODParkRegistrationModel)getJdbcTemplate().queryForObject(LoginQuery.SQL_LOGIN,inputs,new ODParkRegistrationMapper());
			 loginModel.setUsername(loginModel.getUsername());
			 loginModel.setPhoneNumber(loginModel.getPhoneNumber());
			 loginModel.setFirstName(loginModel.getFirstName());
			 loginModel.setLastName(loginModel.getLastName());
			 loginModel.setUserType(loginModel.getUserType());
			 loginModel.setUserGender(loginModel.getUserGender());
			 loginModel.setUserRole(loginModel.getUserRole());
			 loginModel.setGoogleFbId(loginModel.getGoogleFbId());
			 loginModel.setProfilePicUrl(loginModel.getProfilePicUrl());
			 loginModel.setCreatedBy(loginModel.getCreatedBy());
			 loginModel.setCreationDate(loginModel.getCreationDate());
			 loginModel.setUpdatedBy(loginModel.getUpdatedBy());
			 loginModel.setUpdationDate(loginModel.getUpdationDate());
			 loginModel.setPasswordLastChangedOn(loginModel.getPasswordLastChangedOn());
			 loginModel.setLastLoginDatetime(loginModel.getLastLoginDatetime());
			 
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("login  query time:: " +result);
			
			cisResults.setResultObject(loginModel);
			
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants. USER_LOGIN_STATUS);
		}

   		return cisResults;  
	}

	public CISResults getPassword(String username) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		ODParkRegistrationModel loginModel;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{username,username};
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

	public CISResults Updatelogin(String createDate,String username) {

		CISResults cisResults=new CISResults();
		ODParkRegistrationModel loginModel;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{createDate,username,username};
		try{	
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(LoginQuery.SQL_UPDATELOGIN,inputs);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("login  query time:: " +result);
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants. USER_LOGIN_STATUS);
		}

   		return cisResults;  
	}


}