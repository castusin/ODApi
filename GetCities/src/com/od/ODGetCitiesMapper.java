package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODGetCitiesMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODGetCitiesModel viewCities = new ODGetCitiesModel();
	
		viewCities.setCityKey(rs.getInt("city_key"));
		viewCities.setCityName(rs.getString("city_name"));
		
		return viewCities;
	}

}
