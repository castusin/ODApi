package com.od;

import java.sql.Date;

public class ODParkDetailsService {
	
	
	String description;
	String maxPeople;
	String maxAdults;
	String maxKids;
	String currentAvailableQuantity;
	String currentPrice;
	String facilityTypeCode;
	String facilityType;
	String maxQty;
	String regularPrice;
	Date dateAdded;
	Date date;
	
	public ODParkDetailsService(String description, String maxPeople, String maxAdults, String maxKids, String currentAvailableQuantity, String currentPrice, String facilityTypeCode, String facilityType, String maxQty, String regularPrice, Date dateAdded, Date date) {
		super();
		
		this.description=description;
		this.maxPeople=maxPeople;
		this.maxAdults=maxAdults;
		this.maxKids=maxKids;
		this.currentAvailableQuantity=currentAvailableQuantity;
		this.currentPrice=currentPrice;
		this.facilityTypeCode=facilityTypeCode;
		this.facilityType=facilityType;
		this.maxQty=maxQty;
		this.regularPrice=regularPrice;
		this.dateAdded=dateAdded;
		this.date=date;
	}
	
	

	public String getFacilityTypeCode() {
		return facilityTypeCode;
	}



	public void setFacilityTypeCode(String facilityTypeCode) {
		this.facilityTypeCode = facilityTypeCode;
	}



	public String getFacilityType() {
		return facilityType;
	}



	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
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



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
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
