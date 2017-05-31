
package com.od;


public class ODPaymentSuccessModel {
	
	public String status;
	public int reservationId ;
	public String emailId;

	
	public ODPaymentSuccessModel(String status, int reservationId, String emailId) {
		super();
		
		this.status=status;
		this.reservationId=reservationId;
		this.emailId=emailId;

	}
	
	


	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public int getReservationId() {
		return reservationId;
	}




	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}




	public ODPaymentSuccessModel(){
		
	}

}
