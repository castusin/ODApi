package com.od;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class ODParkRegistrationDAO extends JdbcDaoSupport {

	public CISResults parkRegestration(String userId, String firstName,
			String lastName, String userName, String password,
			String phoneNumber, String userType, String googleFbId,
			String profilePicUrl, String userGender, String userRole,
			String createDate, String createdBy, String updationDate,
			String updatedBy, String passwordLastChangedOn, String lastLoginDatetime) {
		
		CISResults cisResults=new CISResults();
		ODParkRegistrationModel register=new ODParkRegistrationModel();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(ODParkRegistrationQuery.SQL_PARKREGISTRATIONTABLE,userId,firstName,lastName,userName,password,phoneNumber,userType,googleFbId,profilePicUrl,userGender,userRole,createDate,createdBy,updationDate,updatedBy,passwordLastChangedOn,lastLoginDatetime);
			 register.setUserId(userId);
			 register.setUsername(userName);
			 register.setPhoneNumber(phoneNumber);
			 register.setFirstName(firstName);
			 register.setLastName(lastName);
			 register.setUserType(userType);
			 register.setUserGender(userGender);
			 register.setUserRole(userRole);
			 register.setGoogleFbId(googleFbId);
			 register.setProfilePicUrl(profilePicUrl);
			 register.setCreatedBy(createdBy);
			 register.setCreationDate(createDate);
			 register.setUpdatedBy(updatedBy);
			 register.setUpdationDate(updationDate);
			 register.setPasswordLastChangedOn(passwordLastChangedOn);
			 register.setLastLoginDatetime(lastLoginDatetime);
			 
			 
			 
			 String serviceEndTime=time.getTimeZone();
			 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 cisResults.setResultObject(register);
			 logger.info("park registration query time:: " +cisResults);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
		
			cisResults.setErrorMessage("Failed to get data");
		}

   		return cisResults; 
		
	}

	public CISResults checkEmail(String emailId, String phoneNumber) {

		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		  Object[] inputs = new Object[]{emailId,phoneNumber};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 ODCheckMail res = (ODCheckMail)getJdbcTemplate().queryForObject(ODParkRegistrationQuery.SQL_CHECKEMAILID,inputs,new ODCheckMailMapper());
			 String serviceEndTime=time.getTimeZone();
			 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 
			 logger.info("park registration query time:: " +cisResults);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
		
			cisResults.setErrorMessage("Failed to get data");
		}

   		return cisResults; 
		
	}
}
