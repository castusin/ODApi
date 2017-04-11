package com.od;


public class ODParkFacilitiesModel {
	
	String facilityTypeCode;
	String facilityTypeDescription;
	String ticketType;
	int maxQty;
	int currentAvailableQty;
	Float price;
	
	
	public ODParkFacilitiesModel(String facilityTypeCode, String facilityTypeDescription, String ticketType, int maxQty, int currentAvailableQty, Float price) {
		super();
		this.facilityTypeCode=facilityTypeCode;
		this.facilityTypeDescription=facilityTypeDescription;
		this.ticketType=ticketType;
		this.maxQty=maxQty;
		this.currentAvailableQty=currentAvailableQty;
		this.price=price;
		
	}
	
   public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	public int getCurrentAvailableQty() {
		return currentAvailableQty;
	}

	public void setCurrentAvailableQty(int currentAvailableQty) {
		this.currentAvailableQty = currentAvailableQty;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

public String getFacilityTypeCode() {
		return facilityTypeCode;
	}

	public void setFacilityTypeCode(String facilityTypeCode) {
		this.facilityTypeCode = facilityTypeCode;
	}

	public String getFacilityTypeDescription() {
		return facilityTypeDescription;
	}

	public void setFacilityTypeDescription(String facilityTypeDescription) {
		this.facilityTypeDescription = facilityTypeDescription;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

public ODParkFacilitiesModel(){
		
	}

}
