package com.od;

public class ODGetParkDetailsQuery {
	
	
	public static String SQL_GETPARKSDETAILS = "SELECT Park_id,Name,OD_Rating,Metro,Local_area,Street_address,City,State,PIN,Description,Details,Overview_text, Faq,Latitude,Longitude,Type_string,Nature_string,Sub_category_string,Duration_string,Max_people,Popularity,Min_cost1,Min_cost1_people,Min_cost2,Min_cost2_people,Min_cost3,Min_cost3_people,Special_offer_percentage,Special_rate,Park_sub_images,Amenities_string,Main_photo_url FROM Park_info WHERE Park_id =? "; 

	public static String SQL_GETPARKSDETAILSLIST ="select pv.Park_id, pv.Room_type_code, count(*) , min(Current_price) as Current_price,p.Facility_type,p.Room_type_desc,p.Max_people,p.Max_adults,p.Max_kids,p.Max_qty,p.Regular_price,p.Facility_image,p.Facility_in_Room_facilities,p.Facility_type_title,p.Facility_type_code from Park_current_pricing_availability pv,Park_facility_inventory_pricing p, Park_info A where p.park_id = pv.Park_id and p.facility_type_code = pv.Room_type_code and p.park_id = A.park_id and pv.date between ? and ? and current_available_qty > 0 and pv.park_id=? group by  pv.Park_id, pv.Room_type_code,p.Room_type_desc,p.Max_people,p.Max_adults,p.Max_kids,p.Max_qty,p.Regular_price,p.Facility_image,p.Facility_in_Room_facilities,p.Facility_type_title,p.Facility_type_code having count(*)=? union select p.Park_id, p.Facility_type_code, 0 , 0 , p.Facility_type,p.Room_type_desc,p.Max_people,p.Max_adults,p.Max_kids,p.Max_qty,p.Regular_price,p.Facility_image,p.Facility_in_Room_facilities,p.Facility_type_title,p.Facility_type_code from Park_facility_inventory_pricing p where p.park_id=? and Facility_type='O'";
}

