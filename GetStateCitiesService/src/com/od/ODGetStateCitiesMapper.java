package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODGetStateCitiesMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODGetStateCitiesModel viewCities = new ODGetStateCitiesModel();
	
		viewCities.setCityKey(rs.getInt("city_key"));
		viewCities.setCityName(rs.getString("city_name"));
		
		return viewCities;
	}

}
