
package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class GetRoomDetailsMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GetRoomDetailsModel paymentStatus = new GetRoomDetailsModel();
		paymentStatus.setTypeCode(rs.getString("type_code"));
	    paymentStatus.setFromDate(rs.getDate("from_date"));
	    paymentStatus.setToDate(rs.getDate("to_date"));
	    paymentStatus.setTotalPrice(rs.getFloat("total_price"));
	    paymentStatus.setCreationDate(rs.getDate("Creation_date"));
	    paymentStatus.setParkId(rs.getInt("park_id"));
	    paymentStatus.setQuantity(rs.getInt("Quantity"));
	    paymentStatus.setTitle(rs.getString("Title"));
	    paymentStatus.setPrice(rs.getFloat("Price"));
	    paymentStatus.setType(rs.getString("Type"));
		
		
		return paymentStatus;
	}
}

//Facility_title,Facility_price,facility_type_code,Facility_quantity,Room_title,Room_price,Room_type_code,Room_quantity