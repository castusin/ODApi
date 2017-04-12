package com.od;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODGetParkInfoDAO extends JdbcDaoSupport {


	public CISResults getParksinfo(String metro, String localArea, String parkType) {
		
		ODGetParkInfoModel parksInfo=new ODGetParkInfoModel();
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{metro,localArea,parkType};
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

}



