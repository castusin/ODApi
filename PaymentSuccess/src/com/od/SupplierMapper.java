package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class SupplierMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SupplierModel supp = new SupplierModel();
		//supp.setParkId(rs.getInt("park_id"));
	//	supp.setCreatedByPark(rs.getString("Created_by"));
		//supp.setCreatedBySup(rs.getString("CreatedBy"));
		//supp.setReservationId(rs.getInt("Reservation_id"));
		supp.setEmailId(rs.getString("Email_ID"));
		return supp;
	}
}