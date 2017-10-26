package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODGetParkDetailsMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
       ODGetParkDetailsModel parkDetails = new ODGetParkDetailsModel();
       
        parkDetails.setParkId(rs.getInt("Park_id"));
		parkDetails.setOverviewText(rs.getString("Overview_text"));
		parkDetails.setFaq(rs.getString("Faq"));
		//parkDetails.setPhotoUrl(rs.getString("Main_photo_url"));
		parkDetails.setName(rs.getString("Name"));
		parkDetails.setOdRating(rs.getFloat("OD_Rating"));
		parkDetails.setMetro(rs.getString("Metro"));
		parkDetails.setLocalArea(rs.getString("Local_area"));
		parkDetails.setStreetAddress(rs.getString("Street_address"));
		parkDetails.setCity(rs.getString("City"));
		parkDetails.setState(rs.getString("State"));
		parkDetails.setPin(rs.getInt("PIN"));
		parkDetails.setDescription(rs.getString("Description"));
		parkDetails.setDetails(rs.getString("Details"));
		parkDetails.setLatitude(rs.getDouble("Latitude"));
		parkDetails.setLongitude(rs.getDouble("Longitude"));
		parkDetails.setTypeString(rs.getString("Type_string"));
		parkDetails.setNatureString(rs.getString("Nature_string"));
		parkDetails.setSubCategoryString(rs.getString("Sub_category_string"));
		parkDetails.setDurationString(rs.getString("Duration_string"));
		parkDetails.setMaxPeople(rs.getString("Max_people"));
		
		parkDetails.setPopularity(rs.getString("Popularity"));
		parkDetails.setMinCost1(rs.getFloat("Min_cost1"));
		parkDetails.setMinCost1People(rs.getInt("Min_cost1_people"));
		parkDetails.setMinCost2(rs.getFloat("Min_cost2"));
		parkDetails.setMinCost2People(rs.getInt("Min_cost2_people"));
		parkDetails.setMinCost3(rs.getFloat("Min_cost3"));
		parkDetails.setMinCost3People(rs.getInt("Min_cost3_people"));
		parkDetails.setSpecialOfferPercentage(rs.getFloat("Special_offer_percentage"));
		parkDetails.setSpecialRate(rs.getFloat("Special_rate"));
		parkDetails.setPhotoUrl(rs.getString("Main_photo_url"));
		parkDetails.setParkSubImages(rs.getString("Park_sub_images"));
		parkDetails.setAmenitiesString(rs.getString("Amenities_string"));
		
		//parkDetails.setParkMainImages(rs.getString("Facility_main_image"));
		
		//parkDetails.setCurrentPrice(rs.getFloat("Current_price"));
		return parkDetails;
	}


}