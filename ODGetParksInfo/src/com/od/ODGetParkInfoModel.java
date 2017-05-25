package com.od;
import java.sql.Date;
import java.util.List;

public class ODGetParkInfoModel {
	
	public String appId;
	public String parktype ;
	public String parkSubcategory ;
	public String metro ;
	public String localArea;
	public String streetAddress;
	public String city;
	public String state;
	public String pin;
	public String name;
	public String description;
	public String details;
	public int parkId;
	public float odRating;
	public String sponsoredFeaturedFlag ;
	public String overviewText ;
	public String faq;
	public float latitude;
	public float longitude;
	public String typeString;
	public String natureString;
	public String subCategoryString;
	public String durationString;
	public String maxPeople;
	public Date dateAdded;
	public String popularity;
	public Float minCost1;
	public Float minCost1People;
	public Float minCost2;
	public Float minCost2People ;
	public Float minCost3 ;
	public Float minCost3People;
	public Float specialOfferPercentage ;
	public Float specialRate;
	public String photoUrl;
	public String imagefoldername;
	public String tagName;
	
	public ODGetParkInfoModel(String appId, String parktype, String parkSubtype, String metro, String localArea, String streetAddress, String city, String state, String pin, String name, String description, String details, int parkId, float odRating, String sponsoredFeaturedFlag, String overviewText, String faq, float latitude, float longitude, String typeString, String natureString, String subCategoryString, String durationString, String maxPeople, Date dateAdded, Float minCost1, String popularity, Float minCost1People, Float minCost2, Float minCost2People, Float minCost3, Float minCost3People, Float specialOfferPercentage, Float specialRate, String photoUrl, String parkSubcategory, String imagefoldername, String tagName ) {
		super();
		this.appId= appId;
		this.parktype= parktype ;
		this.parkSubcategory= parkSubcategory ;
		this.metro= metro ;
		this.localArea= localArea;
		this.streetAddress= streetAddress;
		this.city= city;
		this.state= state;
		this.pin= pin;
		this.name= name;
		this.description= description;
		this.details= details;
		this.parkId= parkId;
		this.odRating= odRating;
		this.sponsoredFeaturedFlag= sponsoredFeaturedFlag ;
		this.overviewText= overviewText ;
		this.faq= faq;
		this.latitude= latitude;
		this.longitude= longitude;
		this.typeString= typeString;
		this.natureString= natureString;
		this.subCategoryString= subCategoryString;
		this.durationString= durationString;
		this.maxPeople= maxPeople;
		this.dateAdded= dateAdded;
		this.popularity= popularity;
		this.minCost1= minCost1;
		this.minCost1People= minCost1People;
		this.minCost2= minCost2;
		this.minCost2People= minCost2People ;
		this.minCost3= minCost3 ;
		this.minCost3People =minCost3People;
		this.specialOfferPercentage= specialOfferPercentage ;
		this.specialRate= specialRate;
		this.photoUrl= photoUrl;
		this.imagefoldername=imagefoldername;
		this.tagName=tagName;
	}
		
		
		public String getAppId() {
		return appId;
	}


	public void setAppId(String appId) {
		this.appId = appId;
	}


	public String getParktype() {
		return parktype;
	}


	public void setParktype(String parktype) {
		this.parktype = parktype;
	}


	public String getParkSubcategory() {
		return parkSubcategory;
	}


	public void setParkSubcategory(String parkSubcategory) {
		this.parkSubcategory = parkSubcategory;
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


	public int getParkId() {
		return parkId;
	}


	public void setParkId(int parkId) {
		this.parkId = parkId;
	}


	public float getOdRating() {
		return odRating;
	}


	public void setOdRating(float odRating) {
		this.odRating = odRating;
	}


	public String getSponsoredFeaturedFlag() {
		return sponsoredFeaturedFlag;
	}


	public void setSponsoredFeaturedFlag(String sponsoredFeaturedFlag) {
		this.sponsoredFeaturedFlag = sponsoredFeaturedFlag;
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


	public Date getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
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


	public float getMinCost3() {
		return minCost3;
	}


	public void setMinCost3(float minCost3) {
		this.minCost3 = minCost3;
	}


	public float getMinCost3People() {
		return minCost3People;
	}


	public void setMinCost3People(float minCost3People) {
		this.minCost3People = minCost3People;
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


	public String getImagefoldername() {
		return imagefoldername;
	}


	public void setImagefoldername(String imagefoldername) {
		this.imagefoldername = imagefoldername;
	}


	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


		public ODGetParkInfoModel(){
			
		}

}
