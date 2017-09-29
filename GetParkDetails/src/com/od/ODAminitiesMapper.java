package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODAminitiesMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		ODAminitiesService parkDetails = new ODAminitiesService();
		
		parkDetails.setAminitiesId(rs.getInt("Amenities_Id"));
		parkDetails.setAminitiesName(rs.getString("Amenities_Name"));
		parkDetails.setAminitiesPath(rs.getString("Amenities_Path"));
		//parkDetails.setPackageName(rs.getString("Discount_Mode"));
		
	
		return parkDetails;
	}
	

}
