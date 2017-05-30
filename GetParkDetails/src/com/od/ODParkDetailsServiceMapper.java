package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODParkDetailsServiceMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ODParkDetailsService parkDetails = new ODParkDetailsService();
		
		parkDetails.setFacilityType(rs.getString("Facility_type"));
		parkDetails.setDescription(rs.getString("Room_type_desc"));
		parkDetails.setMaxPeople(rs.getString("Max_people"));
		parkDetails.setMaxAdults(rs.getString("Max_adults"));
		parkDetails.setMaxKids(rs.getString("Max_kids"));
		parkDetails.setMaxQty(rs.getString("Max_qty"));
		parkDetails.setRegularPrice(rs.getString("Regular_price"));
		parkDetails.setDateAdded(rs.getDate("Date_added"));
		parkDetails.setDate(rs.getDate("Date"));
		parkDetails.setCurrentPrice(rs.getFloat("Current_price"));
		parkDetails.setCurrentAvailableQuantity(rs.getString("Current_available_qty"));
		parkDetails.setFacilityTypeCode(rs.getString("Facility_type_code"));
		parkDetails.setFacilityImage(rs.getString("Facility_image"));
		parkDetails.setFacilityInRoomFacilites(rs.getString("Facility_in_Room_facilities"));
		parkDetails.setFacilityTypeTitle(rs.getString("Facility_type_title"));
		parkDetails.setFacilityTypeCode(rs.getString("Facility_type_code"));
		
		return parkDetails;
	}
}