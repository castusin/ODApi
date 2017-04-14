package com.od;

import java.sql.Date;
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
	public String latitude;
	public String longitude;
	public String typeString;
	public String natureString;
	public String subCategoryString;
	public String durationString;
	public String maxPeople;
	
	public String popularity;
	public Float minCost1;
	public Float minCost1People;
	public Float minCost2;
	public Float minCost2People ;
	
	public Float specialOfferPercentage ;
	public Float specialRate;
	public String description;
	public String details;
	public String imagefoldername;
	public List<ODParkDetailsService> parkDetails;
	
	public ODGetParkDetailsModel(String overviewText, String faq, String photoUrl, List<ODParkDetailsService> parkDetails, String parkId, String name, String metro, String localArea, String streetAddress, int odRating, String city, String state, int pin, String latitude, String longitude, String typeString, String natureString, String subCategoryString, String durationString, String maxPeople, String popularity, Float minCost1, Float minCost1People, Float minCost2, Float minCost2People, Float specialOfferPercentage, Float specialRate, String description, String details, String imagefoldername ) {
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
		this.latitude= latitude;
		this.longitude= longitude;
		this.typeString= typeString;
		this.natureString= natureString;
		this.subCategoryString= subCategoryString;
		this.durationString= durationString;
		this.maxPeople= maxPeople;
		
		this.popularity= popularity;
		this.minCost1= minCost1;
		this.minCost1People= minCost1People;
		this.minCost2= minCost2;
		this.minCost2People= minCost2People ;
		
		this.specialOfferPercentage= specialOfferPercentage ;
		this.specialRate= specialRate;
		this.description= description;
		this.details= details;
		this.imagefoldername=imagefoldername;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getTypeString() {
		return typeString;
	}


	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}


	public String getNatureString() {
		return natureString;
	}


	public void setNatureString(String natureString) {
		this.natureString = natureString;
	}


	public String getSubCategoryString() {
		return subCategoryString;
	}


	public void setSubCategoryString(String subCategoryString) {
		this.subCategoryString = subCategoryString;
	}


	public String getDurationString() {
		return durationString;
	}


	public void setDurationString(String durationString) {
		this.durationString = durationString;
	}


	public String getMaxPeople() {
		return maxPeople;
	}


	public void setMaxPeople(String maxPeople) {
		this.maxPeople = maxPeople;
	}


	public String getPopularity() {
		return popularity;
	}


	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}


	public Float getMinCost1() {
		return minCost1;
	}


	public void setMinCost1(Float minCost1) {
		this.minCost1 = minCost1;
	}


	public Float getMinCost1People() {
		return minCost1People;
	}


	public void setMinCost1People(Float minCost1People) {
		this.minCost1People = minCost1People;
	}


	public Float getMinCost2() {
		return minCost2;
	}


	public void setMinCost2(Float minCost2) {
		this.minCost2 = minCost2;
	}


	public Float getMinCost2People() {
		return minCost2People;
	}


	public void setMinCost2People(Float minCost2People) {
		this.minCost2People = minCost2People;
	}


	public Float getSpecialOfferPercentage() {
		return specialOfferPercentage;
	}


	public void setSpecialOfferPercentage(Float specialOfferPercentage) {
		this.specialOfferPercentage = specialOfferPercentage;
	}


	public Float getSpecialRate() {
		return specialRate;
	}


	public void setSpecialRate(Float specialRate) {
		this.specialRate = specialRate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public String getImagefoldername() {
		return imagefoldername;
	}


	public void setImagefoldername(String imagefoldername) {
		this.imagefoldername = imagefoldername;
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
