
package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class GetRoomDetailsMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GetRoomDetailsModel paymentStatus = new GetRoomDetailsModel();
		paymentStatus.setFacilityType(rs.getString("facility_type_code"));
	    paymentStatus.setFromDate(rs.getDate("from_date"));
	    paymentStatus.setToDate(rs.getDate("to_date"));
	   // paymentStatus.setQuantity(rs.getInt("qty"));
	    paymentStatus.setTotalPrice(rs.getFloat("total_price"));
	    paymentStatus.setCreationDate(rs.getDate("Creation_date"));
	    paymentStatus.setParkId(rs.getInt("park_id"));
	    
	    //paymentStatus.setFacilityTypeCode(rs.getString("facility_type_code"));
	    paymentStatus.setRoomTypeCode(rs.getString("Room_type_code"));
		
	    paymentStatus.setFacilityQuantity(rs.getInt("Facility_quantity"));
	    paymentStatus.setRoomQuantity(rs.getInt("Room_quantity"));
		
	    paymentStatus.setFacilityTitle(rs.getString("Facility_title"));
	    paymentStatus.setRoomTitle(rs.getString("Room_title"));
		

	    paymentStatus.setRoomPrice(rs.getFloat("Room_price"));
	    paymentStatus.setFacilityPrice(rs.getFloat("Facility_price"));
		
		
		return paymentStatus;
	}
}

//Facility_title,Facility_price,facility_type_code,Facility_quantity,Room_title,Room_price,Room_type_code,Room_quantity