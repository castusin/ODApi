package com.od;

public class ValidateOTPQuery {
	
	public static String SQL_VALIDATE_OPT =" select Registered_Phone_Number,time_stamp,delete_ind from OTP_table where Registered_Phone_Number=? and OTP=? and delete_ind=? "; 
	public static String SQL_GET_OTP = " SELECT Registered_Phone_Number,time_stamp,delete_ind,OTP FROM OTP_table WHERE time_stamp  >= NOW() - INTERVAL 10 MINUTE and Registered_Phone_Number = ? and delete_ind=? ";
	

}
