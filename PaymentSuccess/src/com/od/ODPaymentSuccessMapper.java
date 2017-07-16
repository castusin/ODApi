package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODPaymentSuccessMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ODPaymentSuccessModel paymentStatus = new ODPaymentSuccessModel();
		paymentStatus.setEmailId(rs.getString("email_id"));
	    paymentStatus.setFirstName(rs.getString("first_name"));
	    paymentStatus.setPhoneNumber(rs.getString("phoneno1"));
		return paymentStatus;
	}
}