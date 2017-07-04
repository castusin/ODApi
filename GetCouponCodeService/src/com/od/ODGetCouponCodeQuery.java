package com.od;

public class ODGetCouponCodeQuery {
	
	public static String SQL_GETCOUPONCODE = " select Park_key,Coupon_type,Coupon_code,Discount,From_date,To_date,Description,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy,Status from park_coupon where Park_key=? and Coupon_code=? and Status='A' "; 
	

}
