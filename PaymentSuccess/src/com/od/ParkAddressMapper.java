package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ParkAddressMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ParkAddress avail = new ParkAddress();
		avail.setStreetAddress(rs.getString("Street_address"));
		avail.setState(rs.getString("State"));
		avail.setCity(rs.getString("City"));
	    avail.setResortname(rs.getString("Name"));
		avail.setPin(rs.getInt("PIN"));
		return avail;
	}
}