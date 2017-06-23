package com.od;

import java.sql.Date;

public class ODParkDetailsService {
	
	
	String description;
	String maxPeople;
	String maxAdults;
	String maxKids;
	String currentAvailableQuantity;
	float currentPrice;
	String facilityTypeCode;
	String facilityType;
	String maxQty;
	float regularPrice;
	Date dateAdded;
	Date date;
	String facilityTypeTitle;
	String facilityInRoomFacilites;
	String facilityImage;
	
	int parkId;
	
	
	public String overviewText ;
	public String metro ;
	public String localArea;
	public String streetAddress;
	public String city;
	public String state;
	public String pin;
	public String name;
	
	public String details;
	
	public float odRating;

	
	
	public double latitude;
	public double longitude;
	public String typeString;
	public String natureString;
	public String subCategoryString;
	public String durationString;
	
	public String popularity;
	public float minCost1;
	public float minCost1People;
	public float minCost2;
	public float minCost2People ;
	
	public float specialOfferPercentage ;
	public float specialRate;
	public String photoUrl;
	public String amenitiesString;
	
	
	
	

	public ODParkDetailsService(String description, String maxPeople,
			String maxAdults, String maxKids, String currentAvailableQuantity,
			float currentPrice, String facilityTypeCode, String facilityType,
			String maxQty, float regularPrice, Date dateAdded, Date date,
			String facilityTypeTitle, String facilityInRoomFacilites,
			String facilityImage, int parkId, String overviewText, String metro, String localArea, String streetAddress, String city, String state, String pin, String name, String details, float odRating, double latitude, double longitude, String typeString, String natureString, String subCategoryString, String durationString, String popularity, float minCost1, float minCost1People, float minCost2, float minCost2People, float specialOfferPercentage, float specialRate, String photoUrl, String amenitiesString) {
		super();
		this.description = description;
		this.maxPeople = maxPeople;
		this.maxAdults = maxAdults;
		this.maxKids = maxKids;
		this.currentAvailableQuantity = currentAvailableQuantity;
		this.currentPrice = currentPrice;
		this.facilityTypeCode = facilityTypeCode;
		this.facilityType = facilityType;
		this.maxQty = maxQty;
		this.regularPrice = regularPrice;
		this.dateAdded = dateAdded;
		this.date = date;
		this.facilityTypeTitle = facilityTypeTitle;
		this.facilityInRoomFacilites = facilityInRoomFacilites;
		this.facilityImage = facilityImage;
		
		this.parkId=parkId;
		
		this.overviewText=overviewText;
		this.metro=metro;
		this.localArea=localArea;
		this.streetAddress=streetAddress;
		this.city=city;
		this.state=state;
		this.pin=pin;
		this.name=name;
		this.details=details;
		this.odRating=odRating;
		this.latitude=latitude;
		this.longitude=longitude;
		this.typeString=typeString;
		this.natureString=natureString;
		this.subCategoryString=subCategoryString;
		this.durationString=durationString;
		this.popularity=popularity;
		this.minCost1=minCost1;
		this.minCost1People=minCost1People;
		this.minCost2=minCost2;
		this.minCost2People=minCost2People;
		this.specialOfferPercentage=specialOfferPercentage;
		this.specialRate=specialRate;
		this.photoUrl=photoUrl;
		this.amenitiesString=amenitiesString;
	}



	
	
	public String getOverviewText() {
		return overviewText;
	}





	public void setOverviewText(String overviewText) {
		this.overviewText = overviewText;
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





	public String getPin() {
		return pin;
	}





	public void setPin(String pin) {
		this.pin = pin;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getDetails() {
		return details;
	}





	public void setDetails(String details) {
		this.details = details;
	}





	public float getOdRating() {
		return odRating;
	}





	public void setOdRating(float odRating) {
		this.odRating = odRating;
	}





	public double getLatitude() {
		return latitude;
	}





	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}





	public double getLongitude() {
		return longitude;
	}





	public void setLongitude(double longitude) {
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





	public float getMinCost1People() {
		return minCost1People;
	}





	public void setMinCost1People(float minCost1People) {
		this.minCost1People = minCost1People;
	}





	public float getMinCost2() {
		return minCost2;
	}





	public void setMinCost2(float minCost2) {
		this.minCost2 = minCost2;
	}





	public float getMinCost2People() {
		return minCost2People;
	}





	public void setMinCost2People(float minCost2People) {
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





	public String getPhotoUrl() {
		return photoUrl;
	}





	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}





	public String getAmenitiesString() {
		return amenitiesString;
	}





	public void setAmenitiesString(String amenitiesString) {
		this.amenitiesString = amenitiesString;
	}





	public int getParkId() {
		return parkId;
	}



	public void setParkId(int parkId) {
		this.parkId = parkId;
	}



	public String getFacilityTypeTitle() {
		return facilityTypeTitle;
	}



	public void setFacilityTypeTitle(String facilityTypeTitle) {
		this.facilityTypeTitle = facilityTypeTitle;
	}



	public String getFacilityInRoomFacilites() {
		return facilityInRoomFacilites;
	}



	public void setFacilityInRoomFacilites(String facilityInRoomFacilites) {
		this.facilityInRoomFacilites = facilityInRoomFacilites;
	}



	public String getFacilityImage() {
		return facilityImage;
	}



	public void setFacilityImage(String facilityImage) {
		this.facilityImage = facilityImage;
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



	

	public float getRegularPrice() {
		return regularPrice;
	}



	public void setRegularPrice(float regularPrice) {
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

	

	public float getCurrentPrice() {
		return currentPrice;
	}



	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}



	public ODParkDetailsService(){
		
	}
	

}
