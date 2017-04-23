package com.od;

public class ODGetParkInfoQuery {
	
	public static String SQL_GETPARKSINFO = "select Park_Id,Appid,Parktype,Park_subcategory,Metro,Local_area,Street_address,City,State,PIN,Name,Description,Details,OD_Rating,Sponsored_featured_flag,Overview_text,Faq,Latitude,Longitude,Type_string,Nature_string,Sub_category_string,Duration_string,Max_people,Date_added,Popularity,Min_cost1,Min_cost1_people,Min_cost2,Min_cost2_people,Min_cost3,Min_cost3_people,Special_offer_percentage,Special_rate,Main_photo_url,image_folder_name from Park_info where Parktype=? and Metro=? and Local_area=?"; 

}
