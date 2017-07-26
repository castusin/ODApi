package com.od;
/**
 * Login Query
 * 
 * @author Castus Info Solutions
 *
 */
public class LoginQuery {
	
	public static String SQL_LOGIN = "select userid,first_name,last_name,username,phone_number, user_type,google_fb_id,profile_pic_url,user_gender,user_role,password,creation_date,created_by,updation_date,updated_by,password_last_changed_on,last_login_datetime from Park_user_table where phone_number=? or username=? and password=?"; 
    
	public static String SQL_GETPASSWORD = "select password from Park_user_table where phone_number=? or username=?"; 
	
	public static String SQL_UPDATELOGIN="UPDATE Park_user_table  set last_login_datetime =? where  phone_number=? or username=?" ;
	
    
}
