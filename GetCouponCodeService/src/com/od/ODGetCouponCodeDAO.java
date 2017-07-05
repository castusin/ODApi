
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


public class ODGetCouponCodeDAO extends JdbcDaoSupport {


	public CISResults getCouponcode(String parkId, String checkIn, String couponCode) throws Exception {
		Logger logger = Logger.getLogger(ODGetCitiesDAO.class);
		ODGetCouponCodeModel coupon=new ODGetCouponCodeModel();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		
		Object[] inputs = new Object[]{parkId,couponCode};
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			TimeCheck time=new TimeCheck();
			testServiceTime sessionTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			ODGetCouponCodeModel result=(ODGetCouponCodeModel)getJdbcTemplate().queryForObject(ODGetCouponCodeQuery.SQL_GETCOUPONCODE,inputs,new ODGetCouponCodeMapper());
			String serviceEndTime=time.getTimeZone();
			long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("coupon code query time:: " +results);
			cisResults.setResultObject(result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Coupon code not valid");
		}

   		return cisResults;  
	}


}