package com.od;

public class ODParkUserCheckQuery {
	
	//public static String SQL_CHECKEMAILID = " select username from Park_user_table where username=? "; 
	
	public static String SQL_CHECKEMAILID = "select userid,first_name,last_name,username,phone_number, user_type,google_fb_id,profile_pic_url,user_gender,user_role,password,creation_date,created_by,updation_date,updated_by,password_last_changed_on,last_login_datetime from Park_user_table where  username=? "; 

	

}
