package com.od;

public class ODGetParkDetailsQuery {
	
	public static String SQL_GETPARKSDETAILS = "SELECT A.Overview_text, A.Faq,A.Main_photo_url,B.Room_type_code,B.Room_type_desc,B.Max_adults,B.Max_kids,B.Max_qty,B.Current_available_qty,B.Regular_price FROM Park_info A  LEFT JOIN Park_rooms_inventory B ON A.Park_id = B.Park_id  WHERE A.Park_id =? ;"; 


}
