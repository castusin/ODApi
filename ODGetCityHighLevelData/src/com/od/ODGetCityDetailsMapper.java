/**
 * 
 */
package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Darshan
 *
 */
@SuppressWarnings("rawtypes")
public class ODGetCityDetailsMapper implements RowMapper{
public Object mapRow(ResultSet rs, int rowNum) throws SQLException { 
		
	    ODGetCityDetailsModel cityInfoDetails = new ODGetCityDetailsModel();
		cityInfoDetails.setCityId(rs.getInt("city_key"));
		//cityInfoDetails.setCityName(rs.getString("city_name"));
		cityInfoDetails.setLocalAreaId(rs.getInt("location_key"));
		cityInfoDetails.setLocalArea(rs.getString("location_name"));
		//cityInfoDetails.setDate(rs.getDate("Creation_date"));
		//cityInfoDetails.setParktype(rs.getString("Parktype"));
		//cityInfoDetails.setName(rs.getString("Name"));
		
		//cityInfoDetails.setLocalArea(rs.getString("Local_area"));
		cityInfoDetails.setName(rs.getString("Name"));
		cityInfoDetails.setParkId(rs.getInt("Park_id"));
		
		
		return cityInfoDetails;
	}
}
