package com.od;

public class ODGetParkDetailsQuery {
	
	
	public static String SQL_GETPARKSDETAILS = "SELECT Park_id,Name,OD_Rating,Metro,Local_area,Street_address,City,State,PIN,Description,Details,Overview_text, Faq,Latitude,Longitude,Type_string,Nature_string,Sub_category_string,Duration_string,Max_people,Popularity,Min_cost1,Min_cost1_people,Min_cost2,Min_cost2_people,Min_cost3,Min_cost3_people,Special_offer_percentage,Special_rate,Park_sub_images,Amenities_string,Main_photo_url FROM Park_info WHERE Park_id =? "; 

	//public static String SQL_GETPARKSDETAILSLIST ="select pv.Park_id, pv.Room_type_code, count(*) , min(Current_price) as Current_price,p.Facility_type,p.Room_type_desc,p.Max_people,p.Max_adults,p.Max_kids,p.Max_qty,p.Regular_price,p.Facility_image,p.Facility_in_Room_facilities,p.Facility_type_title,p.Facility_type_code from Park_current_pricing_availability pv,Park_facility_inventory_pricing p, Park_info A where p.park_id = pv.Park_id and p.facility_type_code = pv.Room_type_code and p.park_id = A.park_id and pv.date between ? and ? and current_available_qty > 0 and pv.park_id=? group by  pv.Park_id, pv.Room_type_code,p.Room_type_desc,p.Max_people,p.Max_adults,p.Max_kids,p.Max_qty,p.Regular_price,p.Facility_image,p.Facility_in_Room_facilities,p.Facility_type_title,p.Facility_type_code having count(*)=? union select p.Park_id, p.Facility_type_code, 0 , 0 , p.Facility_type,p.Room_type_desc,p.Max_people,p.Max_adults,p.Max_kids,p.Max_qty,p.Regular_price,p.Facility_image,p.Facility_in_Room_facilities,p.Facility_type_title,p.Facility_type_code from Park_facility_inventory_pricing p where p.park_id=? and Facility_type='O'";
	//public static String SQL_GETPARKSDETAILSLIST ="select pv.Park_id, pv.Room_type_code, count(*) , min(Current_price) as Current_price,p.Facility_type,p.Room_type_desc,p.Max_people,p.Max_adults,p.Max_kids,p.Max_qty,p.Regular_price,p.Facility_image,p.Facility_in_Room_facilities,p.Facility_type_title,p.Facility_type_code from Park_current_pricing_availability pv,Park_facility_inventory_pricing p, Park_info A where p.park_id = pv.Park_id and p.facility_type_code = pv.Room_type_code and p.park_id = A.park_id and pv.date between ? and ? and current_available_qty > 0 and pv.park_id=? group by  pv.Park_id, pv.Room_type_code,p.Room_type_desc,p.Max_people,p.Max_adults,p.Max_kids,p.Max_qty,p.Regular_price,p.Facility_image,p.Facility_in_Room_facilities,p.Facility_type_title,p.Facility_type_code having count(*)=? ";
	
