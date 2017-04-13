package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODGetParkDetailsMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ODGetParkDetailsModel parkDetails = new ODGetParkDetailsModel();
		ODParkDetailsService parkDetailslist = new ODParkDetailsService();
		parkDetails.setOverviewText(rs.getString("Overview_text"));
		parkDetails.setFaq(rs.getString("Faq"));
		parkDetails.setPhotoUrl(rs.getString("Main_photo_url"));
		parkDetails.setName(rs.getString("Name"));
		parkDetails.setOdRating(rs.getInt("OD_Rating"));
		parkDetails.setMetro(rs.getString("Metro"));
		parkDetails.setLocalArea(rs.getString("Local_area"));
		parkDetails.setStreetAddress(rs.getString("Street_address"));
		parkDetails.setCity(rs.getString("City"));
		parkDetails.setState(rs.getString("State"));
		parkDetails.setPin(rs.getInt("PIN"));
		
	
		return parkDetails;
	}
}