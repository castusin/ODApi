package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODParkRegistrationMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODParkRegistrationModel login = new ODParkRegistrationModel();	
		login.setPhoneNumber(rs.getString("phone_number"));
		login.setUserName(rs.getString("username"));
		login.setPassword(rs.getString("password"));
		
		return login;
	}

}