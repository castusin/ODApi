package com.od;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODParkPricingMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODParkPricingModel pricingModel = new ODParkPricingModel();
		
		pricingModel.setRoomTypeCode(rs.getString("Room_type_code"));
		pricingModel.setFromDate(rs.getDate("From_date"));
		pricingModel.setToDate(rs.getDate("To_date"));
		pricingModel.setCurrentPrice(rs.getFloat("current_Price"));
		
		return pricingModel;
	}

	

}
