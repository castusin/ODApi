package com.od;



public class PackageDetails {
	
	
	String facilityTitle;
	float facilityPrice;
	int facilityQuantity;
	String facilityTypeCode;
	
	String roomTitle;
	float roomPrice;
	int roomQuantity;
	String roomTypeCode;
	public PackageDetails(String facilityTitle, float facilityprice, int facilityQuantity, String roomTitle, float roomprice, int roomQuantity, String roomTypeCode, String facilityTypeCode, float roomPrice, float facilityPrice) {
		super();
		this.facilityTitle = facilityTitle;
		this.facilityPrice=facilityPrice;
		this.roomTypeCode=roomTypeCode;
		this.facilityTypeCode=facilityTypeCode;
		this.facilityQuantity=facilityQuantity;
		this.roomTitle = roomTitle;
		this.roomPrice=roomPrice;
		this.roomQuantity=roomQuantity;
	
	
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



	public String getRoomTypeCode() {
		return roomTypeCode;
	}



	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
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



	public PackageDetails(){
		
	}
	

}
