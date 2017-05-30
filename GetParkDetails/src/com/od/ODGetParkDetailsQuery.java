package com.od;

public class ODGetParkDetailsQuery {
	
	
	public static String SQL_GETPARKSDETAILS = "SELECT Name,OD_Rating,Metro,Local_area,Street_address,City,State,PIN,Description,Details,Overview_text, Faq,Latitude,Longitude,Type_string,Nature_string,Sub_category_string,Duration_string,Max_people,Popularity,Min_cost1,Min_cost1_people,Min_cost2,Min_cost2_people,Min_cost3,Min_cost3_people,Special_offer_percentage,Special_rate,Park_sub_images,Amenities_string,Main_photo_url FROM Park_info WHERE Park_id =? "; 

	
	public static String SQL_GETPARKSDETAILSLIST ="SELECT A.Facility_type_code,A.Facility_type,A.Room_type_desc,A.Max_people,A.Max_adults,A.Max_kids,A.Max_qty,A.Regular_price,A.Date_added,A.Facility_type_title,A.Facility_in_Room_facilities,A.Facility_image,B.Date,B.Current_price,B.Current_available_qty FROM Park_facility_inventory_pricing A  JOIN Park_current_pricing_availability B ON A.Park_id = B.Park_id AND A.Facility_type_code = B.Facility_type_code  WHERE A.Park_id =?" ;
		
	
}
