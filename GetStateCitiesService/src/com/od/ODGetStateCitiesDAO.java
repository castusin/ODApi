
package com.od;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODGetStateCitiesDAO extends JdbcDaoSupport {


	public CISResults viewStateCities(String stateId) {
		Logger logger = Logger.getLogger(ODGetCitiesDAO.class);
		ODGetStateCitiesModel viewCities=new ODGetStateCitiesModel();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{stateId};
		try{
			TimeCheck time=new TimeCheck();
			testServiceTime sessionTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List result=getJdbcTemplate().query(ODGetStateCitiesQuery.SQL_VIEWSTATECITIES,inputs,new ODGetStateCitiesMapper());
			String serviceEndTime=time.getTimeZone();
			long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("view state cities query time:: " +results);
			cisResults.setResultObject(result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}


}