
package com.od;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODGetParkDetailsDAO extends JdbcDaoSupport {

	/**
	 * @param parkId
	 * @param count 
	 * @param checkOut 
	 * @param checkIn 
	 * @return 1 in case of error or 0 if successful
	 */
	public List<ODParkDetailsService> getParksDetails(String checkIn, String checkOut, String parkId, int count) {
		
		ODGetParkDetailsModel parksDetails;
		List<ODParkDetailsService> parkDetailslist = null;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{checkIn,checkOut,parkId,count,parkId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			parkDetailslist = getJdbcTemplate().query(ODGetParkDetailsQuery.SQL_GETPARKSDETAILSLIST,inputs,new ODParkDetailsServiceMapper());
			// Capture Service End time
		    String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Query time for get park details service:: " +result );
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return parkDetailslist;  
	}

	public CISResults getParksDetail( String parkId) {
		
		ODGetParkDetailsModel parksDetails;
		ODParkDetailsService parkDetailslist = new ODParkDetailsService();
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{parkId};
		
		try{
			// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			List res = getJdbcTemplate().query(ODGetParkDetailsQuery.SQL_GETPARKSDETAILS,inputs,new ODGetParkDetailsMapper());
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



