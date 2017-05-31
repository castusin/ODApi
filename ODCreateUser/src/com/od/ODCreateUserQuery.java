package com.od;

public class ODCreateUserQuery {
	
	
	public static String SQL_USERTABLE="insert into User_table (User_id,first_name,last_name,email_id,phoneno1,phone2,address1,address2,city,state,pin_code,Creation_date)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";     

	public static String SQL_USERTABLE2="insert into Park_current_reservation_det (Reservation_id,park_id,facility_type_code,from_date,to_date,qty,total_price,Status,Creation_date,User_type)"+"values(?,?,?,?,?,?,?,?,?,?)";     

	public static String SQL_USERTABLE3="insert into Park_current_reservation_hdr (User_id,Reservation_id,Transaction_date,Creation_date)"+"values(?,?,?,?)";     

}
