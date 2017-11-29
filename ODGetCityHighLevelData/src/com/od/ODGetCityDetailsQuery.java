package com.od;

public class ODGetCityDetailsQuery {

	public static String SQL_GETLOCALAREADETAILS = "SELECT city_key,location_key,location_name FROM cast_localarea_table  WHERE city_key =?";
	public static String SQL_GETCITYDETAILS = "SELECT P.Parktype,P.Name,P.Park_id,L.city_key,L.location_key,L.location_name FROM Park_info P JOIN cast_localarea_table L ON P.Local_area = L.location_name WHERE L.city_key = ?";
	
}


