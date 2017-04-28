package com.od;

public class ODGetCityDetailsQuery {

	public static String SQL_GETCITYDETAILS = "SELECT A.city_key,A.location_key,A.location_name,A.createdon,B.city_key,B.city_name FROM cast_localarea_table A JOIN cast_city_table B ON A.city_key = B.city_key WHERE A.city_key =?"; 

}
