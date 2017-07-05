
package com.od;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODGetCouponCodeBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetCouponCodeDAO couponCodeDAO=(ODGetCouponCodeDAO)ctx.getBean("CouponsCode");

	@SuppressWarnings("unused")
	public CISResults getCouponcode(String parkId, String checkIn, String couponCode) throws Exception {
		
		// Capture service Start time
		CISResults cisResult=new CISResults();
		TimeCheck time=new TimeCheck();
		testServiceTime seriveTimeCheck=new testServiceTime();
		String serviceStartTime=time.getTimeZone();
		  
		final Logger logger = Logger.getLogger(ODGetCouponCodeBL.class);
		 
		 cisResult = couponCodeDAO.getCouponcode(parkId,checkIn,couponCode);
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
         {
			 ODGetCouponCodeModel  coupon=(ODGetCouponCodeModel)cisResult.getResultObject();
			 Date fromDate=coupon.getFromDate();
			 Date toDate=coupon.getToDate();
			 //Date date = checkIn;
			 SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			 Date date = myFormat.parse(checkIn);
			 //if (date != null && fromDate != null && toDate != null) {
			 if (date.after(fromDate) && date.before(toDate)) {
	        	cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	        	
			 }
			 else {
	        	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	        	coupon.setDiscount(0);
	        	coupon.setFromDate(null);
	        	coupon.setToDate(null);
	        	coupon.setParkKey(null);
	        	coupon.setCouponCode(null);
	        	coupon.setCouponType(null);
	        	coupon.setDescription(null);
	        	coupon.setCreatedBy(0);
	        	coupon.setCreatedOn(null);
	        	coupon.setModifiedBy(0);
	        	coupon.setStatus(null);
				cisResult.setErrorMessage("coupen code not matching ");
	        }
	   // }
         }else{
        	 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
         }
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		logger.info("Database time for coupons code service:: " +result );
		  
		return cisResult;
	}


}