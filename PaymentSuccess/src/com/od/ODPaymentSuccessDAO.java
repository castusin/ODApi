package com.od;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODPaymentSuccessDAO extends JdbcDaoSupport {


	/**
	 * @param transactionId
	 * @param status 
	
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults paymentSuccess(int transactionId, String status) {
		
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	    Object[] inputs = new Object[]{status,transactionId};
		
		try{
			// Capture service Start time
			
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
		
			 getJdbcTemplate().update(ODPaymentSuccessQuery.SQL_GETPAYMENTSTATUS,inputs);
			 //cisResults.setResultObject(status);
					
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long results=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for payment status service:: " +results );
			
			//cisResults.setResultObject(result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}

	public CISResults paymentEmail(int transactionId) {
		
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{transactionId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			ODPaymentSuccessModel res = (ODPaymentSuccessModel)getJdbcTemplate().queryForObject(ODPaymentSuccessQuery.SQL_GETUSEREMAILID,inputs,new ODPaymentSuccessMapper());
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for payment email service:: " +result );
			cisResults.setResultObject(res);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return cisResults;  
	}

} 
	
