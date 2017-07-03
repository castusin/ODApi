package com.od;

import java.util.Date;


public class GetRoomDetailsModel {
	//Facility_title,Facility_price,facility_type_code,Facility_quantity,Room_title,Room_price,Room_type_code,Room_quantity
	
	public Date fromDate ;
	public Date toDate;
	public int quantity;
	public float totalPrice;
	public Date creationDate;
	public int parkId;
	String title;
	float price;
	String typeCode;
	String type;
	
	public GetRoomDetailsModel(String facilityType, Date fromDate, Date toDate, int quantity, float totalPrice, Date creationDate, int parkId, String facilityTitle, float facilityPrice, String roomTypeCode, String facilityTypeCode, int facilityQuantity, String roomTitle, float roomPrice, int roomQuantity, String title, float price, String type, String typeCode) {
		super();
		
		
		this.fromDate=fromDate;
		this.toDate=toDate;
		this.quantity=quantity;
		this.totalPrice=totalPrice;
		this.creationDate=creationDate;
		this.parkId=parkId;
		
		this.title = title;
		this.price=price;
		this.type=type;
		this.typeCode=typeCode;
		
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




	public int getParkId() {
		return parkId;
	}




	public void setParkId(int parkId) {
		this.parkId = parkId;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public float getPrice() {
		return price;
	}




	public void setPrice(float price) {
		this.price = price;
	}




	public String getTypeCode() {
		return typeCode;
	}




	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public GetRoomDetailsModel(){
		
	}

}
