package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODAddonsMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ODParkDetailsService parkDetails = new ODParkDetailsService();
		
		
		parkDetails.setFacilityTypeTitle(rs.getString("Facility_type_title"));
		parkDetails.setCurrentPrice(rs.getFloat("Current_price"));
		
		parkDetails.setFacilityImage(rs.getString("Facility_image"));
		parkDetails.setParkMainImages(rs.getString("Facility_main_image"));
		parkDetails.setDiscount(rs.getInt("Discount"));
		parkDetails.setFacilityType(rs.getString("Facility_type"));
		parkDetails.setDiscountMode(rs.getString("Discount_Mode"));
		parkDetails.setAddonId(rs.getInt("Pack_Addon_Id"));
		
		parkDetails.setFacilityTypeCode(rs.getString("Facility_type_code"));
		parkDetails.setParkRoomFac(rs.getString("Park_Room_Fac"));
		
		
		//parkDetails.setAddonPath(rs.getString("Addon_path"));
		//parkDetails.setAddonName(rs.getString("Pack_Addon_Name"));
		
		return parkDetails;
	}
}