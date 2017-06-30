package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class PackageMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PackageDetails packagedetails = new PackageDetails();
		
		
		
		
		packagedetails.setFacilityTypeCode(rs.getString("facility_type_code"));
		packagedetails.setRoomTypeCode(rs.getString("Room_type_code"));
		
		packagedetails.setFacilityQuantity(rs.getInt("Facility_quantity"));
		packagedetails.setRoomQuantity(rs.getInt("Room_quantity"));
		
		packagedetails.setFacilityTitle(rs.getString("Facility_title"));
		packagedetails.setRoomTitle(rs.getString("Room_title"));
		

		packagedetails.setRoomPrice(rs.getFloat("Room_price"));
		packagedetails.setFacilityPrice(rs.getFloat("Facility_price"));
		

		//packagedetails.setFacilityQuantity(rs.getInt("Max_qty"));
		
		
		return packagedetails;
	}
}