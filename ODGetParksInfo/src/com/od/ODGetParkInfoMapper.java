package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODGetParkInfoMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ODGetParkInfoModel parksInfo = new ODGetParkInfoModel();
		//A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name, A.Description, B.Facility_type_code, B.Current_available_qty
		parksInfo.setParkId(rs.getInt("Park_Id"));
		//parksInfo.setAppId(rs.getString("Appid"));
		parksInfo.setParktype(rs.getString("Parktype"));
		parksInfo.setParkSubcategory(rs.getString("Park_subcategory"));
		parksInfo.setMetro(rs.getString("Metro"));
		parksInfo.setLocalArea(rs.getString("Local_area"));
		//parksInfo.setStreetAddress(rs.getString("Street_address"));
		parksInfo.setCity(rs.getString("City"));
		//parksInfo.setState(rs.getString("State"));	
		//parksInfo.setPin(rs.getString("PIN"));
		parksInfo.setName(rs.getString("Name"));
		//parksInfo.setDescription(rs.getString("Description"));
		//parksInfo.setDetails(rs.getString("Details"));
		//parksInfo.setOdRating(rs.getFloat("OD_Rating"));
		//parksInfo.setSponsoredFeaturedFlag(rs.getString("Sponsored_featured_flag"));
		//parksInfo.setOverviewText(rs.getString("Overview_text"));
		//parksInfo.setFaq(rs.getString("Faq"));
		//parksInfo.setLatitude(rs.getDouble("Latitude"));
		//parksInfo.setLongitude(rs.getDouble("Longitude"));
		//parksInfo.setTypeString(rs.getString("Type_string"));
		//parksInfo.setNatureString(rs.getString("Nature_string"));
		//parksInfo.setSubCategoryString(rs.getString("Sub_category_string"));
		//parksInfo.setDurationString(rs.getString("Duration_string"));
		//parksInfo.setMaxPeople(rs.getString("Max_people"));
		//parksInfo.setDateAdded(rs.getDate("Date_added"));
		//parksInfo.setPopularity(rs.getString("Popularity"));
		//parksInfo.setMinCost1(rs.getFloat("Min_cost1"));
		//parksInfo.setMinCost1People(rs.getFloat("Min_cost1_people"));
		//parksInfo.setMinCost2(rs.getFloat("Min_cost2"));
		//parksInfo.setMinCost2People(rs.getFloat("Min_cost2_people"));
		//parksInfo.setMinCost3(rs.getFloat("Min_cost3"));
		//parksInfo.setMinCost3People(rs.getFloat("Min_cost3_people"));
		//parksInfo.setSpecialOfferPercentage(rs.getFloat("Special_offer_percentage"));
		//parksInfo.setSpecialRate(rs.getFloat("Special_rate"));
		//parksInfo.setPhotoUrl(rs.getString("Main_photo_url"));
		//parksInfo.setImagefoldername(rs.getString("Park_sub_images"));
		//parksInfo.setTagName(rs.getString("Tag_name"));
		//parksInfo.setFacilitycode(rs.getString("Facility_type_code"));
		//parksInfo.setFacilityTypeCode(rs.getString("Facility_type_code"));
		//parksInfo.setAvail(rs.getInt("Current_available_qty"));
		
		parksInfo.setCurrentprice(rs.getFloat("Current_price"));
		return parksInfo;
	}

	
}
