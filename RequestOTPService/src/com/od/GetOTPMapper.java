/**
 * 
 */
package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 
 *
 */
@SuppressWarnings("rawtypes")
public class GetOTPMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ValidateOTP verifyModel = new ValidateOTP();
		verifyModel.setPhoneNumber(rs.getString("Registered_Phone_Number"));
		//verifyModel.setEmailId(rs.getString("EmailId"));
		verifyModel.setOtp(rs.getString("OTP"));
		verifyModel.setTimeStamp(rs.getString("time_stamp"));
		return verifyModel;
	} 

}
