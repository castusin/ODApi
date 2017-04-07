package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODParkDetailsServiceMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ODParkDetailsService parkDetails = new ODParkDetailsService();
		
		parkDetails.setRoomType(rs.getString("Room_type_code"));
		parkDetails.setDescription(rs.getString("Room_type_desc"));
		parkDetails.setMaxPeople(rs.getString("Max_qty"));
		parkDetails.setMaxAdults(rs.getString("Max_adults"));
		parkDetails.setMaxKids(rs.getString("Max_kids"));
		parkDetails.setCurrentAvailableQuantity(rs.getString("Current_available_qty"));
		parkDetails.setCurrentPrice(rs.getString("Regular_price"));
		
		return parkDetails;
	}
}