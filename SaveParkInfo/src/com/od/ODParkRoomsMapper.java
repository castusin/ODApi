package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODParkRoomsMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODParkRoomsModel roomModel = new ODParkRoomsModel();
		
		roomModel.setRoomTypeCode(rs.getString("Room_type_code"));
		roomModel.setRommTypeDescription(rs.getString("Room_type_desc"));
		roomModel.setMaxPeople(rs.getString("Max_people"));
		roomModel.setMaxAdults(rs.getString("Max_adults"));
		roomModel.setMaxKids(rs.getString("Max_kids"));
		roomModel.setMaxQty(rs.getString("Max_qty"));	
		roomModel.setRegularPrice(rs.getString("Regular_price"));
		roomModel.setDateAdded(rs.getDate("Date_added"));
		
		
		return roomModel;
	}

	

}
