package com.od;

public class ODGetParkInfoQuery {
	
	//public static String SQL_GETPARKSINFO = "select Park_Id,Appid,Parktype,Park_subcategory,Metro,Local_area,Street_address,City,State,PIN,Name,Description,Details,OD_Rating,Sponsored_featured_flag,Overview_text,Faq,Latitude,Longitude,Type_string,Nature_string,Sub_category_string,Duration_string,Max_people,Date_added,Popularity,Min_cost1,Min_cost1_people,Min_cost2,Min_cost2_people,Min_cost3,Min_cost3_people,Special_offer_percentage,Special_rate,Main_photo_url,Park_sub_images, Tag_name from Park_info where Parktype=? and Metro=? and Local_area=?"; 

	
	public static String SQL_GETPARKSINFO = "SELECT A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name, A.Description, B.Facility_type_code, B.Current_available_qty	FROM Park_info A JOIN Park_current_pricing_availability B ON A.Park_id = B.Park_id	WHERE A.Local_area =? AND B.DATE = ? AND B.Current_available_qty !=  '0'";
	
	
	
	public static String SQL_GETDATES = "select Date from Park_current_pricing_availability where Date=? "; 

}
/*SELECT A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name, A.Description, B.Facility_type_code, B.Current_available_qty
FROM Park_info A
JOIN Park_current_pricing_availability B ON A.Park_id = B.Park_id
WHERE A.Local_area =  'Madhapur'
AND DATE =  '2017-03-27'
AND B.Current_available_qty !=  '0'*/