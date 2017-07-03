
package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODGetCouponCodeMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODGetCouponCodeModel couponcode = new ODGetCouponCodeModel();
	
		couponcode.setParkKey(rs.getString("Park_key"));
		couponcode.setCouponType(rs.getString("Coupon_type"));
		couponcode.setCouponCode(rs.getString("Coupon_code"));
		couponcode.setDiscount(rs.getInt("Discount"));
		couponcode.setFromDate(rs.getDate("From_date"));
		couponcode.setToDate(rs.getDate("To_date"));
		couponcode.setDescription(rs.getString("Description"));
		couponcode.setCreatedOn(rs.getDate("CreatedOn"));
		couponcode.setCreatedBy(rs.getInt("CreatedBy"));
		couponcode.setModifiedOn(rs.getDate("ModifiedOn"));
		couponcode.setModifiedBy(rs.getInt("ModifiedBy"));
		couponcode.setStatus(rs.getString("Status"));
		
		return couponcode;
	}

}
