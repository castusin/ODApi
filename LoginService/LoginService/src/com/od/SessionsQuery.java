package com.od;
/**
 * Session insert statement
 * 
 * @author Castus Info Solutions
 *
 */
public class SessionsQuery {
     public static String SQL_CREATE_SESSION ="insert into Session_data (User_id,Session_id,Time_stamp,Delete_ind)"+"values(?,?,?,?)"; 
	 public static String SQL_CREATE_DEVICE ="insert into User_Devices (User_id,Device_Token ,Status,Device_Type,DateTime,Device_id)"+"values(?,?,?,?,?,?)"; 	 
}
