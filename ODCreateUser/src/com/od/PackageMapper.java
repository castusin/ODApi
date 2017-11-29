package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class PackageMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PackageDetails packagedetails = new PackageDetails();

		packagedetails.setTypeCode(rs.getString("type_code"));
		
		packagedetails.setQuantity(rs.getInt("Quantity"));
		
		packagedetails.setTitle(rs.getString("Title"));

		packagedetails.setPrice(rs.getFloat("Price"));
		
		packagedetails.setType(rs.getString("type"));
		
		packagedetails.setPackageId(rs.getInt("Package_id"));
		
		packagedetails.setOriginalamount(rs.getFloat("Original_Amount"));
		
		packagedetails.setDiscountamount(rs.getFloat("Discount_amount"));

		packagedetails.setCollectamount(rs.getFloat("Collect_Amount"));

		return packagedetails;
	}
}