package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODParkDetailsServiceMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ODGetCityDetailsModel cityParkDetails = new ODGetCityDetailsModel();
		
	
		return cityParkDetails;
	}
}