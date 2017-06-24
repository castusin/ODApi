package com.od;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class ODParkDetailsServiceMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ODParkDetailsService parkDetails = new ODParkDetailsService();
		
		parkDetails.setFacilityType(rs.getString("Facility_type"));
		parkDetails.setDescription(rs.getString("Room_type_desc"));
		parkDetails.setMaxPeople(rs.getString("Max_people"));
		parkDetails.setMaxAdults(rs.getString("Max_adults"));
		parkDetails.setMaxKids(rs.getString("Max_kids"));
		parkDetails.setMaxQty(rs.getString("Max_qty"));
		parkDetails.setRegularPrice(rs.getFloat("Regular_price"));
		//parkDetails.setDateAdded(rs.getDate("Date_added"));
		//parkDetails.setDate(rs.getDate("Date"));
		//parkDetails.setCurrentPrice(rs.getFloat("Current_price"));
		//parkDetails.setCurrentAvailableQuantity(rs.getString("Current_available_qty"));
		//parkDetails.setFacilityTypeCode(rs.getString("Facility_type_code"));
		parkDetails.setFacilityImage(rs.getString("Facility_image"));
		parkDetails.setFacilityInRoomFacilites(rs.getString("Facility_in_Room_facilities"));
		parkDetails.setFacilityTypeTitle(rs.getString("Facility_type_title"));
		parkDetails.setFacilityTypeCode(rs.getString("Facility_type_code"));
		parkDetails.setParkId(rs.getInt("Park_id"));
		parkDetails.setCurrentPrice(rs.getFloat("Current_price"));
		
		
		
		
		/*parkDetails.setOverviewText(rs.getString("Overview_text"));
		parkDetails.setMetro(rs.getString("Metro"));
		parkDetails.setLocalArea(rs.getString("Local_area"));
		parkDetails.setStreetAddress(rs.getString("Street_address"));
		parkDetails.setCity(rs.getString("City"));
		parkDetails.setState(rs.getString("State"));
		parkDetails.setPin(rs.getString("PIN"));
		parkDetails.setName(rs.getString("Name"));
		parkDetails.setDetails(rs.getString("Details"));
		parkDetails.setOdRating(rs.getFloat("OD_Rating"));
		parkDetails.setLatitude(rs.getFloat("Latitude"));
		parkDetails.setLongitude(rs.getFloat("Longitude"));
		parkDetails.setTypeString(rs.getString("Type_string"));
		parkDetails.setNatureString(rs.getString("Nature_string"));
		parkDetails.setSubCategoryString(rs.getString("Sub_category_string"));
		parkDetails.setDurationString(rs.getString("Duration_string"));
		//parkDetails.setPopularity(rs.getString("Popularity"));
		parkDetails.setMinCost1(rs.getFloat("Min_cost1"));
		parkDetails.setMinCost1People(rs.getFloat("Min_cost1_people"));
		parkDetails.setMinCost2(rs.getFloat("Min_cost2"));
		parkDetails.setMinCost2People(rs.getFloat("Min_cost2_people"));
		parkDetails.setSpecialOfferPercentage(rs.getFloat("Special_offer_percentage"));
		parkDetails.setSpecialRate(rs.getFloat("Special_rate"));
		parkDetails.setPhotoUrl(rs.getString("Main_photo_url"));
		parkDetails.setAmenitiesString(rs.getString("Amenities_string"));*/
	
		return parkDetails;
	}
}