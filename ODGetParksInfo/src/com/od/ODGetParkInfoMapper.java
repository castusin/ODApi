package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODGetParkInfoMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODGetParkInfoModel parksInfo = new ODGetParkInfoModel();
		
		parksInfo.setAppId(rs.getString("Appid"));
		parksInfo.setParktype(rs.getString("Parktype"));
		parksInfo.setParkSubcategory(rs.getString("Park_subcategory"));
		parksInfo.setMetro(rs.getString("Metro"));
		parksInfo.setLocalArea(rs.getString("Local_area"));
		parksInfo.setStreetAddress(rs.getString("Street_address"));
		parksInfo.setCity(rs.getString("City"));
		parksInfo.setState(rs.getString("State"));	
		parksInfo.setPin(rs.getString("PIN"));
		parksInfo.setName(rs.getString("Name"));
		parksInfo.setDescription(rs.getString("Description"));
		parksInfo.setDetails(rs.getString("Details"));
		parksInfo.setParkId(rs.getInt("Park_Id"));
		parksInfo.setOdRating(rs.getInt("OD_Rating"));
		parksInfo.setSponsoredFeaturedFlag(rs.getString("Sponsored_featured_flag"));
		parksInfo.setOverviewText(rs.getString("Overview_text"));
		parksInfo.setFaq(rs.getString("Faq"));
		parksInfo.setLatitude(rs.getString("Latitude"));
		parksInfo.setLongitude(rs.getString("Longitude"));
		parksInfo.setTypeString(rs.getString("Type_string"));
		parksInfo.setNatureString(rs.getString("Nature_string"));
		parksInfo.setSubCategoryString(rs.getString("Sub_category_string"));
		parksInfo.setDurationString(rs.getString("Duration_string"));
		parksInfo.setMaxPeople(rs.getString("Max_people"));
		parksInfo.setDateAdded(rs.getDate("Date_added"));
		parksInfo.setPopularity(rs.getString("Popularity"));
		parksInfo.setMinCost1(rs.getFloat("Min_cost1"));
		parksInfo.setMinCost1People(rs.getFloat("Min_cost1_people"));
		parksInfo.setMinCost2(rs.getFloat("Min_cost2"));
		parksInfo.setMinCost2People(rs.getFloat("Min_cost2_people"));
		parksInfo.setMinCost3(rs.getFloat("Min_cost3"));
		parksInfo.setMinCost3People(rs.getFloat("Min_cost3_people"));
		parksInfo.setSpecialOfferPercentage(rs.getFloat("Special_offer_percentage"));
		parksInfo.setSpecialRate(rs.getFloat("Special_rate"));
		parksInfo.setPhotoUrl(rs.getString("Main_photo_url"));
		parksInfo.setImagefoldername(rs.getString("image_folder_name"));
		return parksInfo;
	}

	

}
