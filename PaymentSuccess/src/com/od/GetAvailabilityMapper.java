package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class GetAvailabilityMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GetAvailabilityModel avail = new GetAvailabilityModel();
		avail.setParkId(rs.getInt("park_id"));
		avail.setParkId(rs.getInt("Park_id"));
		avail.setAvailability(rs.getInt("Current_available_qty"));
	   avail.setFacilityCode(rs.getString("Facility_type_code"));
		return avail;
	}
}