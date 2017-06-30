package com.od;

import java.util.Date;


public class GetRoomDetailsModel {
	//Facility_title,Facility_price,facility_type_code,Facility_quantity,Room_title,Room_price,Room_type_code,Room_quantity
	public String facilityType;
	public Date fromDate ;
	public Date toDate;
	public int quantity;
	public float totalPrice;
	public Date creationDate;
	public int parkId;
	
	
	String facilityTitle;
	float facilityPrice;
	int facilityQuantity;
	String facilityTypeCode;
	
	String roomTitle;
	float roomPrice;
	int roomQuantity;
	String roomTypeCode;
	public GetRoomDetailsModel(String facilityType, Date fromDate, Date toDate, int quantity, float totalPrice, Date creationDate, int parkId, String facilityTitle, float facilityPrice, String roomTypeCode, String facilityTypeCode, int facilityQuantity, String roomTitle, float roomPrice, int roomQuantity) {
		super();
		
		this.facilityType=facilityType;
		this.fromDate=fromDate;
		this.toDate=toDate;
		this.quantity=quantity;
		this.totalPrice=totalPrice;
		this.creationDate=creationDate;
		this.parkId=parkId;
		
		this.facilityTitle = facilityTitle;
		this.facilityPrice=facilityPrice;
		this.roomTypeCode=roomTypeCode;
		this.facilityTypeCode=facilityTypeCode;
		this.facilityQuantity=facilityQuantity;
		this.roomTitle = roomTitle;
		this.roomPrice=roomPrice;
		this.roomQuantity=roomQuantity;
	}
	
	
	public String getFacilityTitle() {
		return facilityTitle;
	}


	public void setFacilityTitle(String facilityTitle) {
		this.facilityTitle = facilityTitle;
	}


	public float getFacilityPrice() {
		return facilityPrice;
	}


	public void setFacilityPrice(float facilityPrice) {
		this.facilityPrice = facilityPrice;
	}


	public int getFacilityQuantity() {
		return facilityQuantity;
	}


	public void setFacilityQuantity(int facilityQuantity) {
		this.facilityQuantity = facilityQuantity;
	}


	public String getFacilityTypeCode() {
		return facilityTypeCode;
	}


	public void setFacilityTypeCode(String facilityTypeCode) {
		this.facilityTypeCode = facilityTypeCode;
	}


	public String getRoomTitle() {
		return roomTitle;
	}


	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}


	public float getRoomPrice() {
		return roomPrice;
	}


	public void setRoomPrice(float roomPrice) {
		this.roomPrice = roomPrice;
	}


	public int getRoomQuantity() {
		return roomQuantity;
	}


	public void setRoomQuantity(int roomQuantity) {
		this.roomQuantity = roomQuantity;
	}


	public String getRoomTypeCode() {
		return roomTypeCode;
	}


	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
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
