package com.od;
/**
 * Login Query
 * 
 * @author Castus Info Solutions
 *
 */
public class LoginQuery {
	
	public static String SQL_LOGIN = "select phone_number, username, password from Park_user_table where phone_number=? or username=? and password=?"; 
    
	public static String SQL_GETPASSWORD = "select password from Park_user_table where phone_number=?"; 
    
}
