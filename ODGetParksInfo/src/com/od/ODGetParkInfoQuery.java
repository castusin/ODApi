package com.od;

public class ODGetParkInfoQuery {
	
	public static String SQL_GETPARKSINFO = "select * from Park_info where Local_area=? and Is_active=0";

	public static String SQL_GETDATES = "select Date from Park_current_pricing_availability where Date=? "; 

}


