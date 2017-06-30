
package com.od;


public class ODPaymentSuccessModel {
	
	public String status;
	public String reservationId ;
	public String emailId;
	public String firstName;
	
	
	public ODPaymentSuccessModel(String status, String reservationId, String emailId, String firstName) {
		super();
		
		this.status=status;
		this.reservationId=reservationId;
		this.emailId=emailId;
		this.firstName=firstName;
	}
	
	


	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
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


	public String getReservationId() {
		return reservationId;
	}




	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}




	public ODPaymentSuccessModel(){
		
	}

}
