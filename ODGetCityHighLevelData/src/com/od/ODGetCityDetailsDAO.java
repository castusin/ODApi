/**
 * 
 */
package com.od;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

/**
 * @author Darshan
 *
 */
public class ODGetCityDetailsDAO extends JdbcDaoSupport  {

	public CISResults getCityinfo(String cityId) {
		// TODO Auto-generated method stub
		List<ODGetCityDetailsModel> ciryDetailslist = null;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{cityId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			ciryDetailslist = getJdbcTemplate().query(ODGetCityDetailsQuery.SQL_GETCITYDETAILS,inputs,new ODGetCityDetailsMapper());
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get park details service:: " +result );
			cisResults.setResultObject(ciryDetailslist);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return cisResults;  
	}
}
