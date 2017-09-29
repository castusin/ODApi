package com.od;

public class UpdatePasswordServiceQuery {
	
	public static String SQL_UPDATEPASSWORD="UPDATE Park_user_table  set password =? where  phone_number=?" ;
	
	public static String SQL_VALIDATE_OPT =" select Email_id, Registered_Phone_Number,OTP from OTP_table where  Email_id=? or Registered_Phone_Number=? and OTP=? "; 
	
	public static String SQL_GETEMAIL =" select username from Park_user_table where  phone_number=? "; 
	
}


