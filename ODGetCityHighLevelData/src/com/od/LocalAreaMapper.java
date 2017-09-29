
package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 
 *
 */
@SuppressWarnings("rawtypes")
public class LocalAreaMapper implements RowMapper{
public Object mapRow(ResultSet rs, int rowNum) throws SQLException { 
		
	LocalAreaData cityInfoDetails = new LocalAreaData();
		cityInfoDetails.setCityId(rs.getInt("city_key"));
		//cityInfoDetails.setCityName(rs.getString("city_name"));
		cityInfoDetails.setLocalAreaId(rs.getInt("location_key"));
		cityInfoDetails.setLocalArea(rs.getString("location_name"));
	
		
		
		return cityInfoDetails;
	}
}
