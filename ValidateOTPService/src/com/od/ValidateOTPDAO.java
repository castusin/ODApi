package com.od;


import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
/**
 * Validates OTP 
 * @author Castus Info Solutions
 *
 */

public class ValidateOTPDAO extends JdbcDaoSupport {
	
	/**
	 * @param phoneNumber
	 * @param emailId
	 * @param otp
	 * @param deleteInd
	 * @return
	 */
	public CISResults validateOTP(String phoneNumber,String otp,String deleteInd) {
		ValidateOTP verifyModel;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{phoneNumber,otp,deleteInd};
		Logger logger = Logger.getLogger(ValidateOTPDAO.class);
		try{	
			TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			verifyModel=(ValidateOTP)getJdbcTemplate().queryForObject(ValidateOTPQuery.SQL_VALIDATE_OPT,inputs,new ValidateOTPMapper());
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