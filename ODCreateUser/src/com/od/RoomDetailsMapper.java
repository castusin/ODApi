
package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class RoomDetailsMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RoomsDetails roomDetails = new RoomsDetails();
		
		
		roomDetails.setPrice(rs.getFloat("Regular_price"));
		
		roomDetails.setRoomType(rs.getString("Room_type_code"));
		
		roomDetails.setQuantity(rs.getInt("Max_qty"));
		
		roomDetails.setOriginalamount(rs.getFloat("Original_amount"));
		
		roomDetails.setDiscountamount(rs.getFloat("Discount_amount"));
		
		
		roomDetails.setCollectamount(rs.getFloat("Collect_amount"));

		
		return roomDetails;
	}
}