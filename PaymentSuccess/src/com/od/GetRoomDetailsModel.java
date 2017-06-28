package com.od;

import java.util.Date;


public class GetRoomDetailsModel {
	
	public String facilityType;
	public Date fromDate ;
	public Date toDate;
	public int quantity;
	public float totalPrice;
	public Date creationDate;
	public int parkId;
	
	public GetRoomDetailsModel(String facilityType, Date fromDate, Date toDate, int quantity, float totalPrice, Date creationDate, int parkId) {
		super();
		
		this.facilityType=facilityType;
		this.fromDate=fromDate;
		this.toDate=toDate;
		this.quantity=quantity;
		this.totalPrice=totalPrice;
		this.creationDate=creationDate;
		this.parkId=parkId;
	}
	
	
	public int getParkId() {
		return parkId;
	}


	public void setParkId(int parkId) {
		this.parkId = parkId;
	}


	public String getFacilityType() {
		return facilityType;
	}


	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public float getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public GetRoomDetailsModel(){
		
	}

}
