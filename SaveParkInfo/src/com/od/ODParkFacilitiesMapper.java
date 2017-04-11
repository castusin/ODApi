package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODParkFacilitiesMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODParkFacilitiesModel facilitiesModel = new ODParkFacilitiesModel();
		
		facilitiesModel.setFacilityTypeCode(rs.getString("Facility_Type_code"));
		facilitiesModel.setFacilityTypeDescription(rs.getString("Facility_type_desc"));
		facilitiesModel.setTicketType(rs.getString("Ticket_type"));
		facilitiesModel.setMaxQty(rs.getInt("max_qty"));
		facilitiesModel.setCurrentAvailableQty(rs.getInt("current_available_qty"));
		facilitiesModel.setPrice(rs.getFloat("Price"));
		

		return facilitiesModel;
	}

	

}
