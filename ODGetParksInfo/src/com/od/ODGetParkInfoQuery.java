package com.od;

public class ODGetParkInfoQuery {
	
	public static String SQL_GETPARKSINFO = "select Appid,Parktype,Park_subtype,Metro,Local_area,Street_address,City,State,PIN,Name,Description,Details,Park_Id,OD_Rating,Sponsored_featured_flag,Overview_text,Faq,Latitude,Longitude,Type_string,Nature_string,Sub_category_string,Duration_string,Max_people,Date_added,Popularity,Min_cost1,Min_cost1_people,Min_cost2,Min_cost2_people,Min_cost3,Min_cost3_people,Special_offer_percentage,Special_rate,Main_photo_url from Park_info where Metro=? and Local_area=? and OD_Rating=?"; 

}
