package com.od;

public class ODGetParkDetailsQuery {
	
	
	public static String SQL_GETPARKSDETAILS = "SELECT Overview_text, Faq,Main_photo_url FROM Park_info   WHERE Park_id =? "; 

	public static String SQL_GETPARKSDETAILSLIST = "SELECT Room_type_desc,Max_adults,Max_kids,Max_qty,Regular_price FROM  Park_rooms_inventory WHERE Park_id =? ";    

	
	
	
	
}
