package com.od;


public class RequestOTPQuery {
	
	public static String SQL_REQUEST_OPT ="insert into OTP_table(Registered_Phone_Number,OTP,time_stamp,delete_ind)"+"values(?,?,?,?)"; 
	
	public static String SQL_CHECKEMAILID = " select phone_number from Park_user_table where phone_number=? "; 
	
}