	//public static String SQL_GETPARKSDETAILSLIST ="SELECT pv.Park_id, pv.park_room_fac, COUNT( * ) , MIN( Current_price ) AS Current_price, p.Facility_type, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.date BETWEEN  ? AND  ? AND pv.current_available_qty >0 AND A.Parktype = ? AND A.park_id = ? GROUP BY pv.Park_id, pv.park_room_fac, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code HAVING COUNT( * ) =?";
	//public static String SQL_GETPARKSPACKAGESLIST ="SELECT pv.Park_id, pv.park_room_fac, COUNT( * ) , MIN( Current_price ) AS Current_price, p.Facility_type, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code, pd.Discount, pd.Discount_Mode,A.Amenities_string,p.Package_Items,p.Room_type_desc FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A, park_discount pd WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.date BETWEEN  ? AND  ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'P'    AND p.Package_Id = pd.Package_Id AND A.park_id = ? GROUP BY pv.Park_id, pv.park_room_fac, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code, pd.Discount, pd.Discount_Mode,A.Amenities_string,p.Package_Items,p.Room_type_desc HAVING COUNT( * ) =?";
	//public static String SQL_GETPARKSROOMSLIST    ="SELECT pv.Park_id, pv.park_room_fac, COUNT( * ) , MIN( Current_price ) AS Current_price, p.Facility_type, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code, pd.Discount, pd.Discount_Mode,A.Amenities_string,p.Package_Items,p.Room_type_desc FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A, park_discount pd WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.date BETWEEN  ? AND  ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'R'    AND p.Package_Id = pd.Package_Id AND A.park_id = ? GROUP BY pv.Park_id, pv.park_room_fac, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code, pd.Discount, pd.Discount_Mode,A.Amenities_string,p.Package_Items,p.Room_type_desc HAVING COUNT( * ) =?";
	//public static String SQL_GETADDONSSLIST       ="SELECT pv.Park_id, pv.park_room_fac, COUNT( * ) , MIN( Current_price ) AS Current_price, p.Facility_type, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code, pd.Discount, pd.Discount_Mode,A.Amenities_string,pad.Pack_Addon_Id FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A, park_discount pd, park_addons pad WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.date BETWEEN  ? AND  ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'AD' AND p.Package_Id = pd.Package_Id And p.Package_Id=pad.Pack_Addon_Id AND A.park_id = ? GROUP BY pv.Park_id, pv.park_room_fac, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code, pd.Discount, pd.Discount_Mode,A.Amenities_string,pad.Pack_Addon_Id HAVING COUNT( * ) =?";
	public static String SQL_GETADDONSSLIST       ="select oth.*, pd.Discount, pd.Discount_Mode from (SELECT pv.Park_id park_id,  COUNT( * ) , MIN( Current_price ) AS Current_price, p.Facility_type, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,pad.Pack_Addon_Id,p.Facility_main_image,p.Park_Room_Fac FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A, park_addons pad WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.date BETWEEN  ? AND  ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'AD' And p.Package_Id=pad.Pack_Addon_Id AND A.park_id = ? And p.Is_active=0 GROUP BY pv.Park_id,  p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,p.Room_type_desc,pad.Pack_Addon_Id ,p.Facility_main_image,p.Park_Room_Fac HAVING COUNT( * ) =?) oth left outer join park_discount pd on oth.park_id=pd.Resort_Id and  oth.park_room_fac=pd.park_room_fac and pd.Status='A'";
	
	public static String SQL_GETPARKSPACKAGESLIST ="select oth.*, pd.Discount, pd.Discount_Mode from (SELECT pv.Park_id park_id,  COUNT( * ) , MIN( Current_price ) AS Current_price,  p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,p.Facility_main_image,p.Park_Room_Fac,p.Facility_type,p.Inclusions FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.date BETWEEN  ? AND  ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'P' AND A.park_id = ? And p.Is_active=0 GROUP BY pv.Park_id,  p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,p.Room_type_desc,p.Facility_main_image,p.Park_Room_Fac  HAVING COUNT( * ) =?) oth left outer join park_discount pd on oth.park_id=pd.Resort_Id and  oth.park_room_fac=pd.park_room_fac and pd.Status='A'";
	
	public static String SQL_GETPARKSROOMSLIST    ="select oth.*, pd.Discount, pd.Discount_Mode from (SELECT pv.Park_id park_id,  COUNT( * ) , MIN( Current_price ) AS Current_price,  p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,p.Facility_main_image,p.Park_Room_Fac,p.Facility_type,p.Inclusions FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.date BETWEEN  ? AND  ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'R' AND A.park_id = ? And p.Is_active=0 GROUP BY pv.Park_id, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,p.Room_type_desc,p.Facility_main_image,p.Park_Room_Fac  HAVING COUNT( * ) =?) oth left outer join park_discount pd on oth.park_id=pd.Resort_Id and  oth.park_room_fac=pd.park_room_fac and pd.Status='A'";
	
	//public static String SQL_GETADDONSSLIST       ="SELECT ad.Pack_Addon_Name,ad.Addon_path, pd.Discount, pd.Discount_Mode FROM park_addons ad, park_discount pd WHERE ad.CreatedBy = pd.CreatedBy";

