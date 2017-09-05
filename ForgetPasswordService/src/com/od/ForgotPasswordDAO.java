package com.od;




import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ForgotPasswordDAO extends JdbcDaoSupport {

	public CISResults forgotPassword(String userName,int otpNumber, String otpdateTime, String deleteInd,String emailId) {
		//SaveProfile forgotPassword;
		CISResults cisResult=new CISResults();
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(ForgotPasswordDAO.class);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(ForgotPasswordQuery.SQL_FORGOT_OTP,userName,otpNumber,otpdateTime,deleteInd,emailId);		
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Forget password query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResult.setErrorMessage("Failed to login to the system");
		}

   		return cisResult;  
	}

	public CISResults checkNumber(String userName) {

		CISResults cisResults=new CISResults();
			
			cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			  Object[] inputs = new Object[]{userName,userName};
			try{
				// Capture service Start time
				 TimeCheck time=new TimeCheck();
				 testServiceTime sessionTimeCheck=new testServiceTime();
				 String serviceStartTime=time.getTimeZone();
				 ODCheckMail res = (ODCheckMail)getJdbcTemplate().queryForObject(ForgotPasswordQuery.SQL_CHECKEMAILID,inputs,new ForgotPasswordMapper());
				 
				 cisResults.setResultObject(res);
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

	/*public CISResults validateOTPTime(String contact, String emailId,
			String deleteInd) {
		Logger logger = Logger.getLogger(DigihealthCareForgotPasswordDAO.class);
				CISResults cisResults=new CISResults();
				DigihealthCareValidateOTP verifyModel;
				cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
				Object[] inputs = new Object[]{contact,emailId,deleteInd};
				try{	
					// Capture service Start time
					 TimeCheck time=new TimeCheck();
					 testServiceTime sessionTimeCheck=new testServiceTime();
					 String serviceStartTime=time.getTimeZone();
					verifyModel=(DigihealthCareValidateOTP)getJdbcTemplate().queryForObject(DigihealthCareValidateOTPQuery.SQL_GET_OTP,inputs,new DigihealthCareGetOTPMapper());
					 String serviceEndTime=time.getTimeZone();
					 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
					 logger.info("Get otp query time:: " +result);
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

	*/


}