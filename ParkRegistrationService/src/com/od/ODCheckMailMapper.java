
package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODCheckMailMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ForgotPassword check = new ForgotPassword();	
		check.setPhoneNumber(rs.getString("phone_number"));
		check.setEmailId(rs.getString("username"));
		return check;
	}

}