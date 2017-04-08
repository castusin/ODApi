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
		

		
		/*parkDetailslist.setRoomType(rs.getString("Room_type_code"));
		parkDetailslist.setDescription(rs.getString("Room_type_desc"));
		parkDetailslist.setMaxPeople(rs.getString("Max_qty"));
		parkDetailslist.setMaxAdults(rs.getString("Max_adults"));
		parkDetailslist.setMaxKids(rs.getString("Max_kids"));
		parkDetailslist.setCurrentAvailableQuantity(rs.getString("Current_available_qty"));
		parkDetailslist.setCurrentPrice(rs.getString("Regular_price"));*/
		
		return parkDetails;
	}
}