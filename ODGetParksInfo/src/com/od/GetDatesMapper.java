package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class GetDatesMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GetDatesModel getdates = new GetDatesModel();
		//getdates.setCheckIn(rs.getDate("from_date"));
		getdates.setDate(rs.getDate("Date"));
		return getdates;
	}

	
}
