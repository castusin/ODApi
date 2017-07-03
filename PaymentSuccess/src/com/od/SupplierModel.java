
package com.od;

public class SupplierModel {
	
	
	public String createdBySup;
	public String createdByPark;
	public int ParkId;
	public int reservationId;
	public String emailId;
	public String cell;
	public String land;
	public SupplierModel(String createdByPark, String createdBySup, int ParkId, int reservationId, String emailId, String cell, String land) {
		super();
		
		this.createdByPark=createdByPark;
		this.createdBySup=createdBySup;
		this.ParkId=ParkId;
		this.reservationId=reservationId;
		this.emailId=emailId;
		this.cell=cell;
		this.land=land;
	}
	
	


	public String getCell() {
		return cell;
	}




	public void setCell(String cell) {
		this.cell = cell;
	}




	public String getLand() {
		return land;
	}




	public void setLand(String land) {
		this.land = land;
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