	public static String SQL_GETAMINITIESLIST     ="SELECT Amenities_Id,Amenities_Name,Amenities_Path FROM park_amenities";

	
	//public static String SQL_GETPARKSPACKAGESLISTRES ="SELECT pv.Park_id, pv.park_room_fac, COUNT( * ) , MIN( Current_price ) AS Current_price, p.Facility_type, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code, pd.Discount, pd.Discount_Mode,A.Amenities_string,p.Package_Items,p.Room_type_desc FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A, park_discount pd WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.Date = ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'P'  AND p.Package_Id = pd.Package_Id AND A.park_id = ? GROUP BY pv.Park_id, pv.park_room_fac, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code, pd.Discount, pd.Discount_Mode,A.Amenities_string,p.Package_Items,p.Room_type_desc ";
	public static String SQL_GETPARKSPACKAGESLISTRES ="select oth.*, pd.Discount, pd.Discount_Mode from (SELECT pv.Park_id park_id,  COUNT( * ) , MIN( Current_price ) AS Current_price,  p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,p.Facility_main_image,p.Park_Room_Fac,p.Facility_type,p.Inclusions,p.Is_active FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.Date = ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'P' AND A.park_id = ? And p.Is_active=0 GROUP BY pv.Park_id,  p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,p.Room_type_desc,p.Facility_main_image,p.Park_Room_Fac) oth left outer join park_discount pd on oth.park_id=pd.Resort_Id and  oth.park_room_fac=pd.park_room_fac and pd.Status='A'";
	
	public static String SQL_GETPARKSROOMSLISTRES    ="select oth.*, pd.Discount, pd.Discount_Mode from (SELECT pv.Park_id park_id,  COUNT( * ) , MIN( Current_price ) AS Current_price,  p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,p.Facility_main_image,p.Park_Room_Fac,p.Facility_type,p.Inclusions,p.Is_active FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.Date = ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'R' AND A.park_id = ? And p.Is_active=0 GROUP BY pv.Park_id,  p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,p.Room_type_desc,p.Facility_main_image,p.Park_Room_Fac) oth left outer join park_discount pd on oth.park_id=pd.Resort_Id and  oth.park_room_fac=pd.park_room_fac and pd.Status='A'";
	
	//public static String SQL_GETADDONSSLISTRES       ="SELECT pv.Park_id, pv.park_room_fac, COUNT( * ) , MIN( Current_price ) AS Current_price, p.Facility_type, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code, pd.Discount, pd.Discount_Mode,A.Amenities_string,pad.Pack_Addon_Id FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A, park_discount pd, park_addons pad WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.Date = ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'AD' AND p.Package_Id = pd.Package_Id And p.Package_Id=pad.Pack_Addon_Id AND A.park_id = ? GROUP BY pv.Park_id, pv.park_room_fac, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code, pd.Discount, pd.Discount_Mode,A.Amenities_string,pad.Pack_Addon_Id ";
	public static String SQL_GETADDONSSLISTRES       ="select oth.*, pd.Discount, pd.Discount_Mode from (SELECT pv.Park_id park_id,  COUNT( * ) , MIN( Current_price ) AS Current_price, p.Facility_type, p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,pad.Pack_Addon_Id,p.Facility_main_image,p.Park_Room_Fac FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p, Park_info A, park_addons pad WHERE p.park_id = pv.Park_id AND p.park_id = A.park_id AND p.Park_Room_Fac = pv.park_room_fac AND pv.Date = ? AND pv.current_available_qty >0 AND A.Parktype = ? AND p.Facility_type =  'AD' And p.Package_Id=pad.Pack_Addon_Id AND A.park_id = ? And p.Is_active=0 GROUP BY pv.Park_id,  p.Room_type_desc, p.Max_people, p.Max_adults, p.Max_kids, p.Max_qty, p.Regular_price, p.Facility_image, p.Facility_in_Room_facilities, p.Facility_type_title, p.Facility_type_code,A.Amenities_string,p.Package_Items,p.Room_type_desc,pad.Pack_Addon_Id,p.Facility_main_image,p.Park_Room_Fac) oth left outer join park_discount pd on oth.park_id=pd.Resort_Id and  oth.park_room_fac=pd.park_room_fac and pd.Status='A'";
	
	public static String SQL_GETAMINITIESLISTRES     ="SELECT Amenities_Id,Amenities_Name,Amenities_Path FROM park_amenities";

}








