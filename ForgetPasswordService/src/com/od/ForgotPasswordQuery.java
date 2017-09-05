package com.od;

public class ForgotPasswordQuery {
	
	public static String SQL_FORGOT_OTP ="insert into OTP_table(Registered_Phone_Number,OTP,time_stamp,delete_ind,Email_id)"+"values(?,?,?,?,?)"; 
	
	public static String SQL_CHECKEMAILID = " select username,phone_number from Park_user_table where username=? or phone_number=? "; 
	

}
