package com.od;

public class ODCreateUserQuery {
	
	
	public static String SQL_USERTABLE="insert into User_table (User_id,first_name,last_name,email_id,phoneno1,phone2,address1,address2,city,state,pin_code,Creation_date)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";     

	public static String SQL_USERTABLE2="insert into Park_current_reservation_det (Reservation_id,park_id,facility_type_code,from_date,to_date,qty,total_price,Status,Creation_date,User_type)"+"values(?,?,?,?,?,?,?,?,?,?)";     

	public static String SQL_USERTABLE3="insert into Park_current_reservation_hdr (User_id,Reservation_id,Transaction_date,Creation_date)"+"values(?,?,?,?)";     

	//public static String SQL_GETFACILITYDETAILS ="SELECT A.Facility_type_code,A.Regular_price FROM Park_facility_inventory_pricing A JOIN Park_current_reservation_det B ON A.Park_id = B.Park_id  WHERE A.Park_id =?" ;
	
	//public static String SQL_GETFACILITYDETAILS ="SELECT Facility_type_code,Regular_price FROM Park_facility_inventory_pricing  WHERE Park_id =?" ;
	
	public static String SQL_CREATEFACILITYDETAILS="insert into Park_facility_inventory_pricing (park_id,Facility_type_code,Regular_price,Max_qty)"+"values(?,?,?,?)";     

}
