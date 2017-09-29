package com.od;

import java.sql.Date;
import java.util.List;

public class ODGetCategoriesModel {
	
	public String appId;
	public String parkType;
	public String parksubcategory;
	public int parkId;
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
	public double latitude;
	public double longitude;
	public String typeString;
	public String natureString;
	public String subCategoryString;
	public String durationString;
	public String maxPeople;
	public String popularity;
	public float minCost1;
	public int minCost1People;
	public float minCost2;
	public int minCost2People ;
	public float minCost3;
	public int minCost3People ;
	public float specialOfferPercentage ;
	public float specialRate;
	public String description;
	public String details;
	public String parkSubImages;
	public String amenitiesString;
	public float currentPrice;
	public String sponsoredFlag;
	public String facilitytypecode;
	public String tag;
	public Date createDate;
	
	public int localId;
	
	public Date updationDate;
	public String createdBy;
	public String updatedBy;
	public String videoLinks;
	public String policyText;
	public int stateId;
	public int cityId;
	public int discount;
	public String discountMode;
	public Date fromDate;
	public Date toDate;
	
	
	
	public List<ODParkDetailsService> parkDetails;
	
	public ODGetCategoriesModel(String overviewText, String faq, String photoUrl, List<ODParkDetailsService> parkDetails, int parkId, String name, String metro, String localArea, String streetAddress, Float odRating, String city, String state, int pin, double latitude, double longitude, String typeString, String natureString, String subCategoryString, String durationString, String maxPeople, String popularity, Float minCost1, int minCost1People, Float minCost2, int minCost2People, Float specialOfferPercentage, Float specialRate, String description, String details, String imagefoldername, String parkSubImages, String amenitiesString, float minCost3, int minCost3People, float currentPrice, String appId, String parkType, String parksubcategory, String facilitytypecode, String sponsoredFlag, String tag, Date createDate, int localId, Date updationDate, String createdBy, String updatedBy, String videoLinks, String policyText, int stateId, int cityId, int discount, String discountMode, Date fromDate, Date toDate ) {
		super();
		
		this.appId=appId;
		this.parkType=parkType;
		this.parksubcategory=parksubcategory;
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
		this.minCost3=minCost3;
		this.minCost3People=minCost3People;
		this.currentPrice=currentPrice;
		this.facilitytypecode=facilitytypecode;
		this.sponsoredFlag=sponsoredFlag;
		this.tag=tag;
		this.createDate=createDate;
		
		
		this.updationDate=updationDate;
		this.createdBy=createdBy;
		this.updatedBy=updatedBy;
		this.videoLinks=videoLinks;
		this.policyText=policyText;
		this.stateId=stateId;
		this.cityId=cityId;
		this.discount=discount;
		this.discountMode=discountMode;
		this.fromDate=fromDate;
		this.toDate=toDate;
		
		
		this.localId=localId;
	}
	
	
	public Date getUpdationDate() {
		return updationDate;
	}


	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public String getVideoLinks() {
		return videoLinks;
	}


	public void setVideoLinks(String videoLinks) {
		this.videoLinks = videoLinks;
	}


	public String getPolicyText() {
		return policyText;
	}


	public void setPolicyText(String policyText) {
		this.policyText = policyText;
	}


	public int getStateId() {
		return stateId;
	}


	public void setStateId(int stateId) {
		this.stateId = stateId;
	}


	public int getCityId() {
		return cityId;
	}


	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public String getDiscountMode() {
		return discountMode;
	}


	public void setDiscountMode(String discountMode) {
		this.discountMode = discountMode;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	public int getLocalId() {
		return localId;
	}


	public void setLocalId(int localId) {
		this.localId = localId;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public String getSponsoredFlag() {
		return sponsoredFlag;
	}


	public void setSponsoredFlag(String sponsoredFlag) {
		this.sponsoredFlag = sponsoredFlag;
	}


	public String getFacilitytypecode() {
		return facilitytypecode;
	}


	public void setFacilitytypecode(String facilitytypecode) {
		this.facilitytypecode = facilitytypecode;
	}


	public String getParkType() {
		return parkType;
	}


	public void setParkType(String parkType) {
		this.parkType = parkType;
	}


	public String getParksubcategory() {
		return parksubcategory;
	}


	public void setParksubcategory(String parksubcategory) {
		this.parksubcategory = parksubcategory;
	}


	public String getAppId() {
		return appId;
	}


	public void setAppId(String appId) {
		this.appId = appId;
	}


	public float getCurrentPrice() {
		return currentPrice;
	}


	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}


	public List<ODParkDetailsService> getParkDetails() {
		return parkDetails;
	}


	public void setParkDetails(List<ODParkDetailsService> parkDetails) {
		this.parkDetails = parkDetails;
	}


	public float getMinCost3() {
		return minCost3;
	}


	public void setMinCost3(float minCost3) {
		this.minCost3 = minCost3;
	}


	public int getMinCost3People() {
		return minCost3People;
	}


	public void setMinCost3People(int minCost3People) {
		this.minCost3People = minCost3People;
	}


	public String getAmenitiesString() {
		return amenitiesString;
	}


	public void setAmenitiesString(String amenitiesString) {
		this.amenitiesString = amenitiesString;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public int getMinCost1People() {
		return minCost1People;
	}


	public void setMinCost1People(int minCost1People) {
		this.minCost1People = minCost1People;
	}


	public void setMinCost2People(int minCost2People) {
		this.minCost2People = minCost2People;
	}


	public Float getMinCost2() {
		return minCost2;
	}


	public void setMinCost2(Float minCost2) {
		this.minCost2 = minCost2;
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

	public String getParkSubImages() {
		return parkSubImages;
	}


	public void setParkSubImages(String parkSubImages) {
		this.parkSubImages = parkSubImages;
	}


	public int getMinCost2People() {
		return minCost2People;
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

	public Float getOdRating() {
		return odRating;
	}


	public void setOdRating(Float odRating) {
		this.odRating = odRating;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}


	

	public int getParkId() {
		return parkId;
	}


	public void setParkId(int parkId) {
		this.parkId = parkId;
	}


	public void setOdRating(float odRating) {
		this.odRating = odRating;
	}


	public void setMinCost1(float minCost1) {
		this.minCost1 = minCost1;
	}


	public void setMinCost2(float minCost2) {
		this.minCost2 = minCost2;
	}


	public void setSpecialOfferPercentage(float specialOfferPercentage) {
		this.specialOfferPercentage = specialOfferPercentage;
	}


	public void setSpecialRate(float specialRate) {
		this.specialRate = specialRate;
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


	


	public ODGetCategoriesModel(){
		
	}

}
