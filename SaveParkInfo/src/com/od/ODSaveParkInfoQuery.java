package com.od;

public class ODSaveParkInfoQuery {
	
	public static String SQL_SAVEPARKSINFO = "insert into Park_info( Appid,Parktype,Park_subcategory,Metro,Local_area,Street_address,City,State,PIN,Name,Description,Details,Park_id,OD_Rating,Sponsored_featured_flag,Overview_text,Faq,Latitude,Longitude,Type_string,Nature_string,Sub_category_string,Duration_string,Max_people,Date_added,Popularity,Min_cost1,Min_cost1_people,Min_cost2,Min_cost2_people,Min_cost3,Min_cost3_people,Special_offer_percentage,Special_rate,Main_photo_url,image_folder_name)"+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
	
	public static String SQL_SAVEPARKSROOMS = "insert into Park_rooms_inventory( Park_id,Room_type_code,Room_type_desc,Max_people,Max_adults,Max_kids,Max_qty,Regular_price,Date_added)"+"values(?,?,?,?,?,?,?,?,?)"; 
	

	public static String SQL_SAVEPARKSFACILITIES = "insert into Park_facilities_inventory( Park_id,Facility_Type_code,Facility_type_desc,Ticket_type,max_qty,current_available_qty,Price)"+"values(?,?,?,?,?,?,?)"; 
	

	public static String SQL_SAVEPARKSPRICING = "insert into Park_current_pricing( Park_id,Room_type_code,From_date,To_date,current_Price)"+"values(?,?,?,?,?)"; 
	

	
}
