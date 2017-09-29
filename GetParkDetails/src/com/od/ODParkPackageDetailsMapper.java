
package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODParkPackageDetailsMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		ODParkPackageDetailsService parkDetails = new ODParkPackageDetailsService();
		
		parkDetails.setPackageDiscountValue(rs.getInt("Discount"));
		parkDetails.setPackageDiscountType(rs.getString("Discount_Mode"));
		parkDetails.setPackagePrice(rs.getFloat("min_curr_price"));
		//parkDetails.setPackageName(rs.getString("Discount_Mode"));
		
	
		return parkDetails;
	}
	

}
