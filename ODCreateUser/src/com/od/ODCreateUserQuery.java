package com.od;

public class ODCreateUserQuery {
	
	
	public static String SQL_USERTABLE="insert into User_table (User_id,first_name,last_name,email_id,phoneno1,phone2,address1,address2,city,state,pin_code,Creation_date)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";     

	public static String SQL_USERTABLE2="insert into Park_current_reservation_det (Reservation_id,park_id,User_type,Facility_title,Facility_price,facility_type_code,Facility_quantity,Room_title,Room_price,Room_type_code,Room_quantity,from_date,to_date,total_price,Status,Creation_date)"+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";     
//facilitytitle,facilityprice,facilitycode,facilityQuantity,roomtitle,roomprice,roomcode,roomQuantity,fromDate,toDate,totalPrice,status,createDate);
	
	public static String SQL_USERTABLE3="insert into Park_current_reservation_hdr (User_id,Reservation_id,Transaction_date,Creation_date)"+"values(?,?,?,?)";     

	//public static String SQL_GETFACILITYDETAILS ="SELECT A.Facility_type_code,A.Regular_price FROM Park_facility_inventory_pricing A JOIN Park_current_reservation_det B ON A.Park_id = B.Park_id  WHERE A.Park_id =?" ;
	
	//public static String SQL_GETFACILITYDETAILS ="SELECT Facility_type_code,Regular_price FROM Park_facility_inventory_pricing  WHERE Park_id =?" ;
	
	//public static String SQL_CREATEFACILITYDETAILS="insert into Park_facility_inventory_pricing (park_id,Facility_type_code,Regular_price,Max_qty)"+"values(?,?,?,?)";     

	//public static String SQL_CREATEROOMDETAILS="insert into Park_facility_inventory_pricing (park_id,Room_type_code,Regular_price,Max_qty)"+"values(?,?,?,?)";     

	
	public static String SQL_CREATEPACKAGEDETAILS="insert into Park_current_reservation_det()"+"values()";
}
//reservationId,parkId,userType,facilitytitle,facilityprice,facilitycode,roomtitle,roomprice,roomQuantity,fromDate,toDate,totalPrice,status,createDate