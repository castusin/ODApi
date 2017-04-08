package com.od;

public class ODGetParkDetailsQuery {
	
	//public static String SQL_GETPARKSDETAILS = "SELECT A.Overview_text, A.Faq,A.Main_photo_url,B.Room_type_code,B.Room_type_desc,B.Max_adults,B.Max_kids,B.Max_qty,B.Current_available_qty,B.Regular_price FROM Park_info A  LEFT JOIN Park_rooms_inventory B ON A.Park_id = B.Park_id  WHERE A.Park_id =? ;"; 
	public static String SQL_GETPARKSDETAILS = "SELECT Overview_text, Faq,Main_photo_url FROM Park_info   WHERE Park_id =? "; 

	public static String SQL_GETPARKSDETAILSLIST = "SELECT Room_type_code,Room_type_desc,Max_adults,Max_kids,Max_qty,Regular_price FROM  Park_rooms_inventory WHERE Park_id =? ";    

}
