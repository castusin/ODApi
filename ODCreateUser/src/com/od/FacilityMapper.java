package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class FacilityMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		FacilityDetails facilityDetails = new FacilityDetails();
		
		
		facilityDetails.setPrice(rs.getFloat("Regular_price"));
		
		facilityDetails.setFacilityType(rs.getString("Facility_type_code"));
		
		facilityDetails.setQuantity(rs.getInt("Max_qty"));
		
		return facilityDetails;
	}
}