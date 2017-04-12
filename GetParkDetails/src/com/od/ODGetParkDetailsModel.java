package com.od;

import java.util.List;

public class ODGetParkDetailsModel {
	
	public String parkId;
	public String overviewText ;
	public String faq;
	public String photoUrl;
	public String name;
	public int odRating;
	public String metro ;
	public String localArea;
	public String streetAddress;
	public String city;
	public String state;
	public int pin;
	public List<ODParkDetailsService> parkDetails;
	
	public ODGetParkDetailsModel(String overviewText, String faq, String photoUrl, List<ODParkDetailsService> parkDetails, String parkId, String name, String metro, String localArea, String streetAddress, int odRating, String city, String state, int pin ) {
		super();
		
		this.parkId=parkId;
		this.overviewText=overviewText;
		this.faq=faq;
		this.photoUrl=photoUrl;
		this.parkDetails=parkDetails;
		this.name=name;
		this.odRating=odRating;
		this.metro=metro;
		this.localArea=localArea;
		this.streetAddress=streetAddress;
		this.city=city;
		this.state=state;
		this.pin=pin;
		
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

	public String getMetro() {
		return metro;
	}


	public void setMetro(String metro) {
		this.metro = metro;
	}


	public String getLocalArea() {
		return localArea;
	}


	public void setLocalArea(String localArea) {
		this.localArea = localArea;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getOdRating() {
		return odRating;
	}


	public void setOdRating(int odRating) {
		this.odRating = odRating;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}


	public String getParkId() {
		return parkId;
	}


	public void setParkId(String parkId) {
		this.parkId = parkId;
	}


	public String getOverviewText() {
		return overviewText;
	}


	public void setOverviewText(String overviewText) {
		this.overviewText = overviewText;
	}


	public String getFaq() {
		return faq;
	}


	public void setFaq(String faq) {
		this.faq = faq;
	}


	public String getPhotoUrl() {
		return photoUrl;
	}


	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}


	public List<ODParkDetailsService> getParkDetails() {
		return parkDetails;
	}


	public void setParkDetails(List<ODParkDetailsService> parkDetails) {
		this.parkDetails = parkDetails;
	}


	public ODGetParkDetailsModel(){
		
	}

}
