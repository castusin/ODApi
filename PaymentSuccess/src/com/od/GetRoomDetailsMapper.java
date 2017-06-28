
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
	    paymentStatus.setQuantity(rs.getInt("qty"));
	    paymentStatus.setTotalPrice(rs.getFloat("total_price"));
	    paymentStatus.setCreationDate(rs.getDate("Creation_date"));
	    paymentStatus.setParkId(rs.getInt("park_id"));
		return paymentStatus;
	}
}