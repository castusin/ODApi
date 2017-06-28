package com.od;

import com.cis.CISResults;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODGetCitiesDAO extends JdbcDaoSupport {


	public CISResults viewCities(int cityKey, String cityName) {
		Logger logger = Logger.getLogger(ODGetCitiesDAO.class);
		ODGetCitiesModel viewCities=new ODGetCitiesModel();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		
		//Object[] inputs = new Object[]{cityKey};
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			TimeCheck time=new TimeCheck();
			testServiceTime sessionTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List result=getJdbcTemplate().query(ODGetCitiesQuery.SQL_VIEWCITIES,new ODGetCitiesMapper());
			String serviceEndTime=time.getTimeZone();
			long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("view cities query time:: " +results);
			cisResults.setResultObject(result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}


}