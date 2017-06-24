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
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults getParkinfo(String parkType,String localArea, String checkIn, String checkOut, long count) {
		
		ODGetParkInfoModel parksInfo=new ODGetParkInfoModel();
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{checkIn,checkOut,count,localArea};
		//List<ODGetParkInfoModel> result = new ArrayList<ODGetParkInfoModel>();;
		try{
			// Capture service Start time
			
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List result=getJdbcTemplate().query(ODGetParkInfoQuery.SQL_GETPARKSINFO,inputs,new ODGetParkInfoMapper());
						
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
		//List<GetDatesModel> result = new ArrayList<GetDatesModel>();;
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
	
	
	
/*public List<GetDatesModel> getParkinfo(String parkType,String metro,String localArea, String checkIn, String checkOut, long count) {
		
		ODGetParkInfoModel parksInfo=new ODGetParkInfoModel();
		 List<GetDatesModel> dateList=null;
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{localArea,checkIn,checkOut};
		List<ODGetParkInfoModel> result = new ArrayList<ODGetParkInfoModel>();
		try{
			// Capture service Start time
			
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			dateList=getJdbcTemplate().query(ODGetParkInfoQuery.SQL_GETPARKSINFO,inputs,new ODGetParkInfoMapper());
						
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long results=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get park info service:: " +results );
			
			//cisResults.setResultObject(result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return dateList;  
	}*/
	
	

} 
	
