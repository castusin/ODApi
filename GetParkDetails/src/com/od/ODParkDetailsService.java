package com.od;

public class ODParkDetailsService {
	
	String roomType;
	String description;
	String maxPeople;
	String maxAdults;
	String maxKids;
	String currentAvailableQuantity;
	String currentPrice;
	
	
	public ODParkDetailsService(String roomType, String description, String maxPeople, String maxAdults, String maxKids, String currentAvailableQuantity, String currentPrice) {
		super();
		this.roomType = roomType;
		this.description=description;
		this.maxPeople=maxPeople;
		this.maxAdults=maxAdults;
		this.maxKids=maxKids;
		this.currentAvailableQuantity=currentAvailableQuantity;
		this.currentPrice=currentPrice;
		
		
	}
	
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(String maxPeople) {
		this.maxPeople = maxPeople;
	}

	public String getMaxAdults() {
		return maxAdults;
	}

	public void setMaxAdults(String maxAdults) {
		this.maxAdults = maxAdults;
	}

	public String getMaxKids() {
		return maxKids;
	}

	public void setMaxKids(String maxKids) {
		this.maxKids = maxKids;
	}

	public String getCurrentAvailableQuantity() {
		return currentAvailableQuantity;
	}

	public void setCurrentAvailableQuantity(String currentAvailableQuantity) {
		this.currentAvailableQuantity = currentAvailableQuantity;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public ODParkDetailsService(){
		
	}
	

}
