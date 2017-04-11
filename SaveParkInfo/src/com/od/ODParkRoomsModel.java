package com.od;

import java.sql.Date;

public class ODParkRoomsModel {
	
	String roomTypeCode;
	String rommTypeDescription;
	String maxPeople;
	String maxAdults;
	String maxKids;
	String maxQty;
	String regularPrice;
	Date dateAdded;
	
	
	
	public ODParkRoomsModel(String roomTypeCode, String rommTypeDescription, String maxPeople, String maxKids, String maxAdults, String maxQty, String regularPrice, Date dateAdded) {
		super();
		this.roomTypeCode=roomTypeCode;
		this.rommTypeDescription=rommTypeDescription;
		this.maxPeople=maxPeople;
		this.maxAdults=maxAdults;
		this.maxKids=maxKids;
		this.maxQty=maxQty;
		this.regularPrice=regularPrice;
		this.dateAdded=dateAdded;
	}
	
	
	public String getRoomTypeCode() {
		return roomTypeCode;
	}


	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}


	public String getRommTypeDescription() {
		return rommTypeDescription;
	}


	public void setRommTypeDescription(String rommTypeDescription) {
		this.rommTypeDescription = rommTypeDescription;
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


	public String getMaxQty() {
		return maxQty;
	}


	public void setMaxQty(String maxQty) {
		this.maxQty = maxQty;
	}


	public String getRegularPrice() {
		return regularPrice;
	}


	public void setRegularPrice(String regularPrice) {
		this.regularPrice = regularPrice;
	}


	


	public Date getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}


	public ODParkRoomsModel(){
		
	}

}
