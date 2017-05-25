package com.od;

import java.sql.Date;
import java.util.List;

public class ODGetParkDetailsModel {
	
	public String parkId;
	public String overviewText ;
	public String faq;
	public String photoUrl;
	public String name;
	public float odRating;
	public String metro ;
	public String localArea;
	public String streetAddress;
	public String city;
	public String state;
	public int pin;
	public float latitude;
	public float longitude;
	public String typeString;
	public String natureString;
	public String subCategoryString;
	public String durationString;
	public String maxPeople;
	
	public String popularity;
	public Float minCost1;
	public int minCost1People;
	public Float minCost2;
	public int minCost2People ;
	
	public Float specialOfferPercentage ;
	public Float specialRate;
	public String description;
	public String details;
	public String parkSubImages;
	public String amenitiesString;
	public List<ODParkDetailsService> parkDetails;
	
	public ODGetParkDetailsModel(String overviewText, String faq, String photoUrl, List<ODParkDetailsService> parkDetails, String parkId, String name, String metro, String localArea, String streetAddress, Float odRating, String city, String state, int pin, float latitude, float longitude, String typeString, String natureString, String subCategoryString, String durationString, String maxPeople, String popularity, Float minCost1, int minCost1People, Float minCost2, int minCost2People, Float specialOfferPercentage, Float specialRate, String description, String details, String imagefoldername, String parkSubImages, String amenitiesString ) {
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
		this.parkSubImages=parkSubImages;
		this.amenitiesString=amenitiesString;
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




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Float getOdRating() {
		return odRating;
	}




	public void setOdRating(Float odRating) {
		this.odRating = odRating;
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




	public int getPin() {
		return pin;
	}




	public void setPin(int pin) {
		this.pin = pin;
	}




	public float getLatitude() {
		return latitude;
	}




	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}




	public float getLongitude() {
		return longitude;
	}




	public void setLongitude(float longitude) {
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




	public float getMinCost1() {
		return minCost1;
	}




	public void setMinCost1(float minCost1) {
		this.minCost1 = minCost1;
	}




	public int getMinCost1People() {
		return minCost1People;
	}




	public void setMinCost1People(int minCost1People) {
		this.minCost1People = minCost1People;
	}




	public Float getMinCost2() {
		return minCost2;
	}




	public void setMinCost2(Float minCost2) {
		this.minCost2 = minCost2;
	}




	public int getMinCost2People() {
		return minCost2People;
	}




	public void setMinCost2People(int minCost2People) {
		this.minCost2People = minCost2People;
	}




	public float getSpecialOfferPercentage() {
		return specialOfferPercentage;
	}




	public void setSpecialOfferPercentage(float specialOfferPercentage) {
		this.specialOfferPercentage = specialOfferPercentage;
	}




	public float getSpecialRate() {
		return specialRate;
	}




	public void setSpecialRate(float specialRate) {
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




	public String getParkSubImages() {
		return parkSubImages;
	}




	public void setParkSubImages(String parkSubImages) {
		this.parkSubImages = parkSubImages;
	}




	public String getAmenitiesString() {
		return amenitiesString;
	}




	public void setAmenitiesString(String amenitiesString) {
		this.amenitiesString = amenitiesString;
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
