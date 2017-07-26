
package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODCheckPhoneMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODCheckMail check = new ODCheckMail();	
		check.setPhoneNumber(rs.getString("phone_number"));
		
		return check;
	}

}