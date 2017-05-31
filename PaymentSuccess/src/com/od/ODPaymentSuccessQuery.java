package com.od;

public class ODPaymentSuccessQuery {
	
	public static String SQL_GETPAYMENTSTATUS="UPDATE Park_current_reservation_det  set Status =? where Reservation_id=?" ;
	

	public static String SQL_GETUSEREMAILID = "SELECT A.email_id FROM User_table A  JOIN Park_current_reservation_hdr B ON A.User_id = B.User_id  WHERE B.Reservation_id =?"; 

	

}
//SELECT A.email_id FROM User_table A  JOIN Park_current_reservation_hdr B ON A.User_id = B.User_id  WHERE B.Reservation_id =? ;