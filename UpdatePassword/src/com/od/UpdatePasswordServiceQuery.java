package com.od;

public class UpdatePasswordServiceQuery {
	
	public static String SQL_UPDATEPASSWORD="UPDATE Park_user_table  set password =? where username=?" ;
	
	public static String SQL_VALIDATE_OPT =" select Email_id, OTP from OTP_table where  Email_id=? and OTP=? "; 
	
}


