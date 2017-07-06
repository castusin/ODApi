package com.od;

public class ODCreateUserQuery {
	
	
	public static String SQL_USERTABLE="insert into User_table (User_id,first_name,last_name,email_id,phoneno1,phone2,address1,address2,city,state,pin_code,Creation_date)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";     

	public static String SQL_USERTABLE2="insert into Park_current_reservation_det (Reservation_id,park_id,Title,Price,type_code,Quantity,type,from_date,to_date,total_price,Status,Creation_date)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";     
	
	public static String SQL_USERTABLE3="insert into Park_current_reservation_hdr (User_id,Reservation_id,Transaction_date,Creation_date)"+"values(?,?,?,?)";     

	public static String SQL_CREATEPACKAGEDETAILS="insert into Park_current_reservation_det()"+"values()";
	
	public static String SQL_GETAVAILABILITY = "SELECT A.Park_id,A.Room_type_code, A.Current_available_qty , B.Quantity FROM Park_current_pricing_availability A , Park_current_reservation_det B where A.Park_id = B.park_id and A.Room_type_code=B.type_code and A.Park_id = ? and A.Date between B.from_date and B.to_date";
	
}
