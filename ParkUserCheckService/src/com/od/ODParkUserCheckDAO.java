package com.od;


import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;



public class ODParkUserCheckDAO extends JdbcDaoSupport{
	
	public CISResults parkUserCheck(String emailId) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		ODParkRegistrationModel checkEmail;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		  Object[] inputs = new Object[]{emailId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 checkEmail = (ODParkRegistrationModel)getJdbcTemplate().queryForObject(ODParkUserCheckQuery.SQL_CHECKEMAILID,inputs,new ODParkUserCheckMapper());
			 
			 checkEmail.setUsername(emailId);
			 checkEmail.setUserId(checkEmail.getUserId());
			 checkEmail.setPhoneNumber(checkEmail.getPhoneNumber());
			 checkEmail.setFirstName(checkEmail.getFirstName());
			 checkEmail.setLastName(checkEmail.getLastName());
			 checkEmail.setUserType(checkEmail.getUserType());
			 checkEmail.setUserGender(checkEmail.getUserGender());
			 checkEmail.setUserRole(checkEmail.getUserRole());
			 checkEmail.setGoogleFbId(checkEmail.getGoogleFbId());
			 checkEmail.setProfilePicUrl(checkEmail.getProfilePicUrl());
			 checkEmail.setCreatedBy(checkEmail.getCreatedBy());
			 checkEmail.setCreationDate(checkEmail.getCreationDate());
			 checkEmail.setUpdatedBy(checkEmail.getUpdatedBy());
			 checkEmail.setUpdationDate(checkEmail.getUpdationDate());
			 checkEmail.setPasswordLastChangedOn(checkEmail.getPasswordLastChangedOn());
			 checkEmail.setLastLoginDatetime(checkEmail.getLastLoginDatetime());
			 
			 String serviceEndTime=time.getTimeZone();
			 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 cisResults.setResultObject(checkEmail);
			 
			 logger.info("park user check query time:: " +cisResults);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
		
			cisResults.setErrorMessage("Failed to get data");
		}

   		return cisResults; 
		
	}
	
	
	
	
	
}
