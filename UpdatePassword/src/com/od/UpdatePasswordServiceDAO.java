package com.od;


import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class UpdatePasswordServiceDAO extends JdbcDaoSupport {

	public CISResults updatePassword(String emailId,String password) {
		
		CISResults cisResult=new CISResults();
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{emailId,password};
		Logger logger = Logger.getLogger(UpdatePasswordServiceDAO.class);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(UpdatePasswordServiceQuery.SQL_UPDATEPASSWORD,inputs);		
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("update password query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResult.setErrorMessage("Failed to login to the system");
		}

   		return cisResult;  
	}

	public CISResults validateOTP(String emailId, String otp) {


		ValidateOTP verifyModel;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{emailId,otp};
		Logger logger = Logger.getLogger(ValidateOTPDAO.class);
		try{	
			TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			verifyModel=(ValidateOTP)getJdbcTemplate().queryForObject(UpdatePasswordServiceQuery.SQL_VALIDATE_OPT,inputs,new UpdatePasswordServiceMapper());
			String serviceEndTime=time.getTimeZone();
			long result=sessionTimeCheck.getServiceTime(serviceStartTime,serviceEndTime);
			 logger.info("validate otp query time:: " +result);
			if(verifyModel!=null){		
				cisResults.setResultObject(verifyModel);
			}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS4);
		}
   		return cisResults;  
	
	}

	


}