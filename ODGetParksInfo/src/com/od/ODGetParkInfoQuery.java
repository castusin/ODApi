package com.od;

public class ODGetParkInfoQuery {
	
	//public static String SQL_GETPARKSINFO = "select A.Appid,A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name,A.Description,A.OD_Rating,A.Street_address,A.State,A.PIN,A.Details,A.Overview_text, A.Faq,A.Latitude,A.Longitude,A.Type_string,A.Nature_string,A.Sub_category_string,A.Duration_string,A.Max_people,A.Popularity,A.Min_cost1,A.Min_cost1_people,A.Min_cost2,A.Min_cost2_people,A.Min_cost3,A.Min_cost3_people,A.Special_offer_percentage,A.Special_rate,A.Park_sub_images,A.Amenities_string,A.Main_photo_url,A.Sponsored_featured_flag,A.Tag_name,A.Date_added, min(rms.Current_price) AS Current_price from (select pv.Park_id, pv.Facility_type_code, count(*) , min(Current_price) as Current_price from Park_current_pricing_availability pv, Park_facility_inventory_pricing p where p.park_id = pv.Park_id and p.facility_type_code = pv.Facility_type_code and pv.date between ? and ? and current_available_qty > 0 group by pv.Park_id, pv.Facility_type_code having count(*)=?) rms, Park_info A where rms.park_id=A.park_id and A.Local_area=? group by A.Appid, A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name,A.Description,A.OD_Rating,A.Street_address,A.State,A.PIN,A.Details,A.Overview_text, A.Faq,A.Latitude,A.Longitude,A.Type_string,A.Nature_string,A.Sub_category_string,A.Duration_string,A.Max_people,A.Popularity,A.Min_cost1,A.Min_cost1_people,A.Min_cost2,A.Min_cost2_people,A.Min_cost3,A.Min_cost3_people,A.Special_offer_percentage,A.Special_rate,A.Park_sub_images,A.Amenities_string,A.Main_photo_url,A.Sponsored_featured_flag,A.Tag_name,A.Date_added";
	
	public static String SQL_GETPARKSINFO = "select A.Appid,A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name,A.Description,A.OD_Rating,A.Street_address,A.State,A.PIN,A.Details,A.Overview_text, A.Faq,A.Latitude,A.Longitude,A.Type_string,A.Nature_string,A.Sub_category_string,A.Duration_string,A.Max_people,A.Popularity,A.Min_cost1,A.Min_cost1_people,A.Min_cost2,A.Min_cost2_people,A.Min_cost3,A.Min_cost3_people,A.Special_offer_percentage,A.Special_rate,A.Park_sub_images,A.Amenities_string,A.Main_photo_url,A.Sponsored_featured_flag,A.Tag_name,A.Date_added, min(rms.Current_price) AS Current_price from (select pv.Park_id, pv.Facility_type_code, count(*) , min(Current_price) as Current_price from Park_current_pricing_availability pv, Park_facility_inventory_pricing p where p.park_id = pv.Park_id and p.facility_type_code = pv.Facility_type_code and pv.date between ? and ? and current_available_qty > 0 group by pv.Park_id, pv.Facility_type_code having count(*)=?) rms, Park_info A where rms.park_id=A.park_id and A.Local_area=? group by A.Appid, A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name,A.Description,A.OD_Rating,A.Street_address,A.State,A.PIN,A.Details,A.Overview_text, A.Faq,A.Latitude,A.Longitude,A.Type_string,A.Nature_string,A.Sub_category_string,A.Duration_string,A.Max_people,A.Popularity,A.Min_cost1,A.Min_cost1_people,A.Min_cost2,A.Min_cost2_people,A.Min_cost3,A.Min_cost3_people,A.Special_offer_percentage,A.Special_rate,A.Park_sub_images,A.Amenities_string,A.Main_photo_url,A.Sponsored_featured_flag,A.Tag_name,A.Date_added";
	
	
	public static String SQL_GETDATES = "select Date from Park_current_pricing_availability where Date=? "; 

}


/*select A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro,
A.Local_area, A.City, A.Name, min(rms.Current_price)
from (
select pv.Park_id, pv.Facility_type_code, count(*) , min(Current_price) as Current_price
from Park_current_pricing_availability pv, Park_facility_inventory_pricing p
where p.park_id = pv.Park_id and p.facility_type_code = pv.Facility_type_code
and pv.date between ? and ?
and current_available_qty > 0
group by pv.Park_id, pv.Facility_type_code
having count(*)=?) rms, littlepa_ODDB.Park_info A
where rms.park_id=A.park_id
group by A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro,
A.Local_area, A.City, A.Name;*/

/*SELECT A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name, A.Description, B.Facility_type_code, B.Current_available_qty
FROM Park_info A
JOIN Park_current_pricing_availability B ON A.Park_id = B.Park_id
WHERE A.Local_area =  'Madhapur'
AND DATE =  '2017-03-27'
AND B.Current_available_qty !=  '0'*/