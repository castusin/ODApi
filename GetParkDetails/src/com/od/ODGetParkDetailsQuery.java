package com.od;

public class ODGetParkDetailsQuery {
	
	
	//public static String SQL_GETPARKSDETAILS = "SELECT Name,OD_Rating,Metro,Local_area,Street_address,City,State,PIN,Description,Details,Overview_text, Faq,Latitude,Longitude,Type_string,Nature_string,Sub_category_string,Duration_string,Max_people,Popularity,Min_cost1,Min_cost1_people,Min_cost2,Min_cost2_people,Min_cost3,Min_cost3_people,Special_offer_percentage,Special_rate,Park_sub_images,Amenities_string,Main_photo_url FROM Park_info WHERE Park_id =? "; 

	//public static String SQL_GETPARKSDETAILSLIST ="SELECT A.Facility_type_code,A.Facility_type,A.Room_type_desc,A.Max_people,A.Max_adults,A.Max_kids,A.Max_qty,A.Regular_price,A.Date_added,A.Facility_type_title,A.Facility_in_Room_facilities,A.Facility_image,B.Date,B.Current_price,B.Current_available_qty FROM Park_facility_inventory_pricing A  JOIN Park_current_pricing_availability B ON A.Park_id = B.Park_id AND A.Facility_type_code = B.Facility_type_code  WHERE A.Park_id =?" ;
		
	//public static String SQL_GETPARKSDETAILSLIST ="SELECT Facility_type_code,Facility_type,Room_type_desc,Max_people,Max_adults,Max_kids,Max_qty,Regular_price,Date_added,Facility_type_title,Facility_in_Room_facilities,Facility_image FROM Park_facility_inventory_pricing  WHERE Park_id =?" ;
	
	
	public static String SQL_GETPARKSDETAILS ="select pv.Park_id, pv.Facility_type_code, count(*) , min(Current_price) AS Current_price from Park_current_pricing_availability pv, Park_facility_inventory_pricing p where p.park_id = pv.Park_id and p.facility_type_code = pv.Facility_type_code and pv.date between ? and ? and current_available_qty > 0 and pv.park_id=? group by pv.Park_id, pv.Facility_type_code having count(*)=? ";
	//public static String SQL_GETPARKSDETAILS ="select pv.Park_id, pv.Facility_type_code, count(*) , min(Current_price) as Current_price from Park_current_pricing_availability pv, Park_facility_inventory_pricing p where p.park_id = pv.Park_id and p.facility_type_code = pv.Facility_type_code and pv.date between ? and ?  and current_available_qty > 0 and pv.park_id=? group by pv.Park_id, pv.Facility_type_code having count(*)=?";

}



/*select pv.Park_id, pv.Facility_type_code, count(*) , min(Current_price) as Current_price
from littlepa_ODDB.Park_current_pricing_availability pv, littlepa_ODDB.Park_facility_inventory_pricing p
where p.park_id = pv.Park_id and p.facility_type_code = pv.Facility_type_code
and pv.date between '2017-06-14'and '2017-06-17' 
and current_available_qty > 0
and pv.park_id=100254
group by pv.Park_id, pv.Facility_type_code
having count(*)=4;*/