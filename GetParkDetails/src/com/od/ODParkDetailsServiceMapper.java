package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODParkDetailsServiceMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ODParkDetailsService parkDetails = new ODParkDetailsService();
		
		
		parkDetails.setFacilityTypeTitle(rs.getString("Facility_type_title"));
		parkDetails.setFacilityTypeCode(rs.getString("Facility_type_code"));
		parkDetails.setCurrentPrice(rs.getFloat("Current_price"));
		parkDetails.setDescription(rs.getString("Room_type_desc"));
		parkDetails.setFacilityImage(rs.getString("Facility_image"));
		parkDetails.setFacilityType(rs.getString("Facility_type"));
		parkDetails.setParkMainImages(rs.getString("Facility_main_image"));
		parkDetails.setDiscount(rs.getInt("Discount"));
		parkDetails.setDiscountMode(rs.getString("Discount_Mode"));
		parkDetails.setAmenitiesString(rs.getString("Package_Items"));
		parkDetails.setParkRoomFac(rs.getString("Park_Room_Fac"));
		parkDetails.setInclusions(rs.getString("Inclusions"));
		//parkDetails.setStatus(rs.getString("Is_active"));
		return parkDetails;
	}
}