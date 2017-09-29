package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class RequestOTPMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		RequestOTP requestOTP = new RequestOTP();
		//requestOTP.setPhoneNumber(rs.getString("Registered_Phone_Number"));
		return requestOTP;
	}

}
