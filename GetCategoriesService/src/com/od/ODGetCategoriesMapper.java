
package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODGetCategoriesMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		ODGetCategoriesModel categories = new ODGetCategoriesModel();
		
		categories.setAppId(rs.getString("Appid"));
		categories.setParkType(rs.getString("Parktype"));
		categories.setParksubcategory(rs.getString("Park_subcategory"));
		categories.setParkId(rs.getInt("Park_id"));
		categories.setOverviewText(rs.getString("Overview_text"));
		categories.setFaq(rs.getString("Faq"));
		//categories.setPhotoUrl(rs.getString("Main_photo_url"));
		categories.setName(rs.getString("Name"));
		categories.setOdRating(rs.getFloat("OD_Rating"));
		categories.setMetro(rs.getString("Metro"));
		categories.setLocalArea(rs.getString("Local_area"));
		categories.setStreetAddress(rs.getString("Street_address"));
		categories.setCity(rs.getString("City"));
		categories.setState(rs.getString("State"));
		categories.setPin(rs.getInt("PIN"));
		categories.setDescription(rs.getString("Description"));
		categories.setDetails(rs.getString("Details"));
		categories.setLatitude(rs.getDouble("Latitude"));
		categories.setLongitude(rs.getDouble("Longitude"));
		categories.setTypeString(rs.getString("Type_string"));
		categories.setNatureString(rs.getString("Nature_string"));
		categories.setSubCategoryString(rs.getString("Sub_category_string"));
		categories.setDurationString(rs.getString("Duration_string"));
		categories.setMaxPeople(rs.getString("Max_people"));
		
		categories.setPopularity(rs.getString("Popularity"));
		categories.setMinCost1(rs.getFloat("min_curr_price"));
		categories.setMinCost1People(rs.getInt("Min_cost1_people"));
		categories.setMinCost2(rs.getFloat("Min_cost2"));
		categories.setMinCost2People(rs.getInt("Min_cost2_people"));
		//categories.setMinCost3(rs.getFloat("Min_cost3"));
		//categories.setMinCost3People(rs.getInt("Min_cost3_people"));
		categories.setSpecialOfferPercentage(rs.getFloat("Special_offer_percentage"));
		categories.setSpecialRate(rs.getFloat("Special_rate"));
		categories.setPhotoUrl(rs.getString("Main_photo_url"));
		categories.setParkSubImages(rs.getString("Park_sub_images"));
		categories.setAmenitiesString(rs.getString("Amenities_string"));
		categories.setSponsoredFlag(rs.getString("Sponsored_featured_flag"));
		categories.setTag(rs.getString("Tag_name"));
		
		
		categories.setCreateDate(rs.getDate("Creation_date"));
		//categories.setUpdationDate(rs.getDate("Updation_date"));
		categories.setCreatedBy(rs.getString("Created_by"));
		categories.setUpdatedBy(rs.getString("Updated_by"));
		categories.setVideoLinks(rs.getString("Video_Links"));
		categories.setPolicyText(rs.getString("Policy_text"));
		categories.setStateId(rs.getInt("state_id"));
		categories.setCityId(rs.getInt("city_id"));
		categories.setDiscount(rs.getInt("Discount"));
		categories.setDiscountMode(rs.getString("Discount_Mode"));
		categories.setFromDate(rs.getDate("From_date"));
		categories.setToDate(rs.getDate("To_date"));
		
		
		//categories.setCreateDate(rs.getDate("Creation_date"));
		//categories.setCurrentPrice(rs.getFloat("Current_price"));
		
		/*categories.setFacilitytypecode(rs.getString("Facility_type_code"));
		categories.setSponsoredFlag(rs.getString("Sponsored_featured_flag"));	
		categories.setTag(rs.getString("Tag_name"));*/
		return categories;
	}
	

}

