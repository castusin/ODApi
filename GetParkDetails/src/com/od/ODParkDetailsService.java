package com.od;

import java.sql.Date;
import java.util.List;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

public class ODParkDetailsService {
	
	
	String description;
	String maxPeople;
	String maxAdults;
	String maxKids;
	//String currentAvailableQuantity;
	float currentPrice;
	String facilityTypeCode;
	String facilityType;
	String maxQty;
	//float regularPrice;
	/*Date dateAdded;
	Date date;*/
	String facilityTypeTitle;
	String facilityInRoomFacilites;
	String facilityImage;
	//String parkSubImages;
	//int parkId;
	
	public String parkMainImages;
	public String overviewText ;
	public String metro ;
	public String localArea;
	public String streetAddress;
	public String city;
	public String state;
	public String pin;
	public String name;
	
	public String details;
		/*public float odRating;

	
	
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
	*/
	public String amenitiesString;
	public String addonPath;
	public String addonName;
	
	public String parkRoomFac;
	public int addonId;
	public int discount;
	public String discountMode;
	
	public String inclusions;
	public String status;
	
	public Object packageItems; 

	public ODParkDetailsService(String description, String maxPeople,
			String maxAdults, String maxKids, String currentAvailableQuantity,
			float currentPrice, String facilityTypeCode, String facilityType,
			String maxQty, float regularPrice, Date dateAdded, Date date,
			String facilityTypeTitle, String facilityInRoomFacilites,
			String facilityImage, int parkId, String overviewText, String metro, String localArea, String streetAddress, String city, String state, String pin, String name, String details, float odRating, double latitude, double longitude, String typeString, String natureString, String subCategoryString, String durationString, String popularity, float minCost1, float minCost1People, float minCost2, float minCost2People, float specialOfferPercentage, float specialRate, String photoUrl, String amenitiesString, String parkSubImages, String parkRoomFac, int discount, String discountMode, Object packageItems, String addonPath, int addonId, String parkMainImages, String inclusions, String status) {
		super();
		this.description = description;
		this.maxPeople = maxPeople;
		this.maxAdults = maxAdults;
		this.maxKids = maxKids;
		//this.currentAvailableQuantity = currentAvailableQuantity;
		this.currentPrice = currentPrice;
		this.facilityTypeCode = facilityTypeCode;
		this.facilityType = facilityType;
		this.maxQty = maxQty;
		//this.regularPrice = regularPrice;
		//this.dateAdded = dateAdded;
		//this.date = date;
		this.facilityTypeTitle = facilityTypeTitle;
		this.facilityInRoomFacilites = facilityInRoomFacilites;
		this.facilityImage = facilityImage;
		this.addonId=addonId;
		//this.parkId=parkId;
		//this.parkSubImages=parkSubImages;
		/*this.overviewText=overviewText;
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
		this.amenitiesString=amenitiesString;*/
		
		this.parkRoomFac=parkRoomFac;
		this.discount=discount;
		this.discountMode=discountMode;
		this.packageItems=packageItems;
		
		this.addonPath=addonPath;
		this.amenitiesString=amenitiesString;
		this.parkMainImages=parkMainImages;
		
		this.inclusions=inclusions;
		this.status=status;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getInclusions() {
		return inclusions;
	}


	public void setInclusions(String inclusions) {
		this.inclusions = inclusions;
	}


	public String getParkMainImages() {
		return parkMainImages;
	}


	public void setParkMainImages(String parkMainImages) {
		this.parkMainImages = parkMainImages;
	}


	public int getAddonId() {
		return addonId;
	}


	public void setAddonId(int addonId) {
		this.addonId = addonId;
	}


	public String getAmenitiesString() {
		return amenitiesString;
	}


	public void setAmenitiesString(String amenitiesString) {
		this.amenitiesString = amenitiesString;
	}


	


	public String getAddonPath() {
		return addonPath;
	}


	public void setAddonPath(String addonPath) {
		this.addonPath = addonPath;
	}


	public String getAddonName() {
		return addonName;
	}


	public void setAddonName(String addonName) {
		this.addonName = addonName;
	}


	public Object getPackageItems() {
		return packageItems;
	}


	public void setPackageItems(Object packageItems) {
		this.packageItems = packageItems;
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


	public String getParkRoomFac() {
		return parkRoomFac;
	}


	public void setParkRoomFac(String parkRoomFac) {
		this.parkRoomFac = parkRoomFac;
	}


	







	public float getCurrentPrice() {
		return currentPrice;
	}







	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
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







	/*public int getParkId() {
		return parkId;
	}







	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
*/






	public ODParkDetailsService(){
		
	}
	

}
