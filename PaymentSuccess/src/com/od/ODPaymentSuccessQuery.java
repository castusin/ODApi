package com.od;

public class ODPaymentSuccessQuery {
	
	public static String SQL_GETPAYMENTSTATUS="UPDATE Park_current_reservation_det  set Status =? where Reservation_id=?" ;
	

	public static String SQL_GETUSEREMAILID = "SELECT A.email_id, A.first_name FROM User_table A  JOIN Park_current_reservation_hdr B ON A.User_id = B.User_id  WHERE B.Reservation_id =?"; 

	//public static String SQL_GETROOMDETAILS = "SELECT park_id,facility_type_code,Facility_title,Facility_price,Facility_quantity,Room_title,Room_price,Room_type_code,Room_quantity,from_date,to_date,total_price,Creation_date FROM Park_current_reservation_det WHERE Reservation_id =? "; 

	public static String SQL_GETROOMDETAILS = "SELECT park_id,type,type_code,Title,Price,Quantity,from_date,to_date,total_price,Creation_date FROM Park_current_reservation_det WHERE Reservation_id =? "; 

	
	//public static String SQL_GETAVAILABILITY = "SELECT A.Park_id,A.Facility_type_code, A.Current_available_qty FROM Park_current_pricing_availability A  JOIN Park_current_reservation_det B ON A.Park_id = B.park_id and A.Facility_type_code=B.facility_type_code "; 
	//public static String SQL_GETAVAILABILITY = "SELECT A.Park_id,A.Room_type_code, A.Current_available_qty FROM Park_current_pricing_availability A  JOIN Park_current_reservation_det B ON A.Park_id = B.park_id and A.Room_type_code=B.Room_type_code  where Reservation_id = ? "; 

	 //public static String SQL_UPDATEAVAILABILITY="UPDATE Park_current_pricing_availability  set Current_available_qty =? where Park_id=? and Facility_type_code=?" ;
	
	//public static String SQL_UPDATEAVAILABILITY="UPDATE Park_current_pricing_availability  set Current_available_qty =? where Park_id=? and Room_type_code=?" ;
	
	 public static String SQL_GETSUPPLIERMAIL = "SELECT A.Email_ID FROM park_suppliers A  JOIN Park_info B ON A.Supplier_Key = B.Created_by  WHERE B.Park_id =?" ;

	 
	 public static String SQL_GETAVAILABILITY = "SELECT A.Park_id,A.Room_type_code, A.Current_available_qty , B.Quantity FROM Park_current_pricing_availability A , Park_current_reservation_det B where A.Park_id = B.park_id and A.Room_type_code=B.type_code and B.Reservation_id = ? and A.Date between B.from_date and B.to_date";
	 
	 
	 public static String SQL_UPDATEAVAILABILITY=" update Park_current_pricing_availability A , Park_current_reservation_det B set A.Current_available_qty = A.Current_available_qty-B.Quantity	 where A.Park_id = B.park_id and A.Room_type_code=B.type_code and B.Reservation_id = ? and A.Date between B.from_date and B.to_date";
	 
	 public static String SQL_GETPARKADDRESS = "SELECT Street_address,City,State,PIN,Name FROM Park_info WHERE Park_id =? "; 

}
//SELECT A.email_id FROM park_suppliers A  JOIN Park_info B ON A.CreatedBy = B.Created_by  WHERE B.Park_id =? ;


/*SELECT A.Park_id,A.Room_type_code, A.Current_available_qty , B.Quantity
FROM Park_current_pricing_availability A , 
 Park_current_reservation_det B 
where A.Park_id = B.park_id and A.Room_type_code=B.type_code  
and B.Reservation_id = 'e6ea7147' and A.Date between B.from_date and B.to_date;*/ 



/*update Park_current_pricing_availability A , 
Park_current_reservation_det B set A.Current_available_qty = A.Current_available_qty-B.Quantity
where A.Park_id = B.park_id and A.Room_type_code=B.type_code  
and B.Reservation_id = 'e6ea7147' and A.Date between B.from_date and B.to_date;*/


