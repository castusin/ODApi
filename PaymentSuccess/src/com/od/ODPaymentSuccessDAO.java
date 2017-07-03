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
	public CISResults paymentSuccess(String transactionId, String status) {
		
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

	public CISResults paymentEmail(String transactionId) {
		
		
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

	public List<GetRoomDetailsModel> getRoomDetails(String transactionId) {
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//GetRoomDetailsModel roomDetails=new GetRoomDetailsModel();
		List<GetRoomDetailsModel> roomDetails=null;
		Object[] inputs = new Object[]{transactionId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			roomDetails = getJdbcTemplate().query(ODPaymentSuccessQuery.SQL_GETROOMDETAILS,inputs,new GetRoomDetailsMapper());
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get park details service:: " +result );
			//cisResults.setResultObject(res);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return roomDetails;  
	}

	public CISResults getAvailablility(String transactionId) {
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{transactionId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List res = getJdbcTemplate().query(ODPaymentSuccessQuery.SQL_GETAVAILABILITY,inputs,new GetAvailabilityMapper());
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

	public CISResults getUpdateAvailablility(String transactionId) {
		
		CISResults cisResults=new CISResults();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		Object[] inputs = new Object[]{transactionId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(ODPaymentSuccessQuery.SQL_UPDATEAVAILABILITY,inputs);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("edit scheludle plan query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}

	public List<SupplierModel> SupplierEmail(int transactionId) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		List<SupplierModel> supplierDetails=null;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{transactionId};
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			supplierDetails  = getJdbcTemplate().query(ODPaymentSuccessQuery.SQL_GETSUPPLIERMAIL,inputs,new SupplierMapper());
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get park details service:: " +result );
			//cisResults.setResultObject(res);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return supplierDetails;  
	}

	public CISResults getParkAddress(int parkid) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{parkid};
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			ParkAddress res = (ParkAddress)getJdbcTemplate().queryForObject(ODPaymentSuccessQuery.SQL_GETPARKADDRESS,inputs,new ParkAddressMapper());
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
	
