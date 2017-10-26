package com.od;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODGetParkInfoDAO extends JdbcDaoSupport {


	/**
	 * @param metro
	 * @param localArea
	 * @param parkType
	 * @param checkIn 
	 * @param reservationDate 
	 * @param adults 
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults getParkinfo(int localId,String parkType,String adults, String checkIn, String checkOut, String reservationDate) throws Throwable {
		
		ODGetParkInfoModel parksInfo=new ODGetParkInfoModel();
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		int cityId=10000025;
		Object[] inputs = new Object[]{reservationDate,reservationDate,localId,parkType};
		try{
			// Capture service Start time
			
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List result=getJdbcTemplate().query(ODGetParkInfoQuery.SQL_GETPARKSINFO,inputs,new GetAllParksInfoMapper());
						
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long results=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get park info service:: " +results );
			
			cisResults.setResultObject(result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}

	public CISResults getDates(String checkdates) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{checkdates};
		try{
			// Capture service Start time
			
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List result=getJdbcTemplate().query(ODGetParkInfoQuery.SQL_GETDATES,inputs,new GetDatesMapper());
						
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long results=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get park info service:: " +results );
			
			cisResults.setResultObject(result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}

	public CISResults getParkRoominfo(int localId, String parkType,
			String adults, String checkIn, String checkOut,
			String reservationDate) {


		ODGetParkInfoModel parksInfo=new ODGetParkInfoModel();
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{checkIn,checkOut,checkIn,checkOut,checkOut,checkIn,localId,parkType};
		try{
			// Capture service Start time
			
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List result=getJdbcTemplate().query(ODGetParkInfoQuery.SQL_GETPARKSROOMSINFO,inputs,new ODGetParkRoomsMapper());
						
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long results=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get park info service:: " +results );
			
			cisResults.setResultObject(result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}

	public CISResults getAllParkinfo(int localId,String reservationDate) {


		ODGetParkInfoModel parksInfo=new ODGetParkInfoModel();
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{reservationDate,reservationDate,localId};
		try{
			// Capture service Start time
			
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List result=getJdbcTemplate().query(ODGetParkInfoQuery.SQL_GETALLPARKSINFO,inputs,new GetAllParksInfoMapper());
						
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long results=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get park info service:: " +results );
			
			cisResults.setResultObject(result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}


	

} 
	
