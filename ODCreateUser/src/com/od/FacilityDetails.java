package com.od;



public class FacilityDetails {
	
	
	String facilityType;
	float price;
	int quantity;
	

	public FacilityDetails(String facilityType, float price, int quantity) {
		super();
		this.facilityType = facilityType;
		this.price=price;
		this.quantity=quantity;
	
	}





	public int getQuantity() {
		return quantity;
	}





	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





	public String getFacilityType() {
		return facilityType;
	}





	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}





	public float getPrice() {
		return price;
	}





	public void setPrice(float price) {
		this.price = price;
	}





	public FacilityDetails(){
		
	}
	

}
