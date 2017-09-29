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


public class ODGetCategoriesDAO extends JdbcDaoSupport {


	public CISResults getCategories(int cityId,String parkType, String adults, String checkIn, String checkOut, String reservationDate){
		Logger logger = Logger.getLogger(ODGetCategoriesDAO.class);
		
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{reservationDate,reservationDate,cityId,parkType};
		try{
			TimeCheck time=new TimeCheck();
			testServiceTime sessionTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List result=getJdbcTemplate().query(ODGetCategoriesQuery.SQL_GETCATEGORIES,inputs,new ODGetCategoriesMapper());
			String serviceEndTime=time.getTimeZone();
			long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("view cities query time:: " +results);
			cisResults.setResultObject(result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get data");
		}

   		return cisResults;  
	}


}