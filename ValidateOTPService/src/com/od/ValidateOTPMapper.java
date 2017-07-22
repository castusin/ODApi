package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;
@SuppressWarnings("rawtypes")
public class ValidateOTPMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ValidateOTP verifyModel = new ValidateOTP();
		verifyModel.setPhoneNumber(rs.getString("Registered_Phone_Number"));
	//	verifyModel.setOtp(rs.getString("OTP"));
		verifyModel.setTimeStamp(rs.getString("time_stamp"));
		return verifyModel;
	}
}
