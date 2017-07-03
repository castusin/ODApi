
package com.od;


import java.util.Date;

import org.apache.log4j.Logger;

import com.cis.CISResults;

public class ODGetCouponCodeWebservice {
	
	static Logger logger = Logger.getLogger(ODGetCouponCodeWebservice.class);
	ODGetCouponCodeBL couponCodeBL=new ODGetCouponCodeBL();

	public CISResults getCouponcode(String parkId, String checkIn, String couponCode) throws Exception {
		 CISResults cisResult = couponCodeBL.getCouponcode(parkId,checkIn,couponCode);
		 logger.info("OD coupon code WebService  " +cisResult );
		 return cisResult;
	}

}
