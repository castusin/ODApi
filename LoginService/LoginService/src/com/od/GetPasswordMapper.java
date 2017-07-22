package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



@SuppressWarnings("rawtypes")
public class GetPasswordMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODParkRegistrationModel login = new ODParkRegistrationModel();	
		
		login.setPassword(rs.getString("password"));
		
		return login;
	}

}