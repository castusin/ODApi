package com.od;

public class ODGetCityDetailsQuery {

	public static String SQL_GETCITYDETAILS = "SELECT city_key,location_key,location_name,Creation_date FROM cast_localarea_table  WHERE city_key =?";
	
}