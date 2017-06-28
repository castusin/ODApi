
package com.od;

public class SupplierModel {
	
	
	public String createdBySup;
	public String createdByPark;
	public int ParkId;
	public int reservationId;
	public String emailId;
	public SupplierModel(String createdByPark, String createdBySup, int ParkId, int reservationId, String emailId) {
		super();
		
		this.createdByPark=createdByPark;
		this.createdBySup=createdBySup;
		this.ParkId=ParkId;
		this.reservationId=reservationId;
		this.emailId=emailId;
	}
	
	


	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	public String getCreatedBySup() {
		return createdBySup;
	}




	public void setCreatedBySup(String createdBySup) {
		this.createdBySup = createdBySup;
	}




	public String getCreatedByPark() {
		return createdByPark;
	}




	public void setCreatedByPark(String createdByPark) {
		this.createdByPark = createdByPark;
	}




	public int getParkId() {
		return ParkId;
	}




	public void setParkId(int parkId) {
		ParkId = parkId;
	}




	public int getReservationId() {
		return reservationId;
	}




	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}




	public SupplierModel(){
		
	}

}